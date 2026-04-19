package com.tecsup.demo05.service;

import com.tecsup.demo05.model.Cita;
import com.tecsup.demo05.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {
    @Autowired private CitaRepository repo;
    public List<Cita> listar() { return repo.findAll(); }
    public void registrar(Cita c) { repo.save(c); }
    public void eliminar(Long id) { repo.deleteById(id); }
}