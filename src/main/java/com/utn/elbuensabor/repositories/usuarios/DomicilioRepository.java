package com.utn.elbuensabor.repositories.usuarios;

import com.utn.elbuensabor.entities.usuarios.Domicilio;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
}
