package com.utn.elbuensabor.entities.productos;

import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "unidad_medida")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UnidadMedida extends Base {

    @NotNull
    @Column(length = 255)
    private String denominacion;

    @NotNull
    @Column(length = 25)
    private String abreviatura;


}
