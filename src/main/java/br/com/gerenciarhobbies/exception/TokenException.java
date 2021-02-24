package br.com.gerenciarhobbies.exception;

public class TokenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TokenException(String mensagem) {
        super(mensagem);
    }

    public TokenException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
