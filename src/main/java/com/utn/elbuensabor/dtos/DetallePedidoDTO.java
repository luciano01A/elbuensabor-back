package com.utn.elbuensabor.dtos;

import lombok.Data;

@Data
public class DetallePedidoDTO {
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
}
