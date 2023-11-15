package com.utn.elbuensabor.controllers.facturacion;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.services.facturacion.FacturaServiceImpl;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/facturacion/factura")
public class FacturaController extends BaseControllerImpl<Factura,FacturaServiceImpl> {
    @GetMapping("/movimientos")
    public ResponseEntity<?> search(@RequestParam Date fechaDesde, Date fechaHasta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.movimientos(fechaDesde,fechaHasta));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


}