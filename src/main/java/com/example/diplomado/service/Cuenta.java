package com.example.diplomado.service;

public class Cuenta{

  String numeroCuenta;
  int saldo;

  public Cuenta(String numeroCuenta, int saldo) {
    this.numeroCuenta = numeroCuenta;
    this.saldo = saldo;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public int getSaldo() {
    return saldo;
  }

  public void setSaldo(int saldo) {
    this.saldo = saldo;
  }
}
