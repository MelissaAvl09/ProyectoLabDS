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
@Table(name = "autores")
public class Autor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    private String nombreAutor;

    private String apellidoAutor;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "autor")
    List<AutoresLibros> listaAutoresLibros;
}