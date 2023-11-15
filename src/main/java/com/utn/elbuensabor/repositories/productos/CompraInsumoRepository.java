package com.utn.elbuensabor.repositories.productos;

import com.utn.elbuensabor.entities.productos.CompraInsumo;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface CompraInsumoRepository extends BaseRepository<CompraInsumo, Long> {

    @Query(
            value = "SELECT SUM(totalCompra) " +
                    "FROM CompraInsumo ci " +
                    "WHERE fechaAlta BETWEEN :inicio AND :fin"
    )
    public BigDecimal movimientos(@Param("inicio") Date fechaDesde, @Param("fin") Date fechaHasta);

}
