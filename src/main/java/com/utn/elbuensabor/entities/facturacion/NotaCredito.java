package com.utn.elbuensabor.entities.facturacion;

import com.utn.elbuensabor.entities.Base;
import com.utn.elbuensabor.entities.usuarios.Persona;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "nota_credito")
@Data
@Builder
public class NotaCredito extends Base {

    @NotNull
    @Column(name = "total_monto", precision = 10, scale = 2)
    private BigDecimal monto;

    @ManyToOne
    private Persona cliente;

    @OneToOne
    private Factura factura;

}
