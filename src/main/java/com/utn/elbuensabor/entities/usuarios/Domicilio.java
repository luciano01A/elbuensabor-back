package com.utn.elbuensabor.entities.usuarios;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Domicilio extends Base {

    @NotNull
    @Column(length = 500)
    private String calle;

    @NotNull
    @Column(precision = 5)
    private Integer numero;

    @NotNull
    @Column(precision = 4)
    private Integer codigoPostal;

    @NotNull
    private String localidad;

    @Column(name = "numero_vivienda")
    private Integer numeroDpto;

    @Column(name = "piso_vivienda")
    private Integer pisoDpto;




}
