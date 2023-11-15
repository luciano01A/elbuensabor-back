package com.utn.elbuensabor.repositories.facturacion;
import com.utn.elbuensabor.entities.facturacion.*;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFactura, Long> {
}
