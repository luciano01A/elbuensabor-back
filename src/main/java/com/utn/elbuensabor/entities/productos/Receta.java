package com.utn.elbuensabor.entities.productos;

import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "receta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Receta extends Base {

    @NotNull
    @OneToMany( cascade = CascadeType.ALL)
    @Column(name= "id_receta")
    private List<DetalleReceta> detalles = new ArrayList();



    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

}
