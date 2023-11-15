package com.utn.elbuensabor.services.usuarios;

import com.utn.elbuensabor.entities.usuarios.Usuario;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.usuarios.UsuarioRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }
}
