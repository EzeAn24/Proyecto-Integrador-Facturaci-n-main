package com.facturacion.Integrador_SistemaFacturacion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString; 

// ItemFactura.java
@Entity
@Table(name = "items_factura")
@Data
@NoArgsConstructor
public class ItemFactura {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String nombreServicio;
    @Column(nullable = false) private double precioUnitario;
    @Column(nullable = false) private double alicuotaIva;
    @Column(nullable = false) private int cantidad;
    @Column(nullable = false) private double subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id")
    @ToString.Exclude
    private Factura factura;

    public ItemFactura(Servicio servicio, int cantidad) {
        this.nombreServicio = servicio.getNombre();
        this.precioUnitario = servicio.getPrecioBase();
        this.alicuotaIva = servicio.getAlicuota().getValor();
        this.cantidad = cantidad;
        double iva = 1 + (this.alicuotaIva / 100.0);
        this.subtotal = (this.precioUnitario * this.cantidad) * iva;
    }

    // Si no usás Lombok, agregá:
    public double getSubtotal() { return subtotal; }
    public void setFactura(Factura factura) { this.factura = factura; }
}
