package com.canor.testapirest.exception;

public class DineroInsuficienteException extends RuntimeException {

  public DineroInsuficienteException(String mensaje) {
    super(mensaje);
  }
}
