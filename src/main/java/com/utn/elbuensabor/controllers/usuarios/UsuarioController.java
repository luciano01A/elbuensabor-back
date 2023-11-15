package com.utn.elbuensabor.controllers.usuarios;

import com.utn.elbuensabor.controllers.BaseControllerImpl;
import com.utn.elbuensabor.entities.usuarios.Usuario;
import com.utn.elbuensabor.services.usuarios.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios/usuario")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {


}
