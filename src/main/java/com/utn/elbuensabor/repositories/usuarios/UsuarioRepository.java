package com.utn.elbuensabor.repositories.usuarios;

import com.utn.elbuensabor.entities.usuarios.Usuario;
import com.utn.elbuensabor.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

}
