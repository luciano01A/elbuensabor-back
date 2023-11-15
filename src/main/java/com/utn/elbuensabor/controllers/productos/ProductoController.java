package com.utn.elbuensabor.controllers.productos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.services.productos.ProductoServiceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/producto")
public class ProductoController extends BaseControllerImpl<Producto,ProductoServiceImpl> {
    @GetMapping("/porRubro")
    public ResponseEntity<?> search(@RequestParam String denominacion, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.porRubro(denominacion, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/buscar")
    public ResponseEntity<?> search2(@RequestParam String denominacion, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar(denominacion, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/ranking")
    public ResponseEntity<?> search(@RequestParam Date fechaInicio, Date fechaHasta, String[] denominaciones, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ranking(fechaInicio,fechaHasta, Arrays.asList(denominaciones), pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}