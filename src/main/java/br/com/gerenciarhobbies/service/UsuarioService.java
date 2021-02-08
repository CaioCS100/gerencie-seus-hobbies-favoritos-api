package br.com.gerenciarhobbies.service;

import br.com.gerenciarhobbies.domain.Usuario;
import br.com.gerenciarhobbies.shared.dto.LoginDTO;
import br.com.gerenciarhobbies.shared.dto.TokenDTO;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    TokenDTO autenticar(LoginDTO loginDTO);
}
