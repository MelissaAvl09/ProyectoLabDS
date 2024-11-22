package com.proyecto.biblioteca.dto;

import com.proyecto.biblioteca.entity.Direccion;
import com.proyecto.biblioteca.entity.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpleadoDireccionDTO {

    private Empleado empleado;

    private Direccion direccion;
}
