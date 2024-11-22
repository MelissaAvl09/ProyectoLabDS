package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.dto.LectorDireccionDTO;
import com.proyecto.biblioteca.entity.Direccion;
import com.proyecto.biblioteca.entity.Lector;
import com.proyecto.biblioteca.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    @Autowired
    private LectorRepository lectorRepository;

    @Autowired
    private DireccionService direccionService;

    public Lector guardarLector(LectorDireccionDTO lectorDTO){
        Direccion direccion = this.direccionService.guardarDireccion(lectorDTO.getDireccion());
        lectorDTO.getLector().setDireccion(direccion);
        return this.lectorRepository.save(lectorDTO.getLector());
    }

    public Lector obtenerLector(Long id){
        return this.lectorRepository.findById(id).orElseThrow(() -> new RuntimeException("LECTOR NO IDENTIFICADO"));
    }

    public Lector actualizarLector(LectorDireccionDTO lectorDireccionDTO){
        Direccion direccion = this.direccionService.actualizarDireccion(lectorDireccionDTO.getDireccion());
        lectorDireccionDTO.getLector().setDireccion(direccion);
        Lector lectorActualizado = lectorDireccionDTO.getLector();
        return this.lectorRepository.save(this.lectorRepository.findById(lectorActualizado.getIdLector())
                .map(lector -> {
                    lector.setNombreLector(lectorActualizado.getNombreLector());
                    lector.setApellidoLector(lectorActualizado.getApellidoLector());
                    lector.setTelefonoLector(lectorActualizado.getTelefonoLector());
                    lector.setDuiLector(lectorActualizado.getDuiLector());
                    lector.setEmailLector(lectorActualizado.getEmailLector());
                    lector.setDireccion(lectorActualizado.getDireccion());
                    return lector;
                }).orElseThrow(() -> new RuntimeException("LECTOR NO IDENTIFICADO")));
    }

    public void eliminarLector(Long id){
        this.lectorRepository.findById(id).ifPresentOrElse(
                lector -> {
                    Long idDireccion = lector.getDireccion().getIdDireccion();
                    this.lectorRepository.delete(lector);
                    this.direccionService.eliminarDireccion(idDireccion);
                },
                () -> new RuntimeException("LECTOR NO IDENTIFICADO")
        );
    }

    public List<Lector> listaLectores(){
        return this.lectorRepository.findAll();
    }

    public Page<Lector> listaPageableLectores(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return this.lectorRepository.findAll(pageable);
    }
}
