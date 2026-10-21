package com.ejemplo.prestamos.controller;

import com.ejemplo.prestamos.dto.PrestamoRequest;
import com.ejemplo.prestamos.model.Prestamo;
import com.ejemplo.prestamos.service.PrestamoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@RequiredArgsConstructor
public class PrestamoController {
    private final PrestamoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prestamo registrar(@Valid @RequestBody PrestamoRequest req) { return service.registrar(req); }

    @GetMapping
    public List<Prestamo> listar() { return service.listar(); }

    @GetMapping("/herramienta/{id}")
    public List<Prestamo> porHerramienta(@PathVariable Long id) { return service.listarPorHerramienta(id); }
}