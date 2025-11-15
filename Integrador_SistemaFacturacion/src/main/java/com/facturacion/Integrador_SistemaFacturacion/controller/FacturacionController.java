package com.facturacion.Integrador_SistemaFacturacion.controller;

import com.facturacion.Integrador_SistemaFacturacion.model.Factura;
import com.facturacion.Integrador_SistemaFacturacion.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List; // Importamos List

@RestController
@RequestMapping("/api/v1/facturacion") // URL base para la facturación
public class FacturacionController {

    @Autowired
    private FacturacionService facturacionService;

    /**
     * Endpoint para "emitir una Factura Individual".
     *
     * URL: POST http://localhost:8080/api/v1/facturacion/emitir-individual/1?vencimiento=2025-12-31
     */
    @PostMapping("/emitir-individual/{clienteId}")
    public Factura emitirFacturaIndividual(
            @PathVariable Long clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaVencimiento) {
        
        return facturacionService.emitirFacturaIndividual(clienteId, fechaVencimiento);
    }

    /**
     * Endpoint para "ver el detalle de la Factura".
     * URL: GET http://localhost:8080/api/v1/facturacion/5 (ejemplo)
     */
    @GetMapping("/{id}")
    public Factura buscarFacturaPorId(@PathVariable Long id) {
        return facturacionService.buscarFacturaPorId(id);
    }

    /**
     * Endpoint para "ver un listado de facturas pendientes".
     * URL: GET http://localhost:8080/api/v1/facturacion/pendientes
     */
    @GetMapping("/pendientes")
    public List<Factura> listarFacturasPendientes() {
        return facturacionService.listarFacturasPendientes();
    }
}