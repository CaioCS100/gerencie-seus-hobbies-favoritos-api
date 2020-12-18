package br.com.gerenciarhobbies.handler;

import br.com.gerenciarhobbies.domain.DetalhesErro;
import br.com.gerenciarhobbies.exception.CampoObrigatorioException;
import br.com.gerenciarhobbies.exception.RecursoExistenteException;
import br.com.gerenciarhobbies.exception.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(CampoObrigatorioException.class)
    public ResponseEntity<DetalhesErro> handleCampoObrigatorioException(CampoObrigatorioException ex,
                                                                        HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro()
                .status(HttpStatus.BAD_REQUEST.value())
                .mensagem(ex.getMessage())
                .horario(obterDataAtual());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex,
                                                                            HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro()
                .status(HttpStatus.NOT_FOUND.value())
                .mensagem(ex.getMessage())
                .horario(obterDataAtual());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(RecursoExistenteException.class)
    public ResponseEntity<DetalhesErro> handleRecursoExistenteException(RecursoExistenteException ex,
                                                           HttpServletRequest request) {
        DetalhesErro erro = new DetalhesErro()
                .status(HttpStatus.CONFLICT.value())
                .mensagem(ex.getMessage())
                .horario(obterDataAtual());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DetalhesErro>> handleValidationErros(MethodArgumentNotValidException ex) {
        List<DetalhesErro> listaErros = new ArrayList<>();

        ex.getBindingResult().getAllErrors().stream().map(erro -> listaErros.add(new DetalhesErro(
                    HttpStatus.BAD_REQUEST.value(),
                    erro.getDefaultMessage(),
                    obterDataAtual())))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaErros);
    }

    private Date obterDataAtual() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("pt-BR"));
        return calendar.getTime();
    }
}
