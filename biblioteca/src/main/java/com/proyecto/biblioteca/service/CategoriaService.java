package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.entity.Categoria;
import com.proyecto.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listaCategorias(){
        return this.categoriaRepository.findAll();
    }
}
