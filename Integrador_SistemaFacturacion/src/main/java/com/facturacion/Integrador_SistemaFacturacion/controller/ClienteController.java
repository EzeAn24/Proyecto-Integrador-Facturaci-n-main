package com.facturacion.Integrador_SistemaFacturacion.controller;

import com.facturacion.Integrador_SistemaFacturacion.model.Cliente;
import com.facturacion.Integrador_SistemaFacturacion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importar
import org.springframework.http.ResponseEntity; // Importar
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente clienteCreado = clienteService.crearCliente(cliente);
        // Devolvemos el cliente creado y el código 201
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @PostMapping("/{clienteId}/asignar-servicio/{servicioId}")
    public Cliente asignarServicio(
            @PathVariable Long clienteId,
            @PathVariable Long servicioId) {
        
        return clienteService.asignarServicioACliente(clienteId, servicioId);
    }
}