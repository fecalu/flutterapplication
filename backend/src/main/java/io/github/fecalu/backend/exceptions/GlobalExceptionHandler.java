package io.github.fecalu.backend.exceptions;

import io.github.fecalu.backend.dto.ErroDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContatoJaCadastradoException.class)
    public ResponseEntity<ErroDTO> handleContatoJaCadastradoException(ContatoJaCadastradoException ex, HttpServletRequest request) {
        ErroDTO erroDTO = new ErroDTO(Instant.now(), 409, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(409).body(erroDTO);
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<ErroDTO> handleEmailJaCadastradoException(EmailJaCadastradoException ex, HttpServletRequest request) {
        ErroDTO erroDTO = new ErroDTO(Instant.now(), 409, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(409).body(erroDTO);
    }

    @ExceptionHandler(ContatoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> handleContatoNaoEncontradoException(ContatoNaoEncontradoException ex, HttpServletRequest request) {
        ErroDTO erroDTO = new ErroDTO(Instant.now(), 409, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(409).body(erroDTO);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErroDTO> handleEmailException(EmailException ex, HttpServletRequest request) {
        ErroDTO erroDTO = new ErroDTO(Instant.now(), 409, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(409).body(erroDTO);
    }
}
