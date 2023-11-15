package com.utn.elbuensabor.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utn.elbuensabor.ElbuensaborApplication;
import com.utn.elbuensabor.entities.facturacion.DetalleFactura;
import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.entities.productos.Producto;
import com.utn.elbuensabor.entities.productos.RubroProducto;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.facturacion.DetalleFacturaRepository;
import com.utn.elbuensabor.repositories.facturacion.FacturaRepository;
import com.utn.elbuensabor.repositories.productos.ProductoRepository;
import com.utn.elbuensabor.repositories.productos.RubroProductoRepository;

import org.junit.jupiter.api.Test;
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
import java.text.SimpleDateFormat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ElbuensaborApplication.class)
@AutoConfigureMockMvc
public class ProductoControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductoRepository productoRepository;


    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private RubroProductoRepository rubroProductoRepository;


    @Test
    void testPorRubro() throws Exception {
        Producto producto = new Producto();
        RubroProducto rubroProducto = new RubroProducto();
        rubroProducto.setDenominacion("RP1");


        producto.setRubroProducto(rubroProducto);

        rubroProductoRepository.save(rubroProducto);
        productoRepository.save(producto);


        mockMvc.perform(get("/api/v1/productos/producto/porRubro")
                        .param("page", "0")
                        .param("size", "5")
                        .param("denominacion", "RP1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].rubroProducto.denominacion", is("RP1")));

    }

    @Test
    void testBuscar() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("P1");

        productoRepository.save(producto);


        mockMvc.perform(get("/api/v1/productos/producto/buscar")
                        .param("page", "0")
                        .param("size", "5")
                        .param("denominacion", "P1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].denominacion", is("P1")));

    }


    @Test
    void testRanking() throws Exception {
        Producto producto = new Producto();
        RubroProducto rubroProducto = new RubroProducto();
        rubroProducto.setDenominacion("RP1");
        Factura factura = new Factura();
        factura.setFechaFacturacion((new SimpleDateFormat("yyyy-MM-dd")).parse("2023-10-25"));
        DetalleFactura detalleFactura = new DetalleFactura();

        producto.setRubroProducto(rubroProducto);
        detalleFactura.setFactura(factura);
        detalleFactura.setProducto(producto);

        facturaRepository.save(factura);
        rubroProductoRepository.save(rubroProducto);
        productoRepository.save(producto);
        detalleFacturaRepository.save(detalleFactura);


        mockMvc.perform(get("/api/v1/productos/producto/ranking")
                        .param("fechaInicio", "2023-10-24")
                        .param("fechaHasta", "2023-10-26")
                        .param("page", "0")
                        .param("size", "5")
                        .param("denominaciones", "RP1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void testSave() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Pizza");
        producto.setDescripcion("Descripcion de un pizza");
        producto.setPrecioVenta(new BigDecimal(2000.00));


        mockMvc.perform(post("/api/v1/productos/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        //Esto convierte el producto a Json
                        .content(asJsonString(producto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.denominacion", is("Pizza")))
                .andExpect(jsonPath("$.descripcion", is("Descripcion de un pizza")));
    }
    @Test
    void testUpdate() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Pizza");
        producto.setDescripcion("Descripcion de un pizza");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        // Guardar el producto en la base de datos
        Producto saveProducto = productoRepository.save(producto);

        // Actualizar los datos del producto
        saveProducto.setDenominacion("Hamburguesa");
        saveProducto.setDescripcion("Descripcion de un Hamburguesa");
        saveProducto.setPrecioVenta(new BigDecimal(1800));


        mockMvc.perform(put("/api/v1/productos/producto/{id}", saveProducto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(saveProducto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.denominacion", is("Hamburguesa")))
                .andExpect(jsonPath("$.descripcion", is("Descripcion de un Hamburguesa")));
    }
    @Test
    void testDelete() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Pizza");
        producto.setDescripcion("Descripcion de una Pizza");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        // Guardar la persona en la base de datos
        Producto saveProducto = productoRepository.save(producto);

        // Eliminar la persona de la base de datos
        mockMvc.perform(delete("/api/v1/productos/producto/{id}", saveProducto.getId()))
                .andExpect(status().isNoContent());

        // Verificar que la persona haya sido eliminada
        mockMvc.perform(get("/api/v1/productos/producto/{id}", saveProducto.getId()))
                .andExpect(status().isNotFound());
    }
    @Test
    void testGetOne() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Fideos");
        producto.setDescripcion("Descripcion de unos fideos");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        productoRepository.save(producto);

        mockMvc.perform(get("/api/v1/productos/producto/{id}",producto.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.denominacion", is("Fideos")))
                .andExpect(jsonPath("$.descripcion", is("Descripcion de unos fideos")));

    }
    @Test
    void testGetAll() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Fideos");
        producto.setDescripcion("Descripcion de unos fideos");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        Producto producto2 = new Producto();
        producto2.setDenominacion("Nada");
        producto2.setDescripcion("Descripcion de nada");
        producto2.setPrecioVenta(new BigDecimal(2000.00));

        productoRepository.save(producto);
        productoRepository.save(producto2);

        mockMvc.perform(get("/api/v1/productos/producto"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].denominacion", is("Fideos")))
                .andExpect(jsonPath("$[1].descripcion", is("Descripcion de unos fideos")))
                .andExpect(jsonPath("$[2].denominacion", is("Nada")))
                .andExpect(jsonPath("$[2].descripcion", is("Descripcion de nada")));
    }
    @Test
    void testGetAllWithPageable() throws Exception {
        Producto producto = new Producto();
        producto.setDenominacion("Fideos");
        producto.setDescripcion("Descripcion de unos fideos");
        producto.setPrecioVenta(new BigDecimal(2000.00));

        Producto producto2 = new Producto();
        producto2.setDenominacion("Nada");
        producto2.setDescripcion("Descripcion de nada");
        producto2.setPrecioVenta(new BigDecimal(2000.00));

        productoRepository.save(producto);
        productoRepository.save(producto2);

        mockMvc.perform(get("/api/v1/productos/producto/paged")
                        .param("page", "0")
                        .param("size", "1")
                        .param("sort", "denominacion,asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].denominacion", is("Fideos")))
                .andExpect(jsonPath("$.content[0].descripcion", is("Descripcion de unos fideos")));
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

