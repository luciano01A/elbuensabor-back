package com.utn.elbuensabor.services.usuarios;

import com.utn.elbuensabor.dtos.CambiarContraseñaDTO;
import com.utn.elbuensabor.dtos.CambiarDatosDTO;
import com.utn.elbuensabor.dtos.CrearPedidoDTO;
import com.utn.elbuensabor.dtos.RankingPersonasDTO;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PersonaService extends BaseService<Persona,Long> {

    boolean cambiarContrasena(CambiarContraseñaDTO cambiarContraseñaDTO) throws Exception;


    Persona cambiarDatos(CambiarDatosDTO cambiarDatosDTO) throws Exception;

    Page<RankingPersonasDTO> ranking (Date fechaInicio, Date fechaFin, Pageable pageable) throws Exception;

    Pedido crearPedido(CrearPedidoDTO crearPedidoDTO) throws Exception;

    Persona getByEmail(String email);
}
