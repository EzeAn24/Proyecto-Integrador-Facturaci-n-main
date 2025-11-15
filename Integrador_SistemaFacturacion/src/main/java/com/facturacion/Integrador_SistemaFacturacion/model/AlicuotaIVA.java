package com.facturacion.Integrador_SistemaFacturacion.model;

/**
 * Define las alícuotas de IVA permitidas para los Servicios.
 * Incluye el valor numérico para facilitar los cálculos.
 */
public enum AlicuotaIVA {
    IVA_21(21.0),
    IVA_10_5(10.5),
    IVA_27(27.0),
    IVA_0(0.0); // Para servicios exentos

    private final double valor;

    AlicuotaIVA(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}