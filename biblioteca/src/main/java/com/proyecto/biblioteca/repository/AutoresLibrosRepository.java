package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.AutoresLibros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresLibrosRepository extends JpaRepository<Long, AutoresLibros> {
}
