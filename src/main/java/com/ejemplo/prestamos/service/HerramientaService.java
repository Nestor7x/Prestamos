package com.ejemplo.prestamos.service;

import com.ejemplo.prestamos.model.Herramienta;
import com.ejemplo.prestamos.repository.HerramientaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HerramientaService {

    private final HerramientaRepository repo;

    public Herramienta registrar(Herramienta h) {
        if (h.getCantidad() < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cantidad no puede ser negativa");
        return repo.save(h);
    }

    public List<Herramienta> listar() {
        return repo.findAll();
    }
}