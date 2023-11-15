package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.Receta;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.RecetaRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaServiceImpl extends BaseServiceImpl<Receta, Long> implements RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;


    public RecetaServiceImpl(BaseRepository<Receta, Long> baseRepository, RecetaRepository recetaRepository) {
        super(baseRepository);
        this.recetaRepository = recetaRepository;
    }


}
