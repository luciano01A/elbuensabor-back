package com.utn.elbuensabor.entities.facturacion;

import com.utn.elbuensabor.entities.Base;
import com.utn.elbuensabor.entities.enums.FormaPago;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Factura extends Base {

    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @NotNull
    private FormaPago formaPago;

    @NotNull
    @Column(name = "total_venta", precision = 10, scale = 2)
    private BigDecimal totalVenta;


    @NotNull
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

}
