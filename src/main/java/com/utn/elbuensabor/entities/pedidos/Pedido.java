package com.utn.elbuensabor.entities.pedidos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utn.elbuensabor.entities.Base;
import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.enums.FormaPago;
import com.utn.elbuensabor.entities.enums.TipoEnvio;
import com.utn.elbuensabor.entities.usuarios.Domicilio;
import com.utn.elbuensabor.entities.usuarios.Persona;
import jakarta.persistence.*;


import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Pedido extends Base {

    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @NotNull
    @Column(name = "hora_estimada_finalizacion")
    private LocalDateTime horaEstimadaFinalizacion;

    @NotNull
    @Column(name = "total")
    private double total;

    @NotNull
    @Column(name = "total_costo")
    private double totalCosto;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoActual;

    @NotNull
    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @ManyToOne()
    @JoinColumn(name = "id_domicilio_entrega")
    private Domicilio domicilioEntrega;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido")
    private List<DetallePedido> detalles = new ArrayList<>();


    public void addDetallePedido(DetallePedido detallePedido) {
        detalles.add(detallePedido);
    }
}
