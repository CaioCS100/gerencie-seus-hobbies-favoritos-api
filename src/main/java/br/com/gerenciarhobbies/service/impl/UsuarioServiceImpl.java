package br.com.gerenciarhobbies.service.impl;

import br.com.gerenciarhobbies.domain.TipoUsuario;
import br.com.gerenciarhobbies.domain.Usuario;
import br.com.gerenciarhobbies.exception.CredenciaisException;
import br.com.gerenciarhobbies.exception.RecursoExistenteException;
import br.com.gerenciarhobbies.repository.UsuarioRepository;
import br.com.gerenciarhobbies.service.UsuarioService;
import br.com.gerenciarhobbies.shared.dto.LoginDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.*;
import static br.com.gerenciarhobbies.shared.enums.TipoDoUsuario.COMUM;
import static br.com.gerenciarhobbies.util.HashUtil.gerarSenhaCriptografada;
import static br.com.gerenciarhobbies.util.HashUtil.validarSenha;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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
    public void autenticar(LoginDTO loginDTO) {
        Optional<Usuario> usuarioConsultado = this.usuarioRepository.findByEmailIgnoreCaseOrLoginIgnoreCase(
                loginDTO.getLogin(), loginDTO.getLogin());

        if (usuarioConsultado.isPresent())
            System.out.println(validarSenha(loginDTO.getSenha(), usuarioConsultado.get().getSenha()));
        else
            throw new CredenciaisException(LOGIN_INCORRETO);
    }

    private void validarEmailCadastro(String email) {
        if (this.usuarioRepository.countByEmailIgnoreCase(email) > 0)
            throw new RecursoExistenteException(EMAIL_EXISTENTE);
    }

    private void validarLoginCadastro(String login) {
        if (this.usuarioRepository.countByLoginIgnoreCase(login) > 0)
            throw new RecursoExistenteException(LOGIN_EXISTENTE);
    }
}
