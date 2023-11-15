package com.utn.elbuensabor.controllers.productos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.productos.RubroProducto;
import com.utn.elbuensabor.services.productos.RubroProductoServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/rubroProducto")
public class RubroProductoController extends BaseControllerImpl<RubroProducto,RubroProductoServiceImpl> {

}