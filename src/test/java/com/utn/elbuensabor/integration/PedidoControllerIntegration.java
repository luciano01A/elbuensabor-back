package com.utn.elbuensabor.integration;

import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.repositories.pedidos.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class PedidoControllerIntegration {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PedidoRepository pedidoRepository;


    @Test
    void testCambiarEstado() throws Exception {
        Pedido pedido = new Pedido();
        pedido.setEstadoActual(EstadoPedido.EN_CAMINO);

        pedidoRepository.save(pedido);


        mockMvc.perform(put("/api/v1/pedidos/pedido/cambiarEstado")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idPedido\": 1, \"estadoPedido\": \"COMPLETADO\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estadoActual", is("COMPLETADO")));

    }

    @Test
    void testBuscar() throws Exception {
        Pedido pedido = new Pedido();
        pedido.setEstadoActual(EstadoPedido.EN_CAMINO);
        pedido.setTotal(new BigDecimal(149.99));


        Pedido p = pedidoRepository.save(pedido);



        mockMvc.perform(get("/api/v1/pedidos/pedido/buscar")
                        .param("page", "0")
                        .param("size", "100")
                        .param("estados", "EN_CAMINO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content["+ (p.getId()-1) + "].total", is(149.99)));

    }
}
