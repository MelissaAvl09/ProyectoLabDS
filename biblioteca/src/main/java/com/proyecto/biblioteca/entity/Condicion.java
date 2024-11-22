package com.proyecto.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "condiciones")
public class Condicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCondicionLibro;

    private String condicion;

    @OneToMany(mappedBy = "condicion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> listaLibros;

}
