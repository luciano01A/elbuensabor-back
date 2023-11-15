package com.utn.elbuensabor.services.facturacion;

import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.facturacion.FacturaRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService{

    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository = facturaRepository;
    }
    @Override
    public BigDecimal movimientos(Date fechaDesde, Date fechaHasta) throws Exception{
        try{
            BigDecimal movimientos=facturaRepository.movimientos(fechaDesde,fechaHasta);
            return movimientos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
