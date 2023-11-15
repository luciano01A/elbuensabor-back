package com.utn.elbuensabor.services.facturacion;

import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.services.BaseService;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface FacturaService extends BaseService<Factura,Long> {
    BigDecimal movimientos (Date fechaDesde, Date fechaHasta) throws Exception;
}
