package com.utn.elbuensabor.controllers.productos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.productos.DetalleReceta;
import com.utn.elbuensabor.services.productos.DetalleRecetaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/detalleReceta")
public class DetalleRecetaController extends BaseControllerImpl<DetalleReceta,DetalleRecetaServiceImpl> {



}