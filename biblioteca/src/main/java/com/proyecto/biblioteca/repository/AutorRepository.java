package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Long, Autor> {
}