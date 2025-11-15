package com.facturacion.Integrador_SistemaFacturacion.model;

import jakarta.persistence.*;
import lombok.Data; // Importa Getters, Setters, toString, etc.
import lombok.NoArgsConstructor; // Importa constructor vacío (requerido por JPA)
import lombok.AllArgsConstructor; // Importa constructor con todos los argumentos

@Entity // Marca esto como una Entidad (tabla) de base de datos
@Table(name = "servicios") // Nombre de la tabla
@Data // Lombok: genera Getters, Setters, toString(), equals(), etc.
@NoArgsConstructor // Lombok: genera constructor sin argumentos (JPA lo necesita)
@AllArgsConstructor // Lombok: genera constructor con todos los argumentos
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double precioBase; // Precio sin IVA

    @Enumerated(EnumType.STRING) // Guarda "IVA_21" en lugar de 0 o 1
    @Column(nullable = false)
    private AlicuotaIVA alicuota;

    /**
     * Método útil para calcular el precio final con IVA.
     * Lombok no genera esto, lo añadimos nosotros.
     */
    public double calcularPrecioFinal() {
        return this.precioBase * (1 + (this.alicuota.getValor() / 100));
    }
}