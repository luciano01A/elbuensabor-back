package com.utn.elbuensabor.repositories.productos;

import com.utn.elbuensabor.entities.productos.DetalleCompra;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepository extends BaseRepository<DetalleCompra, Long> {
}
