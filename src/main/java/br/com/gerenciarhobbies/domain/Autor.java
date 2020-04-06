package br.com.gerenciarhobbies.domain;


import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Table(schema = "hobbies", name = "autores")
@Entity
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull(message = MENSAGEM_CAMPO_OBRIGATORIO)
    @Column
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "nome_artistico")
    private String nomeArtistico;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = MENSAGEM_CAMPO_OBRIGATORIO)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @NotNull(message = MENSAGEM_CAMPO_OBRIGATORIO)
    @Column
    private String sexo;

    @NotNull(message = MENSAGEM_CAMPO_OBRIGATORIO)
    @Column
    private String telefone;

    @NotNull(message = MENSAGEM_CAMPO_OBRIGATORIO)
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(getId(), autor.getId()) &&
                Objects.equals(getNome(), autor.getNome()) &&
                Objects.equals(getNomeArtistico(), autor.getNomeArtistico()) &&
                Objects.equals(getDataNascimento(), autor.getDataNascimento()) &&
                Objects.equals(getSexo(), autor.getSexo()) &&
                Objects.equals(getTelefone(), autor.getTelefone()) &&
                Objects.equals(getEmail(), autor.getEmail()) &&
                Objects.equals(getDataHoraCriacao(), autor.getDataHoraCriacao()) &&
                Objects.equals(getDataHoraUltimaModificacao(), autor.getDataHoraUltimaModificacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getNomeArtistico(), getDataNascimento(), getSexo(), getTelefone(), getEmail());
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeArtistico='" + nomeArtistico + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", dataHoraCriacao=" + dataHoraCriacao +
                ", dataHoraUltimaModificacao=" + dataHoraUltimaModificacao +
                '}';
    }
}
