package com.utn.elbuensabor.repositories.productos;

import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {

    @Query(
            value = "SELECT p FROM Producto p INNER JOIN p.rubroProducto rp " +
                    "WHERE rp.denominacion = :denominacion"
    )
    public Page<Producto> porRubro(@Param("denominacion") String denominacion, Pageable pageable);

    @Query(
        value = "SELECT p FROM Producto p WHERE p.denominacion LIKE %:denominacion%"
    )
    public Page<Producto> buscar(@Param("denominacion") String denominacion, Pageable pageable);

    @Query(
            value = "SELECT p FROM Producto p INNER JOIN p.rubroProducto rp, " +
                    "DetalleFactura df INNER JOIN df.factura f " +
                    "WHERE df.producto = p " +
                    "AND rp.denominacion IN :denominaciones " +
                    "AND f.fechaFacturacion BETWEEN :inicio AND :fin"
    )
    public Page<Producto> ranking(@Param("inicio") Date fechaDesde,
                                  @Param("fin") Date fechaHasta,
                                  @Param("denominaciones") List<String> denominaciones,
                                  Pageable pageable);
}
