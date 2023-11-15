package com.utn.elbuensabor.repositories;

import com.utn.elbuensabor.dtos.CambiarContraseñaDTO;
import com.utn.elbuensabor.repositories.usuarios.PersonaRepository;
import com.utn.elbuensabor.services.usuarios.PersonaServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PersonaRepositoryTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PersonaRepository personaRepository;



    /*@Test
void testcambiarContrasena (){
        CambiarContraseñaDTO esperado= new CambiarContraseñaDTO(id 1L,contrasenaActual ******);
PersonaServiceImpl personaServiceImpl = new PersonaServiceImpl();
final CambiarContraseñaDTO resultado= PersonaServiceImpl.cambiarContrasena(id 1L, contraseñaActual *****);
        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    void testcambiarDatos(){

    }
    @Test
    void testranking(){


    }*/
}
