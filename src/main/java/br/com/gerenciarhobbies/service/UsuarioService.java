package br.com.gerenciarhobbies.service;

import br.com.gerenciarhobbies.domain.Usuario;
import br.com.gerenciarhobbies.shared.dto.LoginDTO;

public interface UsuarioService {

    Usuario salvar(Usuario usuario);

    void autenticar(LoginDTO loginDTO);
}
