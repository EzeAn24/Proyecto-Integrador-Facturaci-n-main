package com.facturacion.Integrador_SistemaFacturacion.repository;

import com.facturacion.Integrador_SistemaFacturacion.model.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad ItemFactura.
 */
@Repository
public interface ItemFacturaRepository extends JpaRepository<ItemFactura, Long> {
    
}