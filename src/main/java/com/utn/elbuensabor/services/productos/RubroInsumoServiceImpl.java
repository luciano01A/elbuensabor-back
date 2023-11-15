package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.RubroInsumo;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.RubroInsumoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroInsumoServiceImpl extends BaseServiceImpl<RubroInsumo, Long> implements RubroInsumoService {

    @Autowired
    private RubroInsumoRepository rubroInsumoRepository;

    public RubroInsumoServiceImpl(BaseRepository<RubroInsumo, Long> baseRepository, RubroInsumoRepository rubroInsumoRepository) {
        super(baseRepository);
        this.rubroInsumoRepository = rubroInsumoRepository;
    }
    /*public List<RubroInsumo> search(String filtro) throws Exception {
        try {
            List<RubroInsumo> rubroInsumos = rubroInsumoRepository.search(filtro);
            return rubroInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public Page<RubroInsumo> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<RubroInsumo> rubroInsumos = rubroInsumoRepository.search(filtro, pageable);
            return rubroInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<RubroInsumo> searchNative(String filtro) throws Exception {
        try{
            List<RubroInsumo> rubroInsumos = rubroInsumoRepository.searchNative(filtro);
            return rubroInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }*/
}
