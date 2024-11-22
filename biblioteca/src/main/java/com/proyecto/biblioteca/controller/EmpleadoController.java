package com.proyecto.biblioteca.controller;

import com.proyecto.biblioteca.dto.EmpleadoDireccionDTO;
import com.proyecto.biblioteca.entity.Autor;
import com.proyecto.biblioteca.entity.Empleado;
import com.proyecto.biblioteca.service.CargoService;
import com.proyecto.biblioteca.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private CargoService cargoService;

    // CRUD

    @PostMapping("/guardar-empleado")
    public String guardarEmpleado(EmpleadoDireccionDTO empleadoDireccionDTO) {
        this.empleadoService.guardarEmpleado(empleadoDireccionDTO);
        return "redirect:/gestionar-empleados";
    }

    @PostMapping("/actualizar-empleado")
    public String actualizarEmpleado(EmpleadoDireccionDTO empleadoDireccionDTO){
        this.empleadoService.actualizarEmpleado(empleadoDireccionDTO);
        return "redirect:/gestionar-empleados";
    }

    @GetMapping("/eliminar-empleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        this.empleadoService.eliminarEmpleado(id);
        return "redirect:/gestionar-empleados";
    }

    // Vistas

    @GetMapping("/guardar-empleado")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("empleado", null);
        model.addAttribute("listaEmpleados", this.empleadoService.listaEmpleados());
        model.addAttribute("listaCargos", this.cargoService.listaCargos());
        return "AgregarEmpleado";
    }

    @GetMapping("/actualizar-empleado/{id}")
    public String mostrarFormularioActualizar(Model model, @PathVariable Long id) {
        model.addAttribute("empleado", this.empleadoService.obtenerEmpleado(id));
        model.addAttribute("listaEmpleados", this.empleadoService.listaEmpleados());
        model.addAttribute("listaCargos", this.cargoService.listaCargos());
        return "AgregarEmpleado";
    }
}
