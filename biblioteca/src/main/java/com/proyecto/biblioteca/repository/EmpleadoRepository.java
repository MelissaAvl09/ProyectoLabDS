package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Long, Empleado> {
}
