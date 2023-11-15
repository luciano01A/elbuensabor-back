package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.repositories.facturacion.FacturaRepository;
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
public class FacturaControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FacturaRepository facturaRepository;

    @Test
    void testMovimientos() throws Exception {
        double totalEsperado = 0;
        for (int i = 1; i <= 10; i++) {
            Factura factura = new Factura();
            factura.setTotalVenta(new BigDecimal((double)i));
            factura.setFechaFacturacion((new SimpleDateFormat("yyyy-MM-dd")).parse("2023-10-25"));

            facturaRepository.save(factura);

            totalEsperado += (double) i;
        }

        mockMvc.perform(get("/api/v1/facturacion/factura/movimientos")
                        .param("fechaDesde", "2023-10-24")
                        .param("fechaHasta", "2023-10-26")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(totalEsperado) + "0"));

    }
}
