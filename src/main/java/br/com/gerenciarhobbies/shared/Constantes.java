package br.com.gerenciarhobbies.shared;

public interface Constantes {

    String SIMBOLO_PORCENTAGEM = "%";

    interface URI {
        String URI_AUTOR = "api/autores";
        String URI_GENERO = "api/generos";
        String URI_USUARIO = "api/usuarios";
        String URI_AUTENTICACAO = "api/autenticacao";
    }

    interface CAMPOS_OBRIGATORIOS {
        String DESCRICAO = "O campo Descrição é de preenchimento obrigatório.";
        String NOME = "O campo Nome é de preenchimento obrigatório.";
        String EMAIL = "O campo Email é de preenchimento obrigatório.";
        String LOGIN = "O campo Login é de preenchimento obrigatório.";
        String SENHA = "O campo Senha é de preenchimento obrigatório.";
        String DATA_NASCIMENTO = "O campo Data de Nascimento é de preenchimento obrigatório.";
        String SEXO = "O campo Sexo é de preenchimento obrigatório.";
    }

    interface Mensagens {
        String ID_OBRIGATORIO = "O Id é um campo de preenchimento obrigatório!";
        String CAMPO_OBRIGATORIO = "Esse campo é de preenchimento obrigatório.";
        String GENERO_NAO_ENCONTRADO = "Não existe um gênero com Id: ";
        String GENERO_JA_CADASTRADO = "Esse gênero já está cadastrado no sistema!";

        String EMAIL_EXISTENTE = "Esse email já está cadastrado!";
        String AUTOR_NAO_ENCONTRADO = "O autor com o Id %s não foi encontrado";
    }
}
