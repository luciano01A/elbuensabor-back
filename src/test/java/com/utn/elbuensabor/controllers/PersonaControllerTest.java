package com.utn.elbuensabor.controllers;

import com.utn.elbuensabor.controllers.usuarios.PersonaController;
import com.utn.elbuensabor.services.usuarios.PersonaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonaController.class)
public class PersonaControllerTest {
    @MockBean
    private PersonaServiceImpl personaService;

    // Lo usamos para ejecutar peticiones desde adentro de nuestra prueba
    @Autowired
    private MockMvc mockMvc;
/*@Test
void testcambiarContrasena (){
    Persona persona = new Persona();
    persona.setNombre("Luciano");
    persona.setApellido("Aguilera");

    List<Persona> listaEnviada = new ArrayList();
    listaEnviada.add(persona);

    when(personaService.search("Luciano")).thenReturn(listaEnviada);

    //Hacer una peticion
    mockMvc.perform(get("/api/v1/Personas/search")
                    .param("filtro","Luciano")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].nombre",is("Luciano")))
            .andExpect(jsonPath("$[0].apellido",is("Aguilera")));
}*/
}
