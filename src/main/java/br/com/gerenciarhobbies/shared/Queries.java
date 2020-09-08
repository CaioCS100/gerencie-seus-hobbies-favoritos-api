package br.com.gerenciarhobbies.shared;

public interface Queries {

    interface Genero {
        String SQL_INSERIR_GENERO =
                "INSERT INTO hobbies.generos (descricao) VALUES(?)";

        String SQL_ATUALIZAR_GENERO =
                "UPDATE hobbies.generos SET descricao = ?, data_ultima_modificacao = ?  WHERE id = ?";

        String SQL_CONSULTAR_GENERO =
                "SELECT id, descricao, data_criacao, data_ultima_modificacao FROM hobbies.generos WHERE 1 = 1";
    }

}
