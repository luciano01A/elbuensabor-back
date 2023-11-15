package com.utn.elbuensabor.entities.usuarios;

import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
@Builder
public class Usuario extends Base {

    @NotNull
    private String username;
    @NotNull
    private String auth0id;

}
