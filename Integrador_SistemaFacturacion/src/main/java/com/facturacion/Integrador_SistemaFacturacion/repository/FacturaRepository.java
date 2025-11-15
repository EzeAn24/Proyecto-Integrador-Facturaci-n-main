package com.facturacion.Integrador_SistemaFacturacion.repository;

import com.facturacion.Integrador_SistemaFacturacion.model.EstadoFactura; // Importar
import com.facturacion.Integrador_SistemaFacturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; // Importar

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    
    /**
     * Nuevo método para cumplir "ver un listado de facturas pendientes".
     * Spring Data JPA mágicamente entiende que queremos buscar en la columna "estado".
     */
    List<Factura> findByEstado(EstadoFactura estado);
}