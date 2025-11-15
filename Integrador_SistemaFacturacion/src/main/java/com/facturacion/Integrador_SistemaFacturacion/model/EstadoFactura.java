package com.facturacion.Integrador_SistemaFacturacion.model;

/**
 * Define los estados por los que puede pasar una Factura.
 * Requerido por requisito técnico (enums).
 */
public enum EstadoFactura {
    PENDIENTE,  // Recién creada, en espera de pago
    PAGADA,     // El total ha sido cubierto
    ANULADA     // Cancelada mediante Nota de Crédito
}