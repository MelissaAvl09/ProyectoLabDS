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
@Table(name = "lectores")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLectores;

    private String duiLector;

    private String telefonoLector;

    private String nombreLector;

    private String apellidoLector;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    @OneToMany(mappedBy = "lector", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestamo> listaPrestamos;
}
