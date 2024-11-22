package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.entity.Direccion;
import com.proyecto.biblioteca.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public Direccion guardarDireccion(Direccion direccion){
        return this.direccionRepository.save(direccion);
    }

    public Direccion obtenerDireccion(Long id){
        return this.direccionRepository.findById(id).orElseThrow(() -> new RuntimeException("DIRECCION NO IDENTIFICADA"));
    }

    public Direccion actualizarDireccion(Direccion direccionActualizado){
        return this.direccionRepository.save(this.direccionRepository.findById(direccionActualizado.getIdDireccion())
                .map(direccion -> {
                    direccion.setLinea(direccionActualizado.getLinea());
                    return direccion;
                }).orElseThrow(() -> new RuntimeException("DIRECCION NO IDENTIFICADA")));
    }

    public void eliminarDireccion(Long id){
        this.direccionRepository.findById(id).ifPresentOrElse(
                autor -> this.direccionRepository.delete(autor),
                () -> new RuntimeException("DIRECCION NO IDENTIFICADA")
        );
    }

    public List<Direccion> listaDireccion(){
        return this.direccionRepository.findAll();
    }

    public Page<Direccion> listaPageableDirecciones(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return this.direccionRepository.findAll(pageable);
    }
}
