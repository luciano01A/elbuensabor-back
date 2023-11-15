package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.usuarios.PersonaRepository;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class PersonaControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaRepository personaRepository;



    @Test

    void testCambiarContraseña() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Honguito");
        persona.setEmail("ph@mail.com");
        persona.setTelefono("12345678");
        persona.setPassword("abcd");
        personaRepository.save(persona);

        mockMvc.perform(put("/api/v1/usuarios/persona/cambiarContraseña")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, " +
                                "\"contraseñaActual\": \"abcd\", " +
                                "\"contraseñaNueva\": \"efgh\"}"))
                .andExpect(status().isOk());

    }


    @Test
    void testCambiarDatos() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Honguito");
        persona.setEmail("ph@mail.com");
        persona.setTelefono("12345678");
        persona.setPassword("abcd");
        persona.setRol(Rol.CLIENTE);
        personaRepository.save(persona);

        mockMvc.perform(put("/api/v1/usuarios/persona/cambiarDatos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, " +
                                "\"nombre\": \"Pedro\", " +
                                "\"apellido\": \"Hongo\", " +
                                "\"email\": \"ph@mail.com\", " +
                                "\"telefono\": \"73482834\", " +
                                "\"rol\": \"ADMINISTRADOR\"}"))
                .andExpect(status().isOk());

    }

    @Test
    void testRanking() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Honguito");
        persona.setEmail("ph@mail.com");
        persona.setTelefono("12345678");
        persona.setPassword("abcd");
        persona.setRol(Rol.CLIENTE);
        personaRepository.save(persona);

        mockMvc.perform(get("/api/v1/usuarios/persona/ranking")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("fechaInicio","2023-10-20")
                        .param("fechaFin","2023-10-30"))
                .andExpect(status().isOk());

    }

    void testSave() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Lopez");
        persona.setEmail("Ejemplo3@Email.com");
        Rol rol = Rol.CLIENTE;
        persona.setRol(rol);
        persona.setPassword("432");
        persona.setTelefono("123456789");


        mockMvc.perform(post("/api/v1/usuarios/persona")
                        .contentType(MediaType.APPLICATION_JSON)
                        //Esto convierte a Json la persona
                        .content(asJsonString(persona)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.apellido", is("Lopez")))
                .andExpect(jsonPath("$.email", is("Ejemplo3@Email.com")));
    }
    @Test
    void testUpdate() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Carlos");
        persona.setApellido("Ramirez");
        persona.setEmail("Ejemplo4@Email.com");
        Rol rol = Rol.ADMINISTRADOR;
        persona.setRol(rol);
        persona.setPassword("1234");
        persona.setTelefono("98765432");

        // Guardar la persona en la base de datos
        Persona savePersona = personaRepository.save(persona);

        // Actualizar los datos de la persona
        savePersona.setNombre("Daniel");
        savePersona.setApellido("Lopez");
        savePersona.setEmail("Ejemplo5@Email.com");
        savePersona.setPassword("5678");
        savePersona.setTelefono("12345678");

        mockMvc.perform(put("/api/v1/usuarios/persona/{id}", savePersona.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(savePersona)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Daniel")))
                .andExpect(jsonPath("$.apellido", is("Lopez")))
                .andExpect(jsonPath("$.email", is("Ejemplo5@Email.com")));
    }
    @Test
    void testDelete() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Exequiel");
        persona.setApellido("Barco");
        persona.setEmail("Ejemplo6@Email.com");
        Rol rol = Rol.COCINERO;
        persona.setRol(rol);
        persona.setPassword("1234");
        persona.setTelefono("98765432");

        // Guardar la persona en la base de datos
        Persona savePersona = personaRepository.save(persona);

        // Eliminar la persona de la base de datos
        mockMvc.perform(delete("/api/v1/usuarios/persona/{id}", savePersona.getId()))
                .andExpect(status().isNoContent());

        // Verificar que la persona haya sido eliminada
        mockMvc.perform(get("/api/v1/usuarios/persona/{id}", savePersona.getId()))
                .andExpect(status().isNotFound());
    }
    @Test
    void testGetOne() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Perez");
        persona.setEmail("Ejemplo@Email.com");
        Rol rol = Rol.CLIENTE;
        persona.setRol(rol);
        persona.setPassword("1234");
        persona.setTelefono("12323124");

        personaRepository.save(persona);

        mockMvc.perform(get("/api/v1/usuarios/persona/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Pepe")))
                .andExpect(jsonPath("$.apellido", is("Perez")));

    }
    @Test
    void testGetAll() throws Exception {
        Persona persona1 = new Persona();
        persona1.setNombre("Pepe");
        persona1.setApellido("Perez");
        persona1.setEmail("Ejemplo@Email.com");
        Rol rol1 = Rol.CLIENTE;
        persona1.setRol(rol1);
        persona1.setPassword("1234");
        persona1.setTelefono("12323124");

        Persona persona2 = new Persona();
        persona2.setNombre("Juan");
        persona2.setApellido("Lopez");
        persona2.setEmail("Ejemplo2@Email.com");
        Rol rol2 = Rol.ADMINISTRADOR;
        persona2.setRol(rol2);
        persona2.setPassword("5678");
        persona2.setTelefono("98765432");

        personaRepository.save(persona1);
        personaRepository.save(persona2);

        mockMvc.perform(get("/api/v1/usuarios/persona"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].nombre", is("Pepe")))
                .andExpect(jsonPath("$[1].apellido", is("Perez")))
                .andExpect(jsonPath("$[2].nombre", is("Juan")))
                .andExpect(jsonPath("$[2].apellido", is("Lopez")));
    }
    @Test
    void testGetAllWithPageable() throws Exception {
        Persona persona1 = new Persona();
        persona1.setNombre("Pepe");
        persona1.setApellido("Perez");
        persona1.setEmail("Ejemplo@Email.com");
        Rol rol1 = Rol.CLIENTE;
        persona1.setRol(rol1);
        persona1.setPassword("1234");
        persona1.setTelefono("12323124");

        Persona persona2 = new Persona();
        persona2.setNombre("Juan");
        persona2.setApellido("Lopez");
        persona2.setEmail("Ejemplo2@Email.com");
        Rol rol2 = Rol.ADMINISTRADOR;
        persona2.setRol(rol2);
        persona2.setPassword("5678");
        persona2.setTelefono("98765432");

        personaRepository.save(persona1);
        personaRepository.save(persona2);

        mockMvc.perform(get("/api/v1/usuarios/persona/paged")
                        .param("page", "0")
                        .param("size", "1")
                        .param("sort", "nombre,asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].nombre", is("Juan")))
                .andExpect(jsonPath("$.content[0].apellido", is("Lopez")));
    }



    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

