package br.com.gerenciarhobbies.security.jwt;

import br.com.gerenciarhobbies.security.UsuarioSistema;
import br.com.gerenciarhobbies.shared.dto.TokenDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static br.com.gerenciarhobbies.util.DataUtil.dataAtual;

@Component
public class TokenProvider {

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
}
