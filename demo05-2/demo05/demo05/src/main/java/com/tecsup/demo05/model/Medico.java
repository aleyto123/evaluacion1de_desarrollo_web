package com.tecsup.demo05.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre; // [cite: 49]

    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad; //
}