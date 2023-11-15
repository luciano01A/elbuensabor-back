package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.CompraInsumo;
import com.utn.elbuensabor.services.BaseService;

import java.math.BigDecimal;
import java.util.Date;

public interface CompraInsumoService extends BaseService<CompraInsumo,Long> {
    BigDecimal movimientos (Date fechaDesde, Date fechaHasta) throws Exception;

}
