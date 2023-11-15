package com.utn.elbuensabor.repositories.usuarios;

import com.utn.elbuensabor.dtos.RankingPersonasDTO;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE Persona SET password = :contrasenaNueva WHERE id = :id"
    )
    public int cambiarContrasena(@Param("id") Long id,
                                           @Param("contrasenaNueva") String contrasenaNueva);



    @Query(
            value = "SELECT new com.utn.elbuensabor.dtos.RankingPersonasDTO(u AS persona, COUNT(p) AS cantidadPedidos, SUM(f.totalVenta) AS total) " +
                    "FROM Persona AS u LEFT JOIN u.pedidos p, Factura AS f " +
                    "WHERE f.pedido = p " +
                    "AND fechaFacturacion BETWEEN :inicio AND :fin "
    )
    public Page<RankingPersonasDTO> ranking(@Param("inicio") Date fechaInicio,
                                            @Param("fin") Date fechaFin,
                                            Pageable pageable);

    Optional<Persona> findByEmail(String mail);
}
