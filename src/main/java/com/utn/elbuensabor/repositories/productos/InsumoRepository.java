package com.utn.elbuensabor.repositories.productos;


import com.utn.elbuensabor.entities.productos.Insumo;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepository extends BaseRepository<Insumo, Long> {

    @Query(
            value = "SELECT i FROM Insumo i " +
                    "WHERE stockActual <= stockMinimo * 1.20"
    )
    public Page<Insumo> getStockBajo(Pageable pageable);
}
