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
@Table(name = "pago") // Opcional, asegura el nombre de la tabla
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPago;

    // Mapeamos explícitamente la columna 'monto'
    @Column(name = "monto", nullable = false)
    private Double monto;

    // Mapeamos explícitamente la columna 'metodo_pago'
    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @JsonIgnore
    @OneToMany(mappedBy = "pago")
    private List<Reserva> reservas;
}