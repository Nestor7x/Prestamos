package com.ejemplo.prestamos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responsable;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    private Integer cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "herramienta_id", nullable = false)
    private Herramienta herramienta;
}