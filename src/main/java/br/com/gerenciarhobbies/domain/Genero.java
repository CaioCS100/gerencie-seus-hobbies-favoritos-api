package br.com.gerenciarhobbies.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(schema = "hobbies", name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @NotEmpty
    @Column
    private String descricao;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCricao;

    @Column(name = "data_ultima_modificacao")
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

    public Genero id(Long id) {
        this.id = id;
        return this;
    }

    public Genero descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Genero dataCricao(LocalDateTime dataCricao) {
        this.dataCricao = dataCricao;
        return this;
    }

    public Genero dataUltimaModificao(LocalDateTime dataUltimaModificao) {
        this.dataUltimaModificao = dataUltimaModificao;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(id, genero.id) &&
                Objects.equals(descricao, genero.descricao) &&
                Objects.equals(dataCricao, genero.dataCricao) &&
                Objects.equals(dataUltimaModificao, genero.dataUltimaModificao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataCricao, dataUltimaModificao);
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataCricao=" + dataCricao +
                ", dataUltimaModificao=" + dataUltimaModificao +
                '}';
    }
}
