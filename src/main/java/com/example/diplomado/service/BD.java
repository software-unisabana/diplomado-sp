package com.example.diplomado.service;

public interface BD {

  void actualizarCuenta(Cuenta cuenta);
  Cuenta obtenerCuenta(int numCuenta);
}
