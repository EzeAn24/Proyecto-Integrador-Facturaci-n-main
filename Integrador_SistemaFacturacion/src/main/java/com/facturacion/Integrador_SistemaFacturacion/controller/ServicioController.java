package com.facturacion.Integrador_SistemaFacturacion.controller;

import com.facturacion.Integrador_SistemaFacturacion.model.Servicio;
import com.facturacion.Integrador_SistemaFacturacion.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importar
import org.springframework.http.ResponseEntity; // Importar
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/v1/servicios")
public class ServicioController {

    @Autowired 
    private ServicioService servicioService;

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        Servicio servicioCreado = servicioService.crearServicio(servicio);
        // Devolvemos el servicio creado y el código 201
        return new ResponseEntity<>(servicioCreado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Servicio> listarServicios() {
        return servicioService.listarServicios();
    }
}