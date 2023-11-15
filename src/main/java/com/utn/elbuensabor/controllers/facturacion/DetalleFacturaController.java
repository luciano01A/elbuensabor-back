package com.utn.elbuensabor.controllers.facturacion;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.facturacion.DetalleFactura;
import com.utn.elbuensabor.services.facturacion.DetalleFacturaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/facturacion/detalleFactura")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura,DetalleFacturaServiceImpl> {

}