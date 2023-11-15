package com.utn.elbuensabor.services.usuarios;

import com.utn.elbuensabor.dtos.*;
import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.DetallePedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.entities.usuarios.Domicilio;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.BaseRepository;
import com.utn.elbuensabor.repositories.usuarios.PersonaRepository;
import com.utn.elbuensabor.services.BaseServiceImpl;
import com.utn.elbuensabor.services.productos.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private DomicilioService domicilioService;
    @Autowired
    private ProductoService productoService;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository){
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public boolean cambiarContrasena(CambiarContraseñaDTO cambiarContraseñaDTO) throws Exception{
        try{
            Persona persona = personaRepository.getReferenceById(cambiarContraseñaDTO.getId());
            if (persona.getPassword().equals(cambiarContraseñaDTO.getContraseñaActual())) {
                personaRepository.cambiarContrasena(cambiarContraseñaDTO.getId(), cambiarContraseñaDTO.getContraseñaNueva());
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Persona cambiarDatos(CambiarDatosDTO cambiarDatosDTO) throws Exception{
        try{
            Persona persona = personaRepository.findById(cambiarDatosDTO.getId()).get();

            persona.setEmail(cambiarDatosDTO.getEmail());
            persona.setApellido(cambiarDatosDTO.getApellido());
            persona.setNombre(cambiarDatosDTO.getNombre());
            persona.setRol(cambiarDatosDTO.getRol());
            persona.setTelefono(cambiarDatosDTO.getTelefono());

            personaRepository.save(persona);

            return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<RankingPersonasDTO> ranking(Date fechaInicio, Date fechaFin, Pageable pageable) throws Exception{
        try{
            Page<RankingPersonasDTO> personas=personaRepository.ranking(fechaInicio,fechaFin,pageable);

            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Pedido crearPedido(CrearPedidoDTO crearPedidoDTO) throws Exception {
        Persona persona = personaRepository.findById(crearPedidoDTO.getIdPersona()).get();
        Domicilio domicilio = domicilioService.findById(crearPedidoDTO.getIdDomicilio());
        Pedido pedido = Pedido.builder().
                fechaPedido(Date.from(Instant.now())).
                estadoActual(EstadoPedido.SIN_PEDIR).
                domicilioEntrega(domicilio)
                .build();
        double total=0;
        double totalCosto=0;

        pedido.setTotal(total);
        pedido.setTotalCosto(totalCosto);

        persona.getPedidos().add(pedido);
        personaRepository.save(persona);

        return pedido;
    }

    @Override
    public Persona getByEmail(String email) {
        return personaRepository.findByEmail(email).get();
    }
}
