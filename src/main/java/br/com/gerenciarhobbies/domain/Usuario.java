package br.com.gerenciarhobbies.domain;

import br.com.gerenciarhobbies.shared.enums.TipoUsuario;

import java.time.LocalDateTime;

public class Usuario {
    //depois estudar em como fazer o hash da senha
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String ultimaSenha;
    private TipoUsuario tipoUsuario;
    private LocalDateTime dataCricao;
    private LocalDateTime dataUltimaModificao;

}
