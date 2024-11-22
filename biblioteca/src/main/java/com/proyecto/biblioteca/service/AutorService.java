package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.entity.Autor;
import com.proyecto.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Autor guardarAutor(Autor autor){
        return this.autorRepository.save(autor);
    }

    public Autor obtenerAutor(Long id){
        return this.autorRepository.findById(id).orElseThrow(() -> new RuntimeException("AUTOR NO IDENTIFICADO"));
    }

    public Autor actualizarAutor(Autor autorActualizado){
        return this.autorRepository.save(this.autorRepository.findById(autorActualizado.getIdAutor())
                .map(autor -> {
                    autor.setNombreAutor(autorActualizado.getNombreAutor());
                    autor.setApellidoAutor(autorActualizado.getApellidoAutor());
                    autor.setFechaNacAutor(autorActualizado.getFechaNacAutor());
                    autor.setGeneroLiteraio(autorActualizado.getGeneroLiteraio());
                    autor.setNacionalidad(autorActualizado.getNacionalidad());
                    return autor;
                }).orElseThrow(() -> new RuntimeException("AUTOR NO IDENTIFICADO")));
    }

    public void eliminarEmpleado(Long id){
        this.autorRepository.findById(id).ifPresentOrElse(
                autor -> this.autorRepository.delete(autor),
                () -> new RuntimeException("AUTOR NO IDENTIFICADO")
        );
    }

    public List<Autor> listaAutores(){
        return this.autorRepository.findAll();
    }

    public Page<Autor> listaPageableAutores(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return this.autorRepository.findAll(pageable);
    }

}
