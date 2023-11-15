package com.utn.elbuensabor.repositories.productos;

import com.utn.elbuensabor.entities.productos.Receta;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends BaseRepository<Receta, Long> {
}
