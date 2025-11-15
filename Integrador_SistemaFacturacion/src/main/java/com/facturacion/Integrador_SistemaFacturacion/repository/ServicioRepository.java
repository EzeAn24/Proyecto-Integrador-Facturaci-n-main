package com.facturacion.Integrador_SistemaFacturacion.repository;

import com.facturacion.Integrador_SistemaFacturacion.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Servicio.
 * Hereda de JpaRepository para obtener métodos CRUD automáticos.
 */
@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    
    // No necesitamos métodos personalizados para el MVP.
}