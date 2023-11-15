package com.utn.elbuensabor.entities.productos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_receta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetalleReceta extends Base {

    @NotNull
    @Column(name = "cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_insumo")
    private Insumo insumo;

    @NotNull
    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;



}
