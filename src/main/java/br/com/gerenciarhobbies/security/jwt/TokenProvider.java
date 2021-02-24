package br.com.gerenciarhobbies.security.jwt;

import br.com.gerenciarhobbies.security.UsuarioSistema;
import br.com.gerenciarhobbies.shared.dto.TokenDTO;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.*;
import static br.com.gerenciarhobbies.util.DataUtil.dataAtual;
import static br.com.gerenciarhobbies.util.VerificadorUtil.naoEstaNulo;

@Component
public class TokenProvider {

    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

    private final JwtHelper jwtHelper;

    public TokenProvider(JwtHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    public TokenDTO criarToken(Authentication authentication) {
        Date dataAtual = dataAtual();
        Calendar dataExpiracao = Calendar.getInstance();
        dataExpiracao.add(Calendar.HOUR_OF_DAY, 1);

        String token = Jwts.builder()
                .setClaims(obterInformacoesToken(authentication))
                .setIssuedAt(dataAtual)
                .setExpiration(dataExpiracao.getTime())
                .signWith(this.jwtHelper.obterSecretKey(), SignatureAlgorithm.HS512)
                .compact();

        return new TokenDTO(token, dataAtual, dataExpiracao.getTime());
    }

    public boolean validarToken(String token) {
        Claims claims = null;

        try {
            claims = this.jwtHelper.obterClaims(token);
        } catch (SecurityException | MalformedJwtException | io.jsonwebtoken.security.SignatureException ex) {
            log.info(String.format(ASSINATURA_TOKEN_INVALIDA, ex.getMessage()));
        } catch (ExpiredJwtException ex) {
            log.info(String.format(TOKEN_EXPIRADO, ex.getMessage()));
        } catch (UnsupportedJwtException ex) {
            log.info(String.format(TOKEN_NAO_SUPORTADO, ex.getMessage()));
        } catch (IllegalArgumentException ex) {
            log.info(String.format(COMPACTACAO_TOKEN_INVALIDA, ex.getMessage()));
        }

        return naoEstaNulo(claims);
    }

    public Authentication getAuthentication(String token) {
        Claims claims = this.jwtHelper.obterClaims(token);
        Collection<? extends GrantedAuthority> authorities = obterPermissoesToken(claims);
        User principal = new User(claims.get("email_usuario").toString(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    private Map<String, Object> obterInformacoesToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>();
        UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();

        claims.put("id_usuario", usuarioSistema.getUsuario().getId());
        claims.put("email_usuario", usuarioSistema.getUsuario().getEmail());
        claims.put("permissoes", retornarPermissoesComcatenadas(authentication));

        return claims;
    }

    private String retornarPermissoesComcatenadas(Authentication authentication) {
        return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    private List<SimpleGrantedAuthority> obterPermissoesToken(Claims claims) {
        return Arrays.stream(claims.get("permissoes").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
