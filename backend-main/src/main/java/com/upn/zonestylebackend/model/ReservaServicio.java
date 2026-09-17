package com.upn.zonestylebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ReservaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idReservaServicio;


    @ManyToOne
    @JoinColumn(
            name = "id_reserva",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVASERVICIO_RESERVA")
    )
    private Reserva reserva;


    @ManyToOne
    @JoinColumn(
            name = "id_servicio",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVASERVICIO_SERVICIO")
    )
    private Servicio servicio;


    @Column(nullable = false)
    private Double precio;
}