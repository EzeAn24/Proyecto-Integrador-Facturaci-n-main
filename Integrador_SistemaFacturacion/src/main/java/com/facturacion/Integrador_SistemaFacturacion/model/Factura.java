package com.facturacion.Integrador_SistemaFacturacion.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Factura.java
@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
public class Factura {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private LocalDate fechaEmision;
    @Column(nullable = false) private LocalDate fechaVencimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoFactura estado;

    @Column(nullable = false)
    private double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @ToString.Exclude
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ItemFactura> items = new ArrayList<>();

    public void agregarItem(ItemFactura item) {
        this.items.add(item);
        item.setFactura(this);
    }

    public void calcularTotal() {
        this.total = this.items.stream()
                .mapToDouble(ItemFactura::getSubtotal)
                .sum();
    }
}
