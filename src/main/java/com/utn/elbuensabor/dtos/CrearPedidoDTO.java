package com.utn.elbuensabor.dtos;

import com.utn.elbuensabor.entities.enums.FormaPago;
import com.utn.elbuensabor.entities.enums.TipoEnvio;
import lombok.Data;
import java.util.*;

@Data
public class CrearPedidoDTO {

    private Long idPersona;
    private Long idDomicilio;

}
