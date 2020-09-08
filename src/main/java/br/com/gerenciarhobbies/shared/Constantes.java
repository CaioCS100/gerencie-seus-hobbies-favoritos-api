package br.com.gerenciarhobbies.shared;

public interface Constantes {

    String SIMBOLO_PORCENTAGEM = "%";

    interface URI {
        String URI_AUTOR = "api/autor";
        String URI_GENERO = "api/genero";
    }

    interface Mensagens {
        String MENSAGEM_CAMPO_OBRIGATORIO = "Esse campo é de preenchimento obrigatório.";
        String EMAIL_EXISTENTE = "Esse email já está cadastrado";
    }
}
