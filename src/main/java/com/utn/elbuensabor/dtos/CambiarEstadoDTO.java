package com.utn.elbuensabor.dtos;

import com.utn.elbuensabor.entities.enums.EstadoPedido;
import lombok.Data;

@Data
public class CambiarEstadoDTO {

    private Long idPedido;
    private EstadoPedido estadoPedido;
}
