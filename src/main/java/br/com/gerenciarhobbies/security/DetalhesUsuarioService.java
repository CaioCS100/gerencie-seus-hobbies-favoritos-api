package br.com.gerenciarhobbies.security;

import br.com.gerenciarhobbies.domain.Usuario;
import br.com.gerenciarhobbies.exception.CredenciaisException;
import br.com.gerenciarhobbies.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.LOGIN_INCORRETO;

@Service
public class DetalhesUsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public DetalhesUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository
                .findByEmailIgnoreCaseOrLoginIgnoreCase(login, login)
                .orElseThrow(() -> new CredenciaisException(LOGIN_INCORRETO));

        return new UsuarioSistema(usuario, obterPermissoes());
    }

    private Collection<? extends GrantedAuthority> obterPermissoes() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_GERAL"));
        return authorities;
    }
}
