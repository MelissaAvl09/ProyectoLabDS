package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.dto.EmpleadoDireccionDTO;
import com.proyecto.biblioteca.entity.Autor;
import com.proyecto.biblioteca.entity.Direccion;
import com.proyecto.biblioteca.entity.Empleado;
import com.proyecto.biblioteca.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private DireccionService direccionService;

    public Empleado guardarEmpleado(EmpleadoDireccionDTO empleadoDTO){
        Direccion direccion = this.direccionService.guardarDireccion(empleadoDTO.getDireccion());
        empleadoDTO.setDireccion(direccion);
        return this.empleadoRepository.save(empleadoDTO.getEmpleado());
    }

    public Empleado obtenerEmpleado(Long id){
        return this.empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("AUTOR NO IDENTIFICADO"));
    }

    public Empleado actualizarAutor(EmpleadoDireccionDTO empleadoDireccionDTO){
        Direccion direccion = this.direccionService.actualizarDireccion(empleadoDireccionDTO.getDireccion());
        empleadoDireccionDTO.setDireccion(direccion);
        Empleado empleadoActualizado = empleadoDireccionDTO.getEmpleado();
        return this.empleadoRepository.save(this.empleadoRepository.findById(empleadoActualizado.getIdEmpleado())
                .map(empleado -> {
                    empleado.setNombreEmpleado(empleadoActualizado.getNombreEmpleado());
                    empleado.setApellidoEmpleado(empleadoActualizado.getApellidoEmpleado());
                    empleado.setFechaNacEmpleado(empleadoActualizado.getFechaNacEmpleado());
                    empleado.setDuiEmpleado(empleadoActualizado.getDuiEmpleado());
                    empleado.setCorreoEmpleado(empleadoActualizado.getCorreoEmpleado());
                    empleado.setDireccion(empleadoActualizado.getDireccion());
                    empleado.setCargo(empleadoActualizado.getCargo());
                    return empleado;
                }).orElseThrow(() -> new RuntimeException("AUTOR NO IDENTIFICADO")));
    }

    public void eliminarEmpleado(Long id){
        this.empleadoRepository.findById(id).ifPresentOrElse(
                empleado -> {
                    Long idDireccion = empleado.getDireccion().getIdDireccion();
                    this.empleadoRepository.delete(empleado);
                    this.direccionService.eliminarDireccion(idDireccion);
                },
                () -> new RuntimeException("AUTOR NO IDENTIFICADO")
        );
    }

    public List<Empleado> listaEmpleados(){
        return this.empleadoRepository.findAll();
    }

    public Page<Empleado> listaPageableEmpleados(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return this.empleadoRepository.findAll(pageable);
    }
}
