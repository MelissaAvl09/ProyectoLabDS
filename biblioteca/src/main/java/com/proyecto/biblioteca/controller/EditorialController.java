package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.entity.Editorial;
import com.proyecto.biblioteca.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    // CRUD

    @PostMapping("/guardar-editorial")
    public String guardarEditorial(Editorial editorial) {
        System.out.println("INGRESOO");
        this.editorialService.guardarEditorial(editorial);
        return "redirect:/gestionar-editoriales";
    }

    @PostMapping("/actualizar-editorial")
    public String actualizarEditorial(Editorial editorial){
        this.editorialService.actualizarEditorial(editorial);
        return "redirect:/gestionar-editoriales";
    }

    @GetMapping("/eliminar-editorial/{id}")
    public String eliminarEditorial(@PathVariable Long id){
        this.editorialService.eliminarEditorial(id);
        return "redirect:/gestionar-editoriales";
    }

    // Vistas

    @GetMapping("/guardar-editorial")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("editorial", null);
        model.addAttribute("listaEditoriales", this.editorialService.listaEditorial());
        return "AgregarEditorial";
    }

    @GetMapping("/actualizar-editorial/{id}")
    public String mostrarFormularioActualizar(Model model, @PathVariable Long id) {
        model.addAttribute("editorial", this.editorialService.obtenerEditorial(id));
        model.addAttribute("listaEditoriales", this.editorialService.listaEditorial());
        return "AgregarEditorial";
    }
}
