package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ProductoService extends BaseService<Producto,Long> {
    Page<Producto> porRubro(String denominacion, Pageable pageable) throws Exception;
    Page<Producto> buscar(String denominacion, Pageable pageable) throws Exception;
    Page<Producto> ranking(Date fechaInicio, Date fechaHasta, List<String> denominaciones, Pageable pageable) throws Exception;

}
