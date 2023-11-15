package com.utn.elbuensabor;

import com.utn.elbuensabor.entities.enums.EstadoPedido;
import com.utn.elbuensabor.entities.enums.FormaPago;
import com.utn.elbuensabor.entities.enums.Rol;
import com.utn.elbuensabor.entities.facturacion.DetalleFactura;
import com.utn.elbuensabor.entities.facturacion.Factura;
import com.utn.elbuensabor.entities.pedidos.DetallePedido;
import com.utn.elbuensabor.entities.pedidos.Pedido;
import com.utn.elbuensabor.entities.productos.*;
import com.utn.elbuensabor.entities.usuarios.Domicilio;
import com.utn.elbuensabor.entities.usuarios.Persona;
import com.utn.elbuensabor.repositories.facturacion.DetalleFacturaRepository;
import com.utn.elbuensabor.repositories.facturacion.FacturaRepository;
import com.utn.elbuensabor.repositories.pedidos.DetallePedidoRepository;
import com.utn.elbuensabor.repositories.pedidos.PedidoRepository;
import com.utn.elbuensabor.repositories.productos.*;
import com.utn.elbuensabor.repositories.usuarios.DomicilioRepository;
import com.utn.elbuensabor.repositories.usuarios.PersonaRepository;
import com.utn.elbuensabor.repositories.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootApplication
public class ElbuensaborApplication {


	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	CompraInsumoRepository compraInsumoRepository;
	@Autowired
	DetalleCompraRepository detalleCompraRepository;
	@Autowired
	DetalleRecetaRepository detalleRecetaRepository;
	@Autowired
	InsumoRepository insumoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroInsumoRepository rubroInsumoRepository;
	@Autowired
	RubroProductoRepository rubroProductoRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElbuensaborApplication.class, args);
	}



	@Bean
	CommandLineRunner init() {
		return args -> {

			RubroInsumo rubroInsumo1 = RubroInsumo.builder().rubroPadre(null)
					.denominacion("rubroInsumo1")
					.build();

			RubroInsumo rubroInsumo2 = RubroInsumo.builder().rubroPadre(rubroInsumo1)
					.denominacion("rubroInsumo2")
					.build();

			RubroInsumo rubroInsumo3 = RubroInsumo.builder().rubroPadre(rubroInsumo1)
					.denominacion("rubroInsumo3")
					.build();

			rubroInsumo1.getSubRubro().add(rubroInsumo2);
			rubroInsumo1.getSubRubro().add(rubroInsumo3);

			rubroInsumoRepository.save(rubroInsumo1);
			rubroInsumoRepository.save(rubroInsumo2);
			rubroInsumoRepository.save(rubroInsumo3);


			UnidadMedida unidadMedida1 = UnidadMedida.builder().denominacion("mililitros")
					.abreviatura("ml")
					.build();

			UnidadMedida unidadMedida2 = UnidadMedida.builder().denominacion("gramos")
					.abreviatura("g")
					.build();

			unidadMedidaRepository.save(unidadMedida1);
			unidadMedidaRepository.save(unidadMedida2);

			Insumo insumo1 = Insumo.builder().rubroInsumo(rubroInsumo2)
					.denominacion("leche")
					.stockMinimo(new BigDecimal(100))
					.unidadMedida(unidadMedida1)
					.precioCompra(new BigDecimal(2000))
					.build();

			Insumo insumo2 = Insumo.builder().rubroInsumo(rubroInsumo3)
					.denominacion("papa")
					.stockMinimo(new BigDecimal(300))
					.unidadMedida(unidadMedida1)
					.precioCompra(new BigDecimal(800))
					.build();

			insumoRepository.save(insumo1);
			insumoRepository.save(insumo2);

			RubroProducto rubroProducto1 = RubroProducto.builder()
					.denominacion("acompañamiento")
					.rubroPadre(null)
					.build();
			rubroProductoRepository.save(rubroProducto1);

			List<DetalleReceta> detallesReceta = new ArrayList<>();

			DetalleReceta detalleReceta1 = DetalleReceta.builder()
					.cantidad(new BigDecimal(5))
					.insumo(insumo2)
					.costo(new BigDecimal(100))
					.build();

			DetalleReceta detalleReceta2 = DetalleReceta.builder()
					.cantidad(new BigDecimal(300))
					.insumo(insumo1)
					.costo(new BigDecimal(100))
					.build();

			detallesReceta.add(detalleReceta1);
			detallesReceta.add(detalleReceta2);


			Receta receta1 = Receta.builder()
					.descripcion("hierva las papas, luego piselas y agregueles leche")
					.detalles(detallesReceta)
					.build();




			Producto producto1 = Producto.builder()
					.costo(500.00)
					.denominacion("puré de papa")
					.precioVenta(1234)
					.urlImagen("https://images.aws.nestle.recipes/original/892d65cba81876ed7c340ae9ce7663d3_DCS_MARZO_INSTAGRAM-04.jpg")
					.rubroProducto(rubroProducto1)
					.receta(receta1)
					.build();

			productoRepository.save(producto1);


			DetalleCompra detalleCompra1 = DetalleCompra.builder()
					.cantidad(new BigDecimal(5))
					.insumo(insumo1)
					.monto(1000)
					.build();


			CompraInsumo compraInsumo1 = CompraInsumo.builder()
					.totalCompra(new BigDecimal(1000))
					.detalles(Collections.singletonList(detalleCompra1))
					.build();

			detalleCompra1.setCompraInsumo(compraInsumo1);

			compraInsumoRepository.save(compraInsumo1);

			Domicilio domicilio1 = Domicilio.builder()
					.calle("calle falsa")
					.numero(123)
					.codigoPostal(1234)
					.build();

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(1000)
					.producto(producto1)
					.subtotalCosto(234)
					.build();

			Pedido pedido1 = Pedido.builder()
					.estadoActual(EstadoPedido.PENDIENTE_PAGO)
					.formaPago(FormaPago.MERCADO_PAGO)
					.domicilioEntrega(domicilio1)
					.detalles(new ArrayList<>())
					.build();

			pedido1.addDetallePedido(detallePedido1);




			Factura factura1 = Factura.builder()
					.pedido(pedido1)
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalVenta(BigDecimal.valueOf(1000))
					.build();

			DetalleFactura detalleFactura1 = DetalleFactura.builder()
					.producto(producto1)
					.cantidad(1234)
					.cantidad(1)
					.factura(factura1)
					.build();



			Persona persona1 = Persona.builder()
					.apellido("Messi")
					.nombre("Lionel")
					.rol(Rol.ADMINISTRADOR)
					.domicilios(Collections.singletonList(domicilio1))
					.pedidos(Collections.singletonList(pedido1))
					.email("admin@gmail.com")
					.telefono(String.valueOf(21332))
					.password("$2a$10$xvNOv08CGNYWUd59RLlwnuN.xF7SgBjsNxfrMCWh59ONjE.QfNx0K")
					.build();

			personaRepository.save(persona1);

			facturaRepository.save(factura1);
			detalleFacturaRepository.save(detalleFactura1);















		};


	}
}
