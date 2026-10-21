package com.ejemplo.prestamos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> root() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("message", "API de Prestamos en ejecucion");

        Map<String, String> endpoints = new LinkedHashMap<>();
        endpoints.put("herramientas", "/api/herramientas");
        endpoints.put("prestamos", "/api/prestamos");
        endpoints.put("documentacion_swagger", "/swagger-ui/index.html");
        response.put("endpoints", endpoints);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> health = new LinkedHashMap<>();
        health.put("status", "UP");
        return ResponseEntity.ok(health);
    }
}
