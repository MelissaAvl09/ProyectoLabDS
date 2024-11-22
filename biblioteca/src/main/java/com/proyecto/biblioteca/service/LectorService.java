package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.dto.LectorDireccionDTO;
import com.proyecto.biblioteca.entity.Direccion;
import com.proyecto.biblioteca.entity.Empleado;
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
        lectorDTO.setDireccion(direccion);
        return this.lectorRepository.save(lectorDTO.getLector());
    }

    public Lector obtenerEmpleado(Long id){
        return this.lectorRepository.findById(id).orElseThrow(() -> new RuntimeException("LECTOR NO IDENTIFICADO"));
    }

    public Lector actualizarAutor(LectorDireccionDTO lectorDireccionDTO){
        Direccion direccion = this.direccionService.actualizarDireccion(lectorDireccionDTO.getDireccion());
        lectorDireccionDTO.setDireccion(direccion);
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

    public void eliminarEmpleado(Long id){
        this.lectorRepository.findById(id).ifPresentOrElse(
                lector -> {
                    Long idDireccion = lector.getDireccion().getIdDireccion();
                    this.lectorRepository.delete(lector);
                    this.direccionService.eliminarDireccion(idDireccion);
                },
                () -> new RuntimeException("LECTOR NO IDENTIFICADO")
        );
    }

    public List<Lector> listaEmpleados(){
        return this.lectorRepository.findAll();
    }

    public Page<Lector> listaPageableEmpleados(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return this.lectorRepository.findAll(pageable);
    }
}
