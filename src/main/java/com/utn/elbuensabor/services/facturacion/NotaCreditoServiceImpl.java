package com.utn.elbuensabor.services.facturacion;

import com.utn.elbuensabor.entities.facturacion.NotaCredito;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.facturacion.NotaCreditoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class NotaCreditoServiceImpl extends BaseServiceImpl<NotaCredito, Long> implements NotaCreditoService {

    @Autowired
    private NotaCreditoRepository notaCreditoRepository;
    public NotaCreditoServiceImpl(BaseRepository<NotaCredito, Long> baseRepository, NotaCreditoRepository notaCreditoRepository) {
        super(baseRepository);
        this.notaCreditoRepository = notaCreditoRepository;
    }
    @Override
    public BigDecimal movimientos(Date fechaDesde, Date fechaHasta) throws Exception{
        try{
            BigDecimal movimientos=notaCreditoRepository.movimientos(fechaDesde,fechaHasta);
            return movimientos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
