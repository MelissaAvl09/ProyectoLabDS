package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.entity.Autor;
import com.proyecto.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    // CRUD

    @PostMapping("/guardar-autor")
    public String guardarAutor(Autor autor) {
        this.autorService.agregarAutor(autor);
        return "redirect:/gestionar-autores";
    }

    @PostMapping("/actualizar-autor")
    public String actualizarAutor(Autor autor){
        this.autorService.actualizarAutor(autor);
        return "redirect:/gestionar-autores";
    }

    @GetMapping("/eliminar-autor/{id}")
    public String eliminarAutor(@PathVariable Long id){
        this.autorService.eliminarAutor(id);
        return "redirect:/gestionar-autores";
    }

    // Vistas

    @GetMapping("/guardar-autor")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("autor", null);
        model.addAttribute("listaAutores", this.autorService.listaAutores());
        return "AgregarAutor";
    }

    @GetMapping("/actualizar-autor/{id}")
    public String mostrarFormularioActualizar(Model model, @PathVariable Long id) {
        model.addAttribute("autor", this.autorService.obtenerAutor(id));
        model.addAttribute("listaAutores", this.autorService.listaAutores());
        return "AgregarAutor";
    }
}
