package com.proyecto.biblioteca.service;

import com.proyecto.biblioteca.entity.Editorial;
import com.proyecto.biblioteca.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;

    public Editorial guardarEditorial(Editorial editorial){
        return this.editorialRepository.save(editorial);
    }

    public Editorial obtenerEditorial(Long id){
        return this.editorialRepository.findById(id).orElseThrow(() -> new RuntimeException("EDITORIAL NO IDENTIFICADA"));
    }

    public Editorial actualizarEditorial(Editorial editorialActualizado){
        return this.editorialRepository.save(this.editorialRepository.findById(editorialActualizado.getIdEditorial())
                .map(editorial -> {
                    editorial.setNombreEditorial(editorialActualizado.getNombreEditorial());
                    editorial.setEmailEditorial(editorialActualizado.getEmailEditorial());
                    editorial.setFundacionEditorial(editorialActualizado.getFundacionEditorial());
                    editorial.setPaisEditorial(editorialActualizado.getPaisEditorial());
                    editorial.setTelefonoEditorial(editorialActualizado.getTelefonoEditorial());
                    return editorial;
                }).orElseThrow(() -> new RuntimeException("EDITORIAL NO IDENTIFICADA")));
    }

    public void eliminarEditorial(Long id){
        this.editorialRepository.findById(id).ifPresentOrElse(
                autor -> this.editorialRepository.delete(autor),
                () -> new RuntimeException("EDITORIAL NO IDENTIFICADA")
        );
    }

    public List<Editorial> listaEditorial(){
        return this.editorialRepository.findAll();
    }

    public Page<Editorial> listaPageableAutores(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return this.editorialRepository.findAll(pageable);
    }

}
