package com.tecsup.demo05.controller;

import com.tecsup.demo05.model.Paciente;
import com.tecsup.demo05.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service; // Inyectamos el Service, NO el repository

    // Listado de Pacientes
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", service.listar());
        return "pacientes/listar";
    }

    // Mostrar formulario de registro (Nuevo)
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/formulario";
    }

    // Editar Paciente (Cargar datos en el formulario)
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Paciente paciente = service.buscar(id);
        model.addAttribute("paciente", paciente);
        return "pacientes/formulario";
    }

    // Guardar o Actualizar paciente
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Paciente paciente) {
        service.guardar(paciente);
        return "redirect:/pacientes";
    }

    // Eliminar paciente
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/pacientes";
    }
}