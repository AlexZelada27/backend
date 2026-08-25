package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor // Constructor sin parametros
@AllArgsConstructor // Constructor con parametros
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Cliente {
    private Integer idCliente;
    private String firstName;
}
