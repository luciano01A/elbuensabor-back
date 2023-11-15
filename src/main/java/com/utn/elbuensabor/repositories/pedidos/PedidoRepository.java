package com.utn.elbuensabor.repositories.pedidos;

import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {


    @Query(
            value = "SELECT p FROM Pedido p " +
                    "WHERE estadoActual IN :estados"
    )
    public Page<Pedido> buscar(@Param("estados")List<EstadoPedido> estados,
                               Pageable pageable);
}
