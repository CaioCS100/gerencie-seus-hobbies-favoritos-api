package br.com.gerenciarhobbies.exception;

public class EmailException extends RuntimeException {

    public EmailException() {}

    public EmailException(String mensagemErro) {
        super(mensagemErro);
    }

    public EmailException(String mensagemErro, Throwable causa) {
        super(mensagemErro, causa);
    }
}
