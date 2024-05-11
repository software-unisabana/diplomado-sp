package com.example.diplomado;

public class SaldoInsuficienteException extends RuntimeException {

  public SaldoInsuficienteException(String numeroCuenta) {
    super("La cuenta origen no dispone de los fondos suficientes " + numeroCuenta);
  }
}
