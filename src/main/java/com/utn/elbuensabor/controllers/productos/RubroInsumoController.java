package com.utn.elbuensabor.controllers.productos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.productos.RubroInsumo;
import com.utn.elbuensabor.services.productos.RubroInsumoServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/rubroInsumo")
public class RubroInsumoController extends BaseControllerImpl<RubroInsumo,RubroInsumoServiceImpl> {


}