package com.facturacion.Integrador_SistemaFacturacion.repository;

import com.facturacion.Integrador_SistemaFacturacion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Cliente.
 * Hereda de JpaRepository para obtener métodos CRUD automáticos
 * (save, findById, findAll, delete, etc.)
 *
 * JpaRepository<Entidad, TipoDelID>
 */
@Repository // Le dice a Spring que esto es un componente de acceso a datos
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Por ahora no necesitamos métodos extra, JpaRepository
    // ya nos da todo lo necesario para el MVP.

    // Si necesitáramos buscar por DNI, podríamos agregar:
    // Cliente findByDniCuit(String dniCuit);
    // Spring mágicamente entiende qué hacer solo por el nombre del método.
}