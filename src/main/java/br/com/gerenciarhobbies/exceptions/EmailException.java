package br.com.gerenciarhobbies.exceptions;

public class EmailException extends RuntimeException {

    public EmailException() {}

    public EmailException(String mensagemErro) {
        super(mensagemErro);
    }

    public EmailException(String mensagemErro, Throwable causa) {
        super(mensagemErro, causa);
    }
}
