package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.productos.CompraInsumo;
import com.utn.elbuensabor.repositories.productos.CompraInsumoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class CompraInsumoIntegration {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompraInsumoRepository compraInsumoRepository;

    @Test
    void testMovimientos() throws Exception {
        double totalEsperado = 0;
        for (int i = 1; i <= 10; i++) {
            CompraInsumo compraInsumo = new CompraInsumo();
            compraInsumo.setTotalCompra(new BigDecimal((double)i));
            compraInsumo.setFechaAlta((new SimpleDateFormat("yyyy-MM-dd")).parse("2023-10-25"));

            compraInsumoRepository.save(compraInsumo);

            totalEsperado += (double) i;
        }

        mockMvc.perform(get("/api/v1/productos/compraInsumo/movimientos")
                        .param("fechaDesde", "2023-10-24")
                        .param("fechaHasta", "2023-10-26")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(totalEsperado) + "0"));

    }
}
