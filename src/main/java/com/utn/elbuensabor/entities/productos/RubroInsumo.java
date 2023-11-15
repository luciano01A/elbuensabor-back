package com.utn.elbuensabor.entities.productos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utn.elbuensabor.entities.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rubro_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroInsumo extends Base {

    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    @JsonIgnore
    private RubroInsumo rubroPadre;


    @OneToMany(mappedBy = "rubroPadre")
    @Builder. Default
    private List<RubroInsumo> subRubro=new ArrayList<>();

/*
    @OneToMany(mappedBy = "rubroInsumo", cascade = CascadeType.REFRESH)
    @Builder. Default
    @JsonIgnoreProperties
    private List<Insumo> insumos = new ArrayList();
*/
    @NotNull
    private String denominacion;


}
