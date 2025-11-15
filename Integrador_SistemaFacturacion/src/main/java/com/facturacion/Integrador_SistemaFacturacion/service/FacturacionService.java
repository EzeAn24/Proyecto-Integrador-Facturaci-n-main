package com.facturacion.Integrador_SistemaFacturacion.service;

import com.facturacion.Integrador_SistemaFacturacion.model.*;
import com.facturacion.Integrador_SistemaFacturacion.repository.ClienteRepository;
import com.facturacion.Integrador_SistemaFacturacion.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

// ... (imports)
@Service
public class FacturacionService {

    // ... (autowireds)

    @Transactional
    public Factura emitirFacturaIndividual(Long clienteId, LocalDate fechaVencimiento) {
        // ... (lógica para buscar cliente, crear factura, etc.)
        
        // ¡AHORA SÍ FUNCIONARÁ!
        // (porque @Data en Factura.java creó 'setCliente', 'setFechaEmision', etc.)
        factura.setCliente(cliente);
        factura.setFechaEmision(LocalDate.now());
        factura.setFechaVencimiento(fechaVencimiento);
        factura.setEstado(EstadoFactura.PENDIENTE); 

        // ... (lógica del bucle for)

        factura.calcularTotal();
        Factura facturaGuardada = facturaRepository.save(factura);

        // ¡AHORA SÍ FUNCIONARÁ!
        // (porque @Data en Factura creó 'getCliente' y @Data en Cliente creó 'getRazonSocial')
        facturaGuardada.getCliente().getRazonSocial(); // Forzamos carga
        facturaGuardada.getItems().size(); // Forzamos carga

        return facturaGuardada;
    }

    @Transactional(readOnly = true) 
    public Factura buscarFacturaPorId(Long id) {
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + id));
        
        // ¡AHORA SÍ FUNCIONARÁ!
        factura.getCliente().getRazonSocial(); // Forzamos carga
        factura.getItems().size(); // Forzamos carga

        return factura;
    }

    @Transactional(readOnly = true) 
    public List<Factura> listarFacturasPendientes() {
        List<Factura> facturas = facturaRepository.findByEstado(EstadoFactura.PENDIENTE);

        for (Factura f : facturas) {
            // ¡AHORA SÍ FUNCIONARÁ!
            f.getCliente().getRazonSocial(); // Forzamos carga
            f.getItems().size(); // Forzamos carga
        }

        return facturas;
    }
}