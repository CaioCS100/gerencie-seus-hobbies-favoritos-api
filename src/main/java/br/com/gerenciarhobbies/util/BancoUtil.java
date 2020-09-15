package br.com.gerenciarhobbies.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BancoUtil {

    public static Long recuperarValorLong(ResultSet rs, String nomeColuna) {
        try {
            return rs.getLong(nomeColuna);
        } catch (SQLException ex) {
            return null;
        }
    }

    public static String recuperarValorString(ResultSet rs, String nomeColuna) {
        try {
            return rs.getString(nomeColuna);
        } catch (SQLException throwables) {
            return null;
        }
    }

    public static Timestamp recuperarValorTimestamp(ResultSet rs, String nomeColuna) {
        try {
            return rs.getTimestamp(nomeColuna);
        } catch (SQLException throwables) {
            return null;
        }
    }
}
