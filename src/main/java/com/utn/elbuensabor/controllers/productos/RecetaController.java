package com.utn.elbuensabor.controllers.productos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.productos.Receta;
import com.utn.elbuensabor.services.productos.RecetaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/receta")
public class RecetaController extends BaseControllerImpl<Receta,RecetaServiceImpl> {


}