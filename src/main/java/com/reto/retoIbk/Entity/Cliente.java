package com.reto.retoIbk.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoUnico;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
}
