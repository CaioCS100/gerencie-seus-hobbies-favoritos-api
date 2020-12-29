package br.com.gerenciarhobbies.service.impl;

import br.com.gerenciarhobbies.domain.TipoUsuario;
import br.com.gerenciarhobbies.domain.Usuario;
import br.com.gerenciarhobbies.repository.UsuarioRepository;
import br.com.gerenciarhobbies.service.UsuarioService;
import br.com.gerenciarhobbies.shared.dto.LoginDTO;
import br.com.gerenciarhobbies.util.BCryptUtil;
import br.com.gerenciarhobbies.util.HashUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static br.com.gerenciarhobbies.shared.enums.TipoDoUsuario.COMUM;
import static br.com.gerenciarhobbies.util.HashUtil.*;
import static br.com.gerenciarhobbies.util.VerificadorUtil.naoEstaNulo;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario
                .id(null)
                .tipoUsuario(new TipoUsuario()
                        .id(COMUM.getCodigo()))
                .senha(gerarSenhaCriptografada(usuario.getSenha()));

        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void autenticar(LoginDTO loginDTO) {
        Optional<Usuario> usuarioConsultado = this.usuarioRepository.findByEmail(loginDTO.getEmail());

        if (usuarioConsultado.isPresent())
            System.out.println(validarSenha(loginDTO.getSenha(), usuarioConsultado.get().getSenha()));
        else
            throw new ServiceException("Login ou Senha incorretos");

    }
}
