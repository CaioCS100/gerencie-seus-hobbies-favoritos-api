package br.com.gerenciarhobbies.repository.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UltimoIdCadastradoMapper implements RowMapper<Long> {

    @Override
    public Long mapRow(ResultSet rs, int i) throws SQLException {
        Long idCadastrado = rs.getLong("id_cadastrado");
        return idCadastrado;
    }
}
