package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.PrestamosLibros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamosLibrosRepository  extends JpaRepository<PrestamosLibros, Long> {
}
