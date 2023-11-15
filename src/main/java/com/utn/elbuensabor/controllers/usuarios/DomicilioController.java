package com.utn.elbuensabor.controllers.usuarios;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.usuarios.Domicilio;
import com.utn.elbuensabor.services.usuarios.DomicilioServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios/domicilio")
public class DomicilioController extends BaseControllerImpl<Domicilio,DomicilioServiceImpl> {
    /*@GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }*/
}