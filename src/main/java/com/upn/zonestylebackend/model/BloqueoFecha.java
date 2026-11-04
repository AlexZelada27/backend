package com.upn.zonestylebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class BloqueoFecha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idBloqueo;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(
            name = "id_horario_fijo",
            nullable = true,
            foreignKey = @ForeignKey(name = "FK_BLOQUEO_HORARIO_FIJO")
    )
    private HorarioFijo horarioFijo;

    @Column(nullable = false, length = 150)
    private String motivo;
}