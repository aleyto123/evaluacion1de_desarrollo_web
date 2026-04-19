package com.tecsup.demo05.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono; // [cite: 43, 44, 45, 46]

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Cita> citas; // [cite: 61]
}