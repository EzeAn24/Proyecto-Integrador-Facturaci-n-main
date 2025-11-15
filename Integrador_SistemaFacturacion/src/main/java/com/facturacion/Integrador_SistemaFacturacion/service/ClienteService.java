package com.facturacion.Integrador_SistemaFacturacion.service;

import com.facturacion.Integrador_SistemaFacturacion.model.Cliente;
import com.facturacion.Integrador_SistemaFacturacion.model.Servicio;
import com.facturacion.Integrador_SistemaFacturacion.repository.ClienteRepository;
import com.facturacion.Integrador_SistemaFacturacion.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import java.util.List;

// ... (imports)
@Service
public class ClienteService {

    // ... (autowireds)

    @Transactional 
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional(readOnly = true) 
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true) 
    public Cliente buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            // ¡AHORA SÍ FUNCIONARÁ!
            cliente.getServiciosContratados().size(); // Forzamos carga
        }
        return cliente;
    }

    @Transactional 
    public Cliente asignarServicioACliente(Long clienteId, Long servicioId) {
        // ... (lógica para buscar cliente y servicio)
        if (cliente == null || servicio == null) {
            return null;
        }
        cliente.agregarServicio(servicio);
        Cliente clienteGuardado = clienteRepository.save(cliente);

        // ¡AHORA SÍ FUNCIONARÁ!
        clienteGuardado.getServiciosContratados().size(); // Forzamos carga

        return clienteGuardado;
    }
}