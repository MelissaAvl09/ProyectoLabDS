package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.service.*;
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

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private LectorService lectorService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/gestionar-autores")
    public String gestionarAutores(Model model){
        model.addAttribute("listaAutores", this.autorService.listaAutores());
        return "GestionarAutor";
    }

    @GetMapping("/gestionar-editoriales")
    public String gestionarEditoriales(Model model){
        model.addAttribute("listaEditoriales", this.editorialService.listaEditorial());
        return "GestionarEditorial";
    }

    @GetMapping("/gestionar-empleados")
    public String gestionarEmpleados(Model model){
        model.addAttribute("listaEmpleados", this.empleadoService.listaEmpleados());
        return "GestionarEmpleado";
    }

    @GetMapping("/gestionar-lectores")
    public String gestionarLectores(Model model){
        model.addAttribute("listaLectores", this.lectorService.listaLectores());
        return "GestionarLector";
    }
}
