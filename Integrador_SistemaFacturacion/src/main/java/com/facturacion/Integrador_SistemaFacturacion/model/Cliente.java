package com.facturacion.Integrador_SistemaFacturacion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString; // <-- IMPORTAR

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String razonSocial;

    @Column(nullable = false, unique = true)
    private String dniCuit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CondicionIVA condicionIVA;

    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "cliente_servicios",
        joinColumns = @JoinColumn(name = "cliente_id"),
        inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    @ToString.Exclude // <-- AÑADIR (Evita bucle infinito)
    private List<Servicio> serviciosContratados = new ArrayList<>();

    public Cliente(String razonSocial, String dniCuit, CondicionIVA condicionIVA, String email) {
        this.razonSocial = razonSocial;
        this.dniCuit = dniCuit;
        this.condicionIVA = condicionIVA;
        this.email = email;
    }

    public void agregarServicio(Servicio servicio) {
        this.serviciosContratados.add(servicio);
    }
}