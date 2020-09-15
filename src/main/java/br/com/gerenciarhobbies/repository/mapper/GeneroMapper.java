package br.com.gerenciarhobbies.repository.mapper;

import br.com.gerenciarhobbies.domain.Genero;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static br.com.gerenciarhobbies.util.BancoUtil.*;

public class GeneroMapper implements RowMapper<Genero> {

    @Override
    public Genero mapRow(ResultSet rs, int i) throws SQLException {
        Genero genero = new Genero();
        genero.setId(recuperarValorLong(rs, "id"));
        genero.setDescricao(recuperarValorString(rs, "descricao"));
        genero.setDataCricao(obterDataNaoNula(recuperarValorTimestamp(rs, "data_criacao")));
        genero.setDataUltimaModificao(obterDataNaoNula(recuperarValorTimestamp(rs, "data_ultima_modificacao")));
        return genero;
    }

    public LocalDateTime obterDataNaoNula(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
