package com.utn.elbuensabor.entities.productos;


import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "compra_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class CompraInsumo extends Base {

    @OneToMany(mappedBy = "compraInsumo", cascade = CascadeType.ALL)
    @Builder. Default
    List<DetalleCompra> detalles = new ArrayList();

    @NotNull
    @Column(name = "total_compra", precision = 10, scale = 2)
    private BigDecimal totalCompra;

}
