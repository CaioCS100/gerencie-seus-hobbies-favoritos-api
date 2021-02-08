package br.com.gerenciarhobbies.service.impl;

import br.com.gerenciarhobbies.domain.TipoUsuario;
import br.com.gerenciarhobbies.domain.Usuario;
import br.com.gerenciarhobbies.exception.RecursoExistenteException;
import br.com.gerenciarhobbies.repository.UsuarioRepository;
import br.com.gerenciarhobbies.security.jwt.TokenProvider;
import br.com.gerenciarhobbies.service.UsuarioService;
import br.com.gerenciarhobbies.shared.dto.LoginDTO;
import br.com.gerenciarhobbies.shared.dto.TokenDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.*;
import static br.com.gerenciarhobbies.shared.enums.TipoDoUsuario.COMUM;
import static br.com.gerenciarhobbies.util.HashUtil.gerarSenhaCriptografada;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              AuthenticationManager authenticationManager,
                              TokenProvider tokenProvider) {
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        validarEmailCadastro(usuario.getEmail());
        validarLoginCadastro(usuario.getLogin());
        usuario
                .id(null)
                .email(usuario.getEmail().toUpperCase())
                .login(usuario.getLogin().toUpperCase())
                .tipoUsuario(new TipoUsuario()
                        .id(COMUM.getCodigo()))
                .senha(gerarSenhaCriptografada(usuario.getSenha()));

        return this.usuarioRepository.save(usuario);
    }

    @Override
    public TokenDTO autenticar(LoginDTO loginDTO) {
        Authentication authentication = validarAutenticacao(loginDTO);
        return this.tokenProvider.criarToken(authentication);
    }

    private void validarEmailCadastro(String email) {
        if (this.usuarioRepository.countByEmailIgnoreCase(email) > 0)
            throw new RecursoExistenteException(EMAIL_EXISTENTE);
    }

    private void validarLoginCadastro(String login) {
        if (this.usuarioRepository.countByLoginIgnoreCase(login) > 0)
            throw new RecursoExistenteException(LOGIN_EXISTENTE);
    }

    private Authentication validarAutenticacao(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDTO.getLogin(), loginDTO.getSenha());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }
}
