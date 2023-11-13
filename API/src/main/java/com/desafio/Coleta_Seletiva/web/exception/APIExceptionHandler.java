package com.desafio.Coleta_Seletiva.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.desafio.Coleta_Seletiva.exceptions.EntityNotFoundException;
import com.desafio.Coleta_Seletiva.exceptions.IntegrityViolationException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class APIExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(APIExceptionHandler.class);

  // Lida com exceções de campos inválidos nas requisições
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorMessage> methodArgumentsNotValidException(MethodArgumentNotValidException exception,
      HttpServletRequest request, BindingResult result) {
    log.error("API Error - ", exception);
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).contentType(MediaType.APPLICATION_JSON)
        .body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Campo(s) invalido(s)", result));
  }

  // Lida com exceções de integridade da entidade nas requisições
  @ExceptionHandler(IntegrityViolationException.class)
  public ResponseEntity<ErrorMessage> integrityViolationException(IntegrityViolationException exception,
      HttpServletRequest request) {
    log.error("API Error - ", exception);
    return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON)
        .body(new ErrorMessage(request, HttpStatus.CONFLICT, exception.getMessage()));
  }

  // Lida com exceções de argumentos ilegais
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorMessage> illegalArgumentException(IllegalArgumentException exception,
      HttpServletRequest request) {
    log.error("API Error - ", exception);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
        .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, exception.getMessage()));
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorMessage> entityNotFoundException(EntityNotFoundException exception,
      HttpServletRequest request) {
    log.error("API ERROR - ", exception);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
        .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, exception.getMessage()));
  }
}
