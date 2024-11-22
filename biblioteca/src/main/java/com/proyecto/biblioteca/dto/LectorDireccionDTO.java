package com.proyecto.biblioteca.dto;

import com.proyecto.biblioteca.entity.Direccion;
import com.proyecto.biblioteca.entity.Lector;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LectorDireccionDTO {

    private Lector lector;

    private Direccion direccion;
}
