package com.utn.elbuensabor.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonaServiceImplTest {

  /*
  @MockBean
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaServiceImpl personaService;

  @Test
    void testSearchString() throws Exception {
        Persona persona = new Persona();
        persona.setNombre("Luciano");
        persona.setApellido("Aguilera");

        List<Persona> listaEnviada = new ArrayList<>();

        when(personaRepository.searchNativo("Luciano")).thenReturn(listaEnviada);

        assertEquals(listaEnviada, personaService.search("Luciano"));*/
}
