package com.utn.elbuensabor.controllers.usuarios;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import com.utn.elbuensabor.dtos.CambiarContraseñaDTO;
import com.utn.elbuensabor.dtos.CambiarDatosDTO;
import com.utn.elbuensabor.dtos.CrearPedidoDTO;
import com.utn.elbuensabor.dtos.RankingPersonasDTO;
import com.utn.elbuensabor.entities.enums.Rol;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.services.usuarios.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios/persona")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

    @GetMapping("/getByEmail")
    public ResponseEntity<?> getByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.getByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Usuario de e-mail '" + email + "' no encontrado.\"}");
        }
    }

    @PutMapping("/cambiarContraseña")
    public ResponseEntity<?> cambiarContraseña(@RequestBody CambiarContraseñaDTO cambiarContraseñaDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarContrasena(cambiarContraseñaDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }

    @PutMapping("/cambiarDatos")
    public ResponseEntity<?> cambiarDatos(@RequestBody CambiarDatosDTO cambiarDatosDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarDatos(cambiarDatosDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor, intente más tarde.\"}");
        }
    }
    @GetMapping("/ranking")
    public ResponseEntity<?> ranking(@RequestParam Date fechaInicio, @RequestParam Date fechaFin, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.ranking(fechaInicio,fechaFin,pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PutMapping("/crearPedido")
    public ResponseEntity<?> crearPedido(@RequestBody CrearPedidoDTO crearPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.crearPedido(crearPedidoDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}