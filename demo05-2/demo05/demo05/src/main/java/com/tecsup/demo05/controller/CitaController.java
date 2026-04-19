package com.tecsup.demo05.controller;

import com.tecsup.demo05.model.Cita;
import com.tecsup.demo05.service.CitaService;
import com.tecsup.demo05.service.MedicoService;
import com.tecsup.demo05.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired private CitaService citaService;
    @Autowired private PacienteService pacienteService;
    @Autowired private MedicoService medicoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("citas", citaService.listar());
        return "citas/listar";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("listaPacientes", pacienteService.listar());
        model.addAttribute("listaMedicos", medicoService.listar());
        return "citas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cita cita) {
        citaService.registrar(cita);
        return "redirect:/citas";
    }
}