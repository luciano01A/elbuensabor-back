package com.utn.elbuensabor.dtos;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class CambiarContraseñaDTO {

    private Long id;
    private String contraseñaActual;
    private String contraseñaNueva;



}
