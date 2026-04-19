package com.tecsup.demo05.service;

import com.tecsup.demo05.model.Medico;
import com.tecsup.demo05.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicoService {
    @Autowired private MedicoRepository repo;
    public List<Medico> listar() { return repo.findAll(); }
    public void guardar(Medico m) { repo.save(m); }
    public Medico buscar(Long id) { return repo.findById(id).orElse(null); }
}