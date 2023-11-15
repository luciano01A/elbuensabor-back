package com.utn.elbuensabor.services.productos;

import com.utn.elbuensabor.entities.productos.Insumo;
import com.utn.elbuensabor.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InsumoService extends BaseService<Insumo,Long> {
    Page<Insumo> getStockBajo(Pageable pageable) throws Exception;
}
