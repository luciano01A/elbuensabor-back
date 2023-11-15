package com.utn.elbuensabor.services.facturacion;

import com.utn.elbuensabor.entities.facturacion.NotaCredito;
import com.utn.elbuensabor.services.BaseService;

import java.math.BigDecimal;
import java.util.Date;

public interface NotaCreditoService extends BaseService<NotaCredito, Long> {
    BigDecimal movimientos (Date fechaDesde, Date fechaHasta) throws Exception;
}
