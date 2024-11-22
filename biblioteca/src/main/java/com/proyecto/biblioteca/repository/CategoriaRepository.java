package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Long, Categoria> {
}
