package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.entity.Cargo;
import com.proyecto.biblioteca.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> listaCargos(){
        return this.cargoRepository.findAll();
    }

}
