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
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPago;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false, length = 50)
    private String metodoPago;

    @JsonIgnore
    @OneToMany(mappedBy = "pago")
    private List<Reserva> reservas;
}