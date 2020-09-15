package br.com.gerenciarhobbies.handler;

import br.com.gerenciarhobbies.domain.DetalhesErro;
import br.com.gerenciarhobbies.exception.CampoObrigatorioException;
import br.com.gerenciarhobbies.exception.RecursoExistenteException;
import br.com.gerenciarhobbies.exception.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(CampoObrigatorioException.class)
    public ResponseEntity<DetalhesErro> handleCampoObrigatorioException(CampoObrigatorioException ex,
                                                                        HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro()
                .status(400)
                .mensagem(ex.getMessage())
                .horario(obterDataAtual());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex,
                                                                            HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro()
                .status(404)
                .mensagem(ex.getMessage())
                .horario(obterDataAtual());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(RecursoExistenteException.class)
    public ResponseEntity<DetalhesErro> handleRecursoExistenteException(RecursoExistenteException ex,
                                                           HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro()
                .status(409)
                .mensagem(ex.getMessage())
                .horario(obterDataAtual());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    private Date obterDataAtual() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("pt-BR"));
        return calendar.getTime();
    }
}
