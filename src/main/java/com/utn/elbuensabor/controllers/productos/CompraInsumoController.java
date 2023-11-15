package com.utn.elbuensabor.controllers.productos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.productos.CompraInsumo;
import com.utn.elbuensabor.services.productos.CompraInsumoServiceImpl;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/compraInsumo")
public class CompraInsumoController extends BaseControllerImpl<CompraInsumo,CompraInsumoServiceImpl> {
    @GetMapping("/movimientos")
    public ResponseEntity<?> search(@RequestParam Date fechaDesde, Date fechaHasta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.movimientos(fechaDesde,fechaHasta));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}