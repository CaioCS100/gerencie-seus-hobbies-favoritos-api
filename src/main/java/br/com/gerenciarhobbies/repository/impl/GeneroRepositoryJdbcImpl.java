package br.com.gerenciarhobbies.repository.impl;

import br.com.gerenciarhobbies.domain.Genero;
import br.com.gerenciarhobbies.repository.GeneroRepositoryJdbc;
import br.com.gerenciarhobbies.repository.mapper.GeneroMapper;
import br.com.gerenciarhobbies.repository.mapper.UltimoIdCadastradoMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
    public Genero salvar(Genero genero) {
        this.jdbcTemplate.update(SQL_INSERIR_GENERO, genero.getDescricao());
        Long id = retornarUltimoIdCadastrado();
        return buscar(id);
    }

    @Override
    public Genero atualizar(Genero genero) {
        LocalDateTime localDateTime = LocalDateTime.now();
        this.jdbcTemplate.update(SQL_ATUALIZAR_GENERO, genero.getDescricao(), localDateTime, genero.getId());
        return buscar(genero.getId());
    }

    @Override
    public Genero buscar(Long id) {
        try {
            Genero genero = new Genero().id(id);

            return this.jdbcTemplate.queryForObject(
                    obterSqlConsulta(genero),
                    obterParametrosConsulta(genero),
                    new GeneroMapper());
        } catch (EmptyResultDataAccessException ex) {
            return new Genero();
        }
    }

    @Override
    public List<Genero> listar() {
        return this.jdbcTemplate.query(SQL_CONSULTAR_GENERO, new GeneroMapper());
    }

    @Override
    public void deletar(Long id) {
        this.jdbcTemplate.update(SQL_DELETAR_GENERO, id);
    }

    private String obterSqlConsulta(Genero genero) {
        StringBuilder sql = new StringBuilder(SQL_CONSULTAR_GENERO);

        if (genero.getId() != null)
            sql.append(" AND id = ?");

        if (genero.getDescricao() != null)
            sql.append(" AND descricao ilke ?");

        return sql.toString();
    }

    private Long retornarUltimoIdCadastrado() {
        return jdbcTemplate.queryForObject(
                SQL_CONSULTAR_ID_CADASTRADO,
                new UltimoIdCadastradoMapper());
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
