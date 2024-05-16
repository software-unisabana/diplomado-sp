package com.example.diplomado.service;

import com.example.diplomado.CuentaInvalidadException;
import com.example.diplomado.LimiteTransaccionalException;
import com.example.diplomado.SaldoInsuficienteException;
import com.example.diplomado.dto.TransferenciaDTO;

public class TransaccionService {

    public static final int MIL = 1000;

    private BD bd;

    public int suma(int numero1, int numero2) {
        return numero1 + numero2;
    }

    public void realizarTransferencia(int monto, Cuenta origen, Cuenta destino) {
        TransferenciaDTO dto = new TransferenciaDTO();
        if (origen.getNumeroCuenta().equals(destino.getNumeroCuenta())) {
            throw new CuentaInvalidadException(origen.getNumeroCuenta());
        }

        if (monto > origen.getSaldo()) {
            throw new SaldoInsuficienteException(origen.getNumeroCuenta());
        }
        if (monto > MIL) {
            throw new LimiteTransaccionalException();
        }
        origen.setSaldo(origen.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);
        bd.actualizarCuenta(origen);
        bd.actualizarCuenta(destino);
    }
}
