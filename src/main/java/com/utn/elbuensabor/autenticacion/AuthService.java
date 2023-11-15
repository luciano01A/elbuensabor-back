package com.utn.elbuensabor.autenticacion;

import com.utn.elbuensabor.Jwt.JwtService;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.usuarios.Domicilio;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.usuarios.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PersonaRepository personaRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = personaRepository.findByEmail(request.getEmail()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {

        Persona usuario = Persona.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode( request.getPassword()))
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .domicilios(request.getDomicilios())
                .rol(Rol.CLIENTE)
                .telefono(request.getTelefono())
                .build();


        personaRepository.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();

    }

}
