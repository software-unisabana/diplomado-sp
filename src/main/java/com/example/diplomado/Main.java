package com.example.diplomado;

import com.example.diplomado.service.Cuenta;
import com.example.diplomado.service.TransaccionService;

public class Main {

  public static void main(String[] args) {
    TransaccionService transaccionService = new TransaccionService();

    Cuenta origen = new Cuenta("123", 100);
    Cuenta destino = new Cuenta("123", 100);
    //Act
    transaccionService.realizarTransferencia(200, origen, destino);

  }
}
