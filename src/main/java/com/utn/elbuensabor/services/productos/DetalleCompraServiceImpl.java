package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.DetalleCompra;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.DetalleCompraRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraServiceImpl extends BaseServiceImpl<DetalleCompra, Long> implements DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    public DetalleCompraServiceImpl(BaseRepository<DetalleCompra, Long> baseRepository, DetalleCompraRepository detalleCompraRepository) {
        super(baseRepository);
        this.detalleCompraRepository = detalleCompraRepository;
    }

}
