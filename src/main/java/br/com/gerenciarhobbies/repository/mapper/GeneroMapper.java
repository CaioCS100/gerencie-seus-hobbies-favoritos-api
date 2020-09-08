package br.com.gerenciarhobbies.repository.mapper;

import br.com.gerenciarhobbies.domain.Genero;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GeneroMapper implements RowMapper<Genero> {

    @Override
    public Genero mapRow(ResultSet rs, int i) throws SQLException {
        Genero genero = new Genero();
        genero.setId(rs.getLong("id"));
        genero.setDescricao(rs.getString("descricao"));
        genero.setDataCricao(obterDataNaoNula(rs.getTimestamp("data_criacao")));
        genero.setDataUltimaModificao(obterDataNaoNula(rs.getTimestamp("data_ultima_modificacao")));
        return genero;
    }

    public LocalDateTime obterDataNaoNula(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
