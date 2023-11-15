package com.utn.elbuensabor.controllers.pedidos;

import com.utn.elbuensabor.controllers.BaseControllerImpl;

import com.utn.elbuensabor.dtos.CambiarEstadoDTO;
import com.utn.elbuensabor.dtos.DetallePedidoDTO;
import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.services.pedidos.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pedidos/pedido")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {
    @PutMapping("/cambiarEstado")
    public ResponseEntity<?> cambiarEstado(@RequestBody CambiarEstadoDTO cambiarEstadoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.cambiarEstado(cambiarEstadoDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> search(@RequestParam EstadoPedido[] estados, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar(Arrays.asList(estados), pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


    @PutMapping("/agregarDetalle")
    public ResponseEntity<?> agregarDetalle(@RequestBody DetallePedidoDTO detallePedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.agregarDetalle(detallePedidoDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}