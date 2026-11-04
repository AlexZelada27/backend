package com.upn.zonestylebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class HorarioFijo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idHorarioFijo;

    @Column(nullable = false, length = 10)
    private String horaInicio;

    @Column(nullable = false, length = 10)
    private String horaFin;

    @JsonIgnore
    @OneToMany(mappedBy = "horarioFijo", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}