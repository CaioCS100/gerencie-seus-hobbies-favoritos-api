package br.com.gerenciarhobbies.exception;

public class RecursoExistenteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecursoExistenteException(String mensagem) {
        super(mensagem);
    }

    public RecursoExistenteException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
