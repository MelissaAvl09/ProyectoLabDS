package com.proyecto.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "prestamosLibros")
public class PrestamosLibros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamoLibro;

    @ManyToOne
    @JoinColumn(name = "id_libros")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "id_prestamo")
    private Prestamo prestamo;
}
