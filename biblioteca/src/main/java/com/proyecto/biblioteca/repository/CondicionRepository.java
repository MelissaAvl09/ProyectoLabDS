package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.Condicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionRepository extends JpaRepository<Condicion, Long> {
}
