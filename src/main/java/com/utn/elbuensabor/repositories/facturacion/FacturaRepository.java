package com.utn.elbuensabor.repositories.facturacion;

import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    @Query(
            value = "SELECT SUM(totalVenta) " +
                    "FROM Factura " +
                    "WHERE fechaFacturacion BETWEEN :inicio AND :fin"
    )
    public BigDecimal movimientos(@Param("inicio") Date fechaDesde, @Param("fin") Date fechaHasta);
}
