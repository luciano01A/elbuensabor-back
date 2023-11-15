package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.UnidadMedida;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.UnidadMedidaRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;


    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository, UnidadMedidaRepository unidadMedidaRepository) {
        super(baseRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }
    /*public List<UnidadMedida> search(String filtro) throws Exception {
        try {
            List<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro);
            return unidadMedidas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro, pageable);
            return unidadMedidas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<UnidadMedida> searchNative(String filtro) throws Exception {
        try{
            List<UnidadMedida> unidadMedidas = unidadMedidaRepository.searchNative(filtro);
            return unidadMedidas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }*/
}
