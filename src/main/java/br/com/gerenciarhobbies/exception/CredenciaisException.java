package br.com.gerenciarhobbies.exception;

public class CredenciaisException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CredenciaisException(String mensagem) {
        super(mensagem);
    }

    public CredenciaisException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
