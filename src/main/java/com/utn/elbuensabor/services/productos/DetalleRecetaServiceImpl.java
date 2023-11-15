package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.DetalleReceta;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.DetalleRecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleRecetaServiceImpl extends BaseServiceImpl<DetalleReceta, Long> implements DetalleRecetaService {

    @Autowired
    private DetalleRecetaRepository detalleRecetaRepository;

    public DetalleRecetaServiceImpl(BaseRepository<DetalleReceta, Long> baseRepository, DetalleRecetaRepository detalleRecetaRepository) {
        super(baseRepository);
        this.detalleRecetaRepository = detalleRecetaRepository;
    }


}
