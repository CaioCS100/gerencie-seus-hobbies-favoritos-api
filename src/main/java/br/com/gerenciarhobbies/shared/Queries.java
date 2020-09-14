package br.com.gerenciarhobbies.shared;

public interface Queries {

    interface Genero {
        String SQL_INSERIR_GENERO =
                "INSERT INTO hobbies.generos (descricao) VALUES(?)";

        String SQL_CONSULTAR_ID_CADASTRADO =
                "SELECT currval(pg_get_serial_sequence('hobbies.generos', 'id')) as id_cadastrado";

        String SQL_ATUALIZAR_GENERO =
                "UPDATE hobbies.generos SET descricao = ?, data_ultima_modificacao = ?  WHERE id = ?";

        String SQL_CONSULTAR_GENERO =
                "SELECT id, descricao, data_criacao, data_ultima_modificacao FROM hobbies.generos WHERE 1 = 1";

        String SQL_DELETAR_GENERO =
                "DELETE FROM hobbies.generos WHERE id = ?";
    }

}
