package com.utn.elbuensabor.controllers.pedidos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.pedidos.DetallePedido;
import com.utn.elbuensabor.services.pedidos.DetallePedidoServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos/detallePedido")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido,DetallePedidoServiceImpl> {

}