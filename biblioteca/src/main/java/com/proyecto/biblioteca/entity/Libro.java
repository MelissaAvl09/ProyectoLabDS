package com.proyecto.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ISBN;

    private String nombre;

    private String estado;

    private LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "libro")
    List<AutoresLibros> listaAutoresLibros;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "libro")
    List<PrestamosLibros> listaPrestamosLibros;
}
