package com.proyecto.biblioteca.repository;

import com.proyecto.biblioteca.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Long, Editorial> {
}
