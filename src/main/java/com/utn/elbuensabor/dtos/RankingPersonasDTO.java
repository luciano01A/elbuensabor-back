package com.utn.elbuensabor.dtos;

import com.utn.elbuensabor.entities.usuarios.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class RankingPersonasDTO {
    Persona persona;
    Long cantidadPedidos;
    BigDecimal total;

    public RankingPersonasDTO(Persona persona, Long cantidadPedidos, BigDecimal total) {
        this.persona = persona;
        this.cantidadPedidos = cantidadPedidos;
        this.total = total;
    }
}
