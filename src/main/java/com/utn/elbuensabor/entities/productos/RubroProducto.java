package com.utn.elbuensabor.entities.productos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utn.elbuensabor.entities.Base;
import com.utn.elbuensabor.entities.enums.TipoRubro;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.*;

@Entity
@Table(name = "rubro_producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroProducto extends Base {

    /*
    @OneToMany(mappedBy = "rubroProducto", cascade = CascadeType.REFRESH)
    @Builder.Default
    private List<Producto> productos = new ArrayList();
    */

    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    @JsonIgnore
    private RubroProducto rubroPadre;

    @OneToMany(mappedBy = "rubroPadre")
    private List<RubroProducto> subRubro;

    @NotNull
    private String denominacion;
}
