package com.example.diplomado;

public class CuentaInvalidadException extends RuntimeException {

  public CuentaInvalidadException(String numeroCuenta) {
    super("La cuenta origen es igual a la cuenta destino " + numeroCuenta);
  }
}
