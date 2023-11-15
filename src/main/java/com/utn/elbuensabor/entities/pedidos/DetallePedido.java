package com.utn.elbuensabor.entities.pedidos;

import com.utn.elbuensabor.entities.Base;
import com.utn.elbuensabor.entities.productos.Insumo;
import com.utn.elbuensabor.entities.productos.Producto;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetallePedido extends Base {

    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal")
    private double subtotal;

    @NotNull
    @Column(name = "subtotal_costo")
    private double subtotalCosto;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

}
