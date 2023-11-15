package com.utn.elbuensabor.services.facturacion;

import com.utn.elbuensabor.entities.facturacion.DetalleFactura;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.facturacion.DetalleFacturaRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl <DetalleFactura, Long> implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository, DetalleFacturaRepository detalleFacturaRepository) {
        super(baseRepository);
        this.detalleFacturaRepository = detalleFacturaRepository;
    }

}
