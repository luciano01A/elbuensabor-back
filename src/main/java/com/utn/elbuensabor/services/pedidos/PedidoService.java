package com.utn.elbuensabor.services.pedidos;

import com.utn.elbuensabor.dtos.CambiarEstadoDTO;
import com.utn.elbuensabor.dtos.DetallePedidoDTO;
import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido,Long> {
    Pedido cambiarEstado (CambiarEstadoDTO cambiarEstadoDTO) throws Exception;
    Page<Pedido> buscar (List<EstadoPedido> estados, Pageable pageable) throws Exception;

    Pedido agregarDetalle(DetallePedidoDTO detallePedidoDTO) throws Exception;
}
