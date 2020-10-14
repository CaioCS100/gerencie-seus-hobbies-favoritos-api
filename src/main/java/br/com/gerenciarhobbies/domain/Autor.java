package br.com.gerenciarhobbies.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.CAMPO_OBRIGATORIO;

@Table(schema = "hobbies", name = "autores")
@Entity
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull(message = CAMPO_OBRIGATORIO)
    @Column
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "nome_artistico")
    private String nomeArtistico;

    @NotNull(message = CAMPO_OBRIGATORIO)
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotNull(message = CAMPO_OBRIGATORIO)
    @Column
    private String sexo;

    @NotNull(message = CAMPO_OBRIGATORIO)
    @Column(unique = true)
    private String email;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "data_hora_criacao", updatable = false)
    private LocalDateTime dataHoraCriacao;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "data_hora_ultima_modificacao")
    private LocalDateTime dataHoraUltimaModificacao;

    public Autor() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraUltimaModificacao() {
        return dataHoraUltimaModificacao;
    }

    public void setDataHoraUltimaModificacao(LocalDateTime dataHoraUltimaModificacao) {
        this.dataHoraUltimaModificacao = dataHoraUltimaModificacao;
    }

    public Autor id(Long id) {
        this.id = id;
        return this;
    }

    public Autor nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Autor nomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
        return this;
    }

    public Autor dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public Autor sexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public Autor email(String email) {
        this.email = email;
        return this;
    }

    public Autor dataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
        return this;
    }

    public Autor dataHoraUltimaModificacao(LocalDateTime dataHoraUltimaModificacao) {
        this.dataHoraUltimaModificacao = dataHoraUltimaModificacao;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) &&
                Objects.equals(nome, autor.nome) &&
                Objects.equals(nomeArtistico, autor.nomeArtistico) &&
                Objects.equals(dataNascimento, autor.dataNascimento) &&
                Objects.equals(sexo, autor.sexo) &&
                Objects.equals(email, autor.email) &&
                Objects.equals(dataHoraCriacao, autor.dataHoraCriacao) &&
                Objects.equals(dataHoraUltimaModificacao, autor.dataHoraUltimaModificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeArtistico, email,  dataHoraCriacao, dataHoraUltimaModificacao);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeArtistico='" + nomeArtistico + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                ", email='" + email + '\'' +
                ", dataHoraCriacao=" + dataHoraCriacao +
                ", dataHoraUltimaModificacao=" + dataHoraUltimaModificacao +
                '}';
    }
}
