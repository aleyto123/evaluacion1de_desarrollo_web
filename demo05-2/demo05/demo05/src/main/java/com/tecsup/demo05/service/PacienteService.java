package com.tecsup.demo05.service;

import com.tecsup.demo05.model.Paciente;
import com.tecsup.demo05.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    @Autowired private PacienteRepository repo;
    public List<Paciente> listar() { return repo.findAll(); }
    public void guardar(Paciente p) { repo.save(p); }
    public void eliminar(Long id) { repo.deleteById(id); }
    public Paciente buscar(Long id) { return repo.findById(id).orElse(null); }
}