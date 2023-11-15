package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.entities.facturacion.NotaCredito;
import com.utn.elbuensabor.repositories.facturacion.NotaCreditoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class NotaCreditoIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NotaCreditoRepository notaCreditoRepository;

    @Test
    void testMovimientos() throws Exception {
        double totalEsperado = 0;
        for (int i = 1; i <= 10; i++) {
            NotaCredito notaCredito = new NotaCredito();
            notaCredito.setMonto(new BigDecimal((double)i));
            notaCredito.setFechaAlta((new SimpleDateFormat("yyyy-MM-dd")).parse("2023-10-25"));

            notaCreditoRepository.save(notaCredito);

            totalEsperado += (double) i;
        }

        mockMvc.perform(get("/api/v1/facturacion/notaCredito/movimientos")
                        .param("fechaDesde", "2023-10-24")
                        .param("fechaHasta", "2023-10-26")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(totalEsperado) + "0"));

    }
}
