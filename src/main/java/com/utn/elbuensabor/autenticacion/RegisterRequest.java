package com.utn.elbuensabor.autenticacion;


import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.usuarios.Domicilio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String email;
    String password;
    String telefono;
    String nombre;
    String apellido;
    List<Domicilio> domicilios = new ArrayList<>();
}