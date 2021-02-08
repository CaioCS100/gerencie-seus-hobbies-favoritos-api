package br.com.gerenciarhobbies.shared.dto;

import java.util.Date;
import java.util.Objects;

public class TokenDTO {

    private String token;
    private Date horaCriacaoToken;
    private Date horaExpiracaoToken;

    public TokenDTO() {}

    public TokenDTO(String token, Date horaCriacaoToken, Date horaExpiracaoToken) {
        this.token = token;
        this.horaCriacaoToken = horaCriacaoToken;
        this.horaExpiracaoToken = horaExpiracaoToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getHoraCriacaoToken() {
        return horaCriacaoToken;
    }

    public void setHoraCriacaoToken(Date horaCriacaoToken) {
        this.horaCriacaoToken = horaCriacaoToken;
    }

    public Date getHoraExpiracaoToken() {
        return horaExpiracaoToken;
    }

    public void setHoraExpiracaoToken(Date horaExpiracaoToken) {
        this.horaExpiracaoToken = horaExpiracaoToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenDTO tokenDTO = (TokenDTO) o;
        return Objects.equals(token, tokenDTO.token) &&
                Objects.equals(horaCriacaoToken, tokenDTO.horaCriacaoToken) &&
                Objects.equals(horaExpiracaoToken, tokenDTO.horaExpiracaoToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, horaCriacaoToken, horaExpiracaoToken);
    }

    @Override
    public String toString() {
        return "TokenDTO{" +
                "token='" + token + '\'' +
                ", horaCriacaoToken=" + horaCriacaoToken +
                ", horaExpiracaoToken=" + horaExpiracaoToken +
                '}';
    }
}
