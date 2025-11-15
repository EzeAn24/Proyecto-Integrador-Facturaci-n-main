package com.facturacion.Integrador_SistemaFacturacion.service;

import com.facturacion.Integrador_SistemaFacturacion.model.Servicio;
import com.facturacion.Integrador_SistemaFacturacion.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marca esta clase como un Servicio de Spring
public class ServicioService {

    @Autowired // Inyección de Dependencias: Spring nos da el repositorio
    private ServicioRepository servicioRepository;

    /**
     * Lógica para "cargar un nuevo servicio" (Iteración 1).
     * @param servicio El objeto Servicio a guardar.
     * @return El Servicio guardado (con su ID asignado).
     */
    public Servicio crearServicio(Servicio servicio) {
        // Aquí podríamos añadir validaciones, ej:
        // if (servicio.getPrecioBase() <= 0) { ... }
        return servicioRepository.save(servicio);
    }

    /**
     * Lógica para obtener todos los servicios disponibles.
     * @return Lista de todos los servicios.
     */
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    /**
     * Lógica para buscar un servicio por su ID.
     * @param id El ID del servicio.
     * @return El servicio encontrado, o null si no existe.
     */
    public Servicio buscarServicioPorId(Long id) {
        // .orElse(null) significa "devuelve el servicio si lo encuentras,
        // o devuelve null si no".
        return servicioRepository.findById(id).orElse(null);
    }
}