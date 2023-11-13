package com.desafio.Coleta_Seletiva.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
  public DataIntegrityViolationException(String message) {
    super(message);
  }
}
