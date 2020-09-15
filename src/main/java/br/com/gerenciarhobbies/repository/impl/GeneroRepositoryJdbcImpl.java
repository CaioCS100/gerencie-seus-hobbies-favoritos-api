package br.com.gerenciarhobbies.repository.impl;

import br.com.gerenciarhobbies.domain.Genero;
import br.com.gerenciarhobbies.exception.RecursoNaoEncontradoException;
import br.com.gerenciarhobbies.repository.GeneroRepositoryJdbc;
import br.com.gerenciarhobbies.repository.mapper.GeneroMapper;
import br.com.gerenciarhobbies.repository.mapper.UltimoIdCadastradoMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.gerenciarhobbies.shared.Constantes.Mensagens.GENERO_NAO_ENCONTRADO;
import static br.com.gerenciarhobbies.shared.Constantes.SIMBOLO_PORCENTAGEM;
import static br.com.gerenciarhobbies.shared.Queries.Genero.*;
import static br.com.gerenciarhobbies.util.VerificadorUtil.*;

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
            throw new RecursoNaoEncontradoException(GENERO_NAO_ENCONTRADO + id);
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

    @Override
    public Boolean verificarSeDescricaoExiste(Genero genero) {
        List<Genero> listaGeneros = this.jdbcTemplate.query(
                obterSqlConsultaDescricaoExistente(genero),
                obterParametrosConsulta(genero),
                new GeneroMapper());

        return listaNulaOuVazia(listaGeneros) ? false : true;
    }

    private String obterSqlConsulta(Genero genero) {
        StringBuilder sql = new StringBuilder(SQL_CONSULTAR_GENERO);

        if (naoEstaNulo(genero.getId()))
            sql.append(" AND id = ?");

        if (naoEstaNulo(genero.getDescricao()))
            sql.append(" AND descricao ilike ?");

        return sql.toString();
    }

    private String obterSqlConsultaDescricaoExistente(Genero genero) {
        StringBuilder sql = new StringBuilder(SQL_CONSULTAR_DESCRICAO_EXISTENTE);

        if (naoEstaNulo(genero.getId()))
            sql.append(" AND id <> ?");

        if (naoEstaNulo(genero.getDescricao()))
            sql.append(" AND descricao ilike ?");

        return sql.toString();
    }

    private Object[] obterParametrosConsulta(Genero genero) {
        List<Object> parametros = new ArrayList<>();

        if (naoEstaNulo(genero.getId()))
            parametros.add(genero.getId());

        if (naoEstaNulo(genero.getDescricao()))
            parametros.add(SIMBOLO_PORCENTAGEM + genero.getDescricao() + SIMBOLO_PORCENTAGEM);

        return parametros.toArray();
    }

    private Long retornarUltimoIdCadastrado() {
        return jdbcTemplate.queryForObject(
                SQL_CONSULTAR_ID_CADASTRADO,
                new UltimoIdCadastradoMapper());
    }
}
