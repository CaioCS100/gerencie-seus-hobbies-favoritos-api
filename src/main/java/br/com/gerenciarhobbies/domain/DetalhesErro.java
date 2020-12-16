package br.com.gerenciarhobbies.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class DetalhesErro {

    private Integer status;
    private String mensagem;

    @JsonFormat(pattern = "dd/MM/yyyy 'às' HH:mm:ss")
    private Date horario;

    public DetalhesErro() {}

    public DetalhesErro(Integer status, String mensagem, Date horario) {
        this.status = status;
        this.mensagem = mensagem;
        this.horario = horario;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public DetalhesErro status(Integer status) {
        this.status = status;
        return this;
    }

    public DetalhesErro mensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public DetalhesErro horario(Date horario) {
        this.horario = horario;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalhesErro that = (DetalhesErro) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(mensagem, that.mensagem) &&
                Objects.equals(horario, that.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, mensagem, horario);
    }

    @Override
    public String toString() {
        return "DetalhesErro{" +
                "status=" + status +
                ", mensagem='" + mensagem + '\'' +
                ", horario=" + horario +
                '}';
    }
}
