package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.service.AutorService;
import com.proyecto.biblioteca.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditorialService editorialService;


    @GetMapping("/gestionarAutor")
    public String gestionarAutor(Model model){
        model.addAttribute("listaAutores", this.autorService.listaAutores());
        return "GestionarAutor";
    }

    @GetMapping("/gestionarEditorial")
    public String gestionarEditorial(Model model){
        model.addAttribute("listaEditorial", this.editorialService.listaEditorial());
        return "GestionarEditorial";
    }

}
