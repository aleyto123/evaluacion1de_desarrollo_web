package com.tecsup.demo05.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado; // Pendiente, Atendida, Cancelada [cite: 56, 57, 58]

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente; // [cite: 63]

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico; // [cite: 64]
}