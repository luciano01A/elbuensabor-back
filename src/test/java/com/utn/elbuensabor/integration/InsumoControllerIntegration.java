package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.facturacion.NotaCredito;
import com.utn.elbuensabor.entities.productos.Insumo;
import com.utn.elbuensabor.repositories.productos.InsumoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class InsumoControllerIntegration {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InsumoRepository insumoRepository;

    @Test
    void testBajoStock() throws Exception {
        for (int i = 0; i < 10; i++) {
            Insumo insumo =  new Insumo();
            insumo.setStockMinimo(new BigDecimal(10));
            insumo.setStockActual(new BigDecimal(i + 5));

            insumoRepository.save(insumo);
        }

        mockMvc.perform(get("/api/v1/productos/insumo/stockBajo")
                        .param("page", "1")
                        .param("size", "5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[2].stockActual", is(12.0)));

    }
}
