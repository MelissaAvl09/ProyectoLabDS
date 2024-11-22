package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Long, Cargo> {
}
