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
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idReserva;


    @ManyToOne
    @JoinColumn(
            name = "id_cliente",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_CLIENTE")
    )
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(
            name = "id_empleado",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_EMPLEADO")
    )
    private Empleado empleado;


    @ManyToOne
    @JoinColumn(
            name = "id_horario_fijo",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_HORARIO_FIJO")
    )
    private HorarioFijo horarioFijo;


    @ManyToOne
    @JoinColumn(
            name = "id_pago",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_PAGO")
    )
    private Pago pago;


    @ManyToOne
    @JoinColumn(
            name = "id_sala",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_SALA")
    )
    private SalaEstudio sala;


    @Column(nullable = false, length = 30)
    private String estado;


    @Column(nullable = false)
    private LocalDate fechaReserva;


    @ManyToOne
    @JoinColumn(
            name = "id_horario",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_HORARIO")
    )
    private Horario horario;


    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<ReservaServicio> servicios;
}