package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.RubroProducto;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.RecetaRepository;
import com.utn.elbuensabor.repositories.productos.RubroProductoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroProductoServiceImpl extends BaseServiceImpl<RubroProducto, Long> implements RubroProductoService {

    @Autowired
    private RubroProductoRepository rubroProductoRepository;

    public RubroProductoServiceImpl(BaseRepository<RubroProducto, Long> baseRepository, RubroProductoRepository rubroProductoRepository) {
        super(baseRepository);
        this.rubroProductoRepository = rubroProductoRepository;
    }
    /*public List<RubroProducto> search(String filtro) throws Exception {
        try {
            List<RubroProducto> rubroProductos = rubroProductoRepository.search(filtro);
            return rubroProductos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public Page<RubroProducto> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<RubroProducto> rubroProductos = rubroProductoRepository.search(filtro, pageable);
            return rubroProductos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<RubroProducto> searchNative(String filtro) throws Exception {
        try{
            List<RubroProducto> rubroProductos = rubroProductoRepository.searchNative(filtro);
            return rubroProductos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }*/
}
