package com.ejemplo.prestamos.controller;

import com.ejemplo.prestamos.model.Herramienta;
import com.ejemplo.prestamos.service.HerramientaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@RequiredArgsConstructor
public class HerramientaController {
    private final HerramientaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Herramienta registrar(@Valid @RequestBody Herramienta h) { return service.registrar(h); }

    @GetMapping
    public List<Herramienta> listar() { return service.listar(); }
}