package br.com.gerenciarhobbies.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static br.com.gerenciarhobbies.shared.Constantes.CAMPOS_OBRIGATORIOS.*;

@Entity
@Table(schema = "hobbies", name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull(message = NOME)
    @Column
    private String nome;

    @NotNull(message = EMAIL)
    @Column
    private String email;

    @NotNull(message = LOGIN)
    @Column
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = SENHA)
    @Column
    private String senha;

    @JsonIgnore
    @Column(name = "ultima_senha")
    private String ultimaSenha;

    @NotNull(message = DATA_NASCIMENTO)
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotNull(message = SEXO)
    @Column
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;

    @Column(name = "data_hora_criacao")
    @CreationTimestamp
    private LocalDateTime dataHoraCricao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "data_hora_ultima_modificacao")
    @CreationTimestamp
    private LocalDateTime dataHoraUltimaModificao;

    public Usuario() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getUltimaSenha() {
        return ultimaSenha;
    }

    public void setUltimaSenha(String ultimaSenha) {
        this.ultimaSenha = ultimaSenha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public LocalDateTime getDataHoraCricao() {
        return dataHoraCricao;
    }

    public void setDataHoraCricao(LocalDateTime dataHoraCricao) {
        this.dataHoraCricao = dataHoraCricao;
    }

    public LocalDateTime getDataHoraUltimaModificao() {
        return dataHoraUltimaModificao;
    }

    public void setDataHoraUltimaModificao(LocalDateTime dataHoraUltimaModificao) {
        this.dataHoraUltimaModificao = dataHoraUltimaModificao;
    }

    public Usuario id(Long id) {
        this.id = id;
        return this;
    }

    public Usuario nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Usuario email(String email) {
        this.email = email;
        return this;
    }

    public Usuario login(String login) {
        this.login = login;
        return this;
    }

    public Usuario senha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario ultimaSenha(String ultimaSenha) {
        this.ultimaSenha = ultimaSenha;
        return this;
    }

    public Usuario tipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        return this;
    }

    public Usuario dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public Usuario sexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public Usuario dataHoraCricao(LocalDateTime dataHoraCricao) {
        this.dataHoraCricao = dataHoraCricao;
        return this;
    }

    public Usuario dataHoraUltimaModificao(LocalDateTime dataHoraUltimaModificao) {
        this.dataHoraUltimaModificao = dataHoraUltimaModificao;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(login, usuario.login) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(ultimaSenha, usuario.ultimaSenha) &&
                Objects.equals(dataNascimento, usuario.dataNascimento) &&
                Objects.equals(sexo, usuario.sexo) &&
                tipoUsuario == usuario.tipoUsuario &&
                Objects.equals(dataHoraCricao, usuario.dataHoraCricao) &&
                Objects.equals(dataHoraUltimaModificao, usuario.dataHoraUltimaModificao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, login);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", ultimaSenha='" + ultimaSenha + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", dataHoraCricao=" + dataHoraCricao +
                ", dataHoraUltimaModificao=" + dataHoraUltimaModificao +
                '}';
    }
}
