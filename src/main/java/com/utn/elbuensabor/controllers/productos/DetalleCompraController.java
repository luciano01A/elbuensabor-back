package com.utn.elbuensabor.controllers.productos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.productos.DetalleCompra;
import com.utn.elbuensabor.services.productos.DetalleCompraServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/detalleCompra")
public class DetalleCompraController extends BaseControllerImpl<DetalleCompra,DetalleCompraServiceImpl> {

}