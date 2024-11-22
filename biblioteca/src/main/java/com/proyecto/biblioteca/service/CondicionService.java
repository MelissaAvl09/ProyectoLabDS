package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.entity.Condicion;
import com.proyecto.biblioteca.repository.CondicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicionService {
    @Autowired
    private CondicionRepository condicionRepository;

    public List<Condicion> listaCondiciones(){
        return this.condicionRepository.findAll();
    }
}
