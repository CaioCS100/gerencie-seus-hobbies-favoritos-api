package br.com.gerenciarhobbies.repository.impl;

import br.com.gerenciarhobbies.domain.Genero;
import br.com.gerenciarhobbies.repository.GeneroRepositoryJdbc;
import br.com.gerenciarhobbies.repository.mapper.GeneroMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static br.com.gerenciarhobbies.shared.Constantes.SIMBOLO_PORCENTAGEM;
import static br.com.gerenciarhobbies.shared.Queries.Genero.*;

@Repository
public class GeneroRepositoryJdbcImpl implements GeneroRepositoryJdbc {

    private JdbcTemplate jdbcTemplate;

    public GeneroRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void salvar(Genero genero) {
        this.jdbcTemplate.update(SQL_INSERIR_GENERO, genero.getDescricao());
    }

    @Override
    public Genero buscar(Long id) {
        Genero genero = new Genero().id(id);

        return this.jdbcTemplate.queryForObject(
                obterSqlConsulta(genero),
                obterParametrosConsulta(genero),
                new GeneroMapper());
    }

    @Override
    public List<Genero> listar() {
        Genero genero = new Genero();

        return this.jdbcTemplate.query(obterSqlConsulta(genero),
                obterParametrosConsulta(genero),
                new GeneroMapper());
    }

    private String obterSqlConsulta(Genero genero) {
        StringBuilder sql = new StringBuilder(SQL_CONSULTAR_GENERO);

        if (genero.getId() != null)
            sql.append(" AND id = ?");

        if (genero.getDescricao() != null)
            sql.append(" AND descricao ilke ?");

        return sql.toString();
    }

    private Object[] obterParametrosConsulta(Genero genero) {
        List<Object> parametros = new ArrayList<>();

        if (genero.getId() != null)
            parametros.add(genero.getId());

        if (genero.getDescricao() != null)
            parametros.add(SIMBOLO_PORCENTAGEM + genero.getDescricao() + SIMBOLO_PORCENTAGEM);

        return parametros.toArray();
    }
}
