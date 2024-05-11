package com.example.diplomado.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.diplomado.CuentaInvalidadException;
import com.example.diplomado.SaldoInsuficienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransaccionServiceTest {

  @InjectMocks
  TransaccionService transaccionService;

  @Mock
  BD bd;

  //Dado, Cuando, Entonces
  //Given When Then
  @Test
  void Cuando_ejecuteSuma_Entonces_obtieneResultado3() {
    //Arrange : Preparar Data
    //Act: Ejecute el método
    //Assert: Valide el método
    int resultado = transaccionService.suma(1, 2);

    Assertions.assertEquals(3, resultado);
    //Assertion o Verify
    //Rojo, Amarillo y verde
    //Verde: Todo esta bien. Amarillo: Una assertion fallo. Rojo: Algo exploto no controlado
  }


  @Test
  void Dado_cuentaInvalidaDestino_Cuando_trasfieraDinero_Entonces_arrojaException() {
    //Arrange
    Cuenta origen = new Cuenta("123", 100);
    Cuenta destino = new Cuenta("123", 100);
    //Act
    Assertions.assertThrows(CuentaInvalidadException.class, () -> {
      transaccionService.realizarTransferencia(200, origen, destino);
    });
  }

  @Test
  void Dado_saldoInsuficiente_Cuando_transfieradinero_Entonces_arrojaException() {
    //Arrange

    Cuenta origen = new Cuenta("123", 100);
    Cuenta destino = new Cuenta("321", 100);
    //Act
    Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
      transaccionService.realizarTransferencia(200, origen, destino);
    });
  }

  @Test
  void Dado_datosCorrectos_Cuando_transfieradinero_Entonces_modificaSaldos() {
    //Arrange
    Cuenta origen = new Cuenta("123", 150);
    Cuenta destino = new Cuenta("321", 50);

    //Act
    transaccionService.realizarTransferencia(25, origen, destino);

    //Assertions
    Assertions.assertEquals(125, origen.getSaldo());
    Assertions.assertEquals(75, destino.getSaldo());
    Mockito.verify(bd).actualizarCuenta(origen);
    Mockito.verify(bd).actualizarCuenta(destino);
  }


  @Test
  void Dado_datosCorrectos_Cuando_transfieradinero2_Entonces_modificaSaldos() {
    //Arrange
    Cuenta origen = new Cuenta("123", 150);
    Cuenta destino = new Cuenta("321", 50);

    Mockito.when(bd.obtenerCuenta(123)).thenReturn(origen);
    Mockito.when(bd.obtenerCuenta(321)).thenReturn(destino);

    //Act
    transaccionService.realizarTransferencia2(25, 123, 321);

    //Assertions
    Assertions.assertEquals(125, origen.getSaldo());
    Assertions.assertEquals(75, destino.getSaldo());
    Mockito.verify(bd).actualizarCuenta(origen);
    Mockito.verify(bd).actualizarCuenta(destino);
  }

}