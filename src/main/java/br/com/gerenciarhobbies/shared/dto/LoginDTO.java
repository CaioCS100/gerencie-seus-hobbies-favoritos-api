package br.com.gerenciarhobbies.shared.dto;

import java.io.Serializable;
import java.util.Objects;

public class LoginDTO implements Serializable {

    private String login;
    private String senha;

    public LoginDTO() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(login, loginDTO.login) &&
                Objects.equals(senha, loginDTO.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, senha);
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
