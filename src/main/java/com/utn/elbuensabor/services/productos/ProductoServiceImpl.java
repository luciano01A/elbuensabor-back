package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.productos.ProductoRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository, ProductoRepository productoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }

    @Override
    public Page<Producto> porRubro(String denominacion, Pageable pageable) throws Exception{
        try{
            Page<Producto> producto=productoRepository.porRubro(denominacion,pageable);
            return producto;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Producto> buscar(String denominacion, Pageable pageable) throws Exception{
        try{
            Page<Producto> producto=productoRepository.buscar(denominacion,pageable);
            return producto;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Producto> ranking(Date fechaInicio, Date fechaHasta, List<String> denominaciones, Pageable pageable) throws Exception{
        try{
            Page<Producto> producto=productoRepository.ranking(fechaInicio,fechaHasta,denominaciones,pageable);
            return producto;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
