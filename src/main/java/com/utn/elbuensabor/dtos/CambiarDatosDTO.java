package com.utn.elbuensabor.dtos;

import com.utn.elbuensabor.entities.enums.Rol;
import lombok.Data;
@Data
public class CambiarDatosDTO {
    private Long id;
    private String email;
    private Rol rol;
    private String nombre;
    private String apellido;
    private String telefono;
}
