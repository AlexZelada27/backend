package com.upn.zonestylebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idHorario;


    @Column(nullable = false)
    private LocalDate fecha;


    @Column(nullable = false)
    private String horaInicio;


    @Column(nullable = false)
    private String horaFin;


    @Column(nullable = false)
    private Boolean reservado;


    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}