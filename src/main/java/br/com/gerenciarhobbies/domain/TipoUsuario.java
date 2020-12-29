package br.com.gerenciarhobbies.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(schema = "hobbies", name = "tipos_usuarios")
public class TipoUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Column
    private String descricao;

    @Column(name = "data_criacao", updatable = false)
    @CreationTimestamp
    private LocalDateTime dataCricao;

    @Column(name = "data_ultima_modificacao")
    @CreationTimestamp
    private LocalDateTime dataUltimaModificao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(LocalDateTime dataCricao) {
        this.dataCricao = dataCricao;
    }

    public LocalDateTime getDataUltimaModificao() {
        return dataUltimaModificao;
    }

    public void setDataUltimaModificao(LocalDateTime dataUltimaModificao) {
        this.dataUltimaModificao = dataUltimaModificao;
    }

    public TipoUsuario id(Long id) {
        this.id = id;
        return this;
    }

    public TipoUsuario descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public TipoUsuario dataCricao(LocalDateTime dataCricao) {
        this.dataCricao = dataCricao;
        return this;
    }

    public TipoUsuario dataUltimaModificao(LocalDateTime dataUltimaModificao) {
        this.dataUltimaModificao = dataUltimaModificao;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoUsuario that = (TipoUsuario) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(dataCricao, that.dataCricao) &&
                Objects.equals(dataUltimaModificao, that.dataUltimaModificao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TipoUsuario{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataCricao=" + dataCricao +
                ", dataUltimaModificao=" + dataUltimaModificao +
                '}';
    }
}
