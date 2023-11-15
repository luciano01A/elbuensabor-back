package com.utn.elbuensabor.controllers.productos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.productos.UnidadMedida;
import com.utn.elbuensabor.services.productos.UnidadMedidaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/unidadMedida")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida,UnidadMedidaServiceImpl> {

}