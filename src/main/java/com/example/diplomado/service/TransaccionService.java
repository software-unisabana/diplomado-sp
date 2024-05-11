package com.example.diplomado.service;

import com.example.diplomado.CuentaInvalidadException;
import com.example.diplomado.SaldoInsuficienteException;

public class TransaccionService {

  private BD bd;

  public int suma(int numero1, int numero2) {
    return numero1 + numero2;
  }

  public void realizarTransferencia(int monto, Cuenta origen, Cuenta destino) {
    if (origen.getNumeroCuenta().equals(destino.getNumeroCuenta())) {
      throw new CuentaInvalidadException(origen.getNumeroCuenta());
    }
    if (monto > origen.getSaldo()) {
      throw new SaldoInsuficienteException(origen.getNumeroCuenta());
    }
    origen.setSaldo(origen.getSaldo() - monto);
    destino.setSaldo(destino.getSaldo() + monto);
    bd.actualizarCuenta(origen);
    bd.actualizarCuenta(destino);
  }

  /*
  public void realizarTransferencia2(int monto, int numeroOrigen, int numeroDestino) {
    Cuenta origen = bd.obtenerCuenta(numeroOrigen);
    Cuenta destino = bd.obtenerCuenta(numeroDestino);

    if (origen.getNumeroCuenta().equals(destino.getNumeroCuenta())) {
      throw new CuentaInvalidadException(origen.getNumeroCuenta());
    }
    if (monto > origen.getSaldo()) {
      throw new SaldoInsuficienteException(origen.getNumeroCuenta());
    }
    origen.setSaldo(origen.getSaldo() - monto);
    destino.setSaldo(destino.getSaldo() + monto);
    bd.actualizarCuenta(origen);
    bd.actualizarCuenta(destino);
  }

   */
}
