package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.Insumo;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.InsumoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsumoServiceImpl extends BaseServiceImpl<Insumo, Long> implements InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;

    public InsumoServiceImpl(BaseRepository<Insumo, Long> baseRepository, InsumoRepository insumoRepository) {
        super(baseRepository);
        this.insumoRepository = insumoRepository;
    }
    @Override
    public Page<Insumo> getStockBajo(Pageable pageable) throws Exception{
        try{
            Page<Insumo> insumo=insumoRepository.getStockBajo(pageable);
            return insumo;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
