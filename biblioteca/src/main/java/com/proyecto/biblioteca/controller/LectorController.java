package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.dto.LectorDireccionDTO;
import com.proyecto.biblioteca.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LectorController {

    @Autowired
    private LectorService lectorService;

    // CRUD

    @PostMapping("/guardar-lector")
    public String guardarLector(LectorDireccionDTO lectorDireccionDTO) {
        this.lectorService.guardarLector(lectorDireccionDTO);
        return "redirect:/gestionar-lectores";
    }

    @PostMapping("/actualizar-lector")
    public String actualizarLector(LectorDireccionDTO lectorDireccionDTO){
        this.lectorService.actualizarLector(lectorDireccionDTO);
        return "redirect:/gestionar-lectores";
    }

    @GetMapping("/eliminar-lector/{id}")
    public String eliminarLector(@PathVariable Long id){
        this.lectorService.eliminarLector(id);
        return "redirect:/gestionar-lectores";
    }

    // Vistas

    @GetMapping("/guardar-lector")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("lector", null);
        model.addAttribute("listaLectores", this.lectorService.listaLectores());
        return "AgregarLector";
    }

    @GetMapping("/actualizar-lector/{id}")
    public String mostrarFormularioActualizar(Model model, @PathVariable Long id) {
        model.addAttribute("lector", this.lectorService.obtenerLector(id));
        model.addAttribute("listaLectores",this.lectorService.listaLectores());
        return "AgregarLector";
    }
}
