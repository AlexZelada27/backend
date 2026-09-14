package com.upn.zonestylebackend.model;

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
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idServicio;


    @ManyToOne
    @JoinColumn(
            name = "id_tipo_servicio",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_SERVICIO_TIPO_SERVICIO")
    )
    private TipoServicio tipoServicio;


    @Column(nullable = false, length = 100)
    private String nombre;


    @Column(nullable = false)
    private Double precio;


    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<ReservaServicio> reservasServicios;
}