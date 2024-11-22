package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamosRepository extends JpaRepository<Long, Prestamo> {
}
