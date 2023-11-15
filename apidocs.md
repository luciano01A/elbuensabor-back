# Querys para la API

Las querys se organizan según la entidad con la que más se relacionan, por lo que la ruta para invocarlas siempre es:

`/api/v1/{modulo}/{entidad}/{método}`

Para todas las entidades, se provee los siguientes métodos de acceso a la base de datos:

* GET: obtener todas las filas.
* GET `/paged`: obtener todas las filas con paginación
* GET `/{id}`: obtener la fila con la id especificada
* POST: crear una nueva fila
* PUT `/{id}`: modificar la fila con la id especificada
* DELETE `/{id}`: eliminar la fila con la id especificada

## Querys Personalizadas

### Persona

* GET `/getByEmail`: obtener a la persona según su email. Argumento:
  * email

* PUT `/cambiarContrasena`: cambiar la contraseña del usuario. Argumentos:
  * id: id del usuario
  * contrasenaActual: contraseña actual del usuario, a cambiar
  * contrasenaNueva: nueva contraseña del usuario

* PUT `/cambiarDatos`: cambiar datos generales del usuario. Cuerpo:
    * id
    * nombre
    * apellido
    * telefono
    * rol
    * email

* GET `ranking`: devuelve una lista de clientes. Cuerpo:
  * fechaDesde
  * fechaHasta
  * ordenarPor: "nombre" | "pedidos" | "monto"

* PUT `/crearPedido`: crea un pedido para un usuario. Cuerpo:
  * idPersona
  * tipoEnvio
  * formaPago
  * idDomicilio

### Producto

* GET `porRubro/{denominacion}`: devuelve todos los productos de un cierto RubroProducto.

* GET `buscar`: devuelve los productos encontrados según su nombre. Argumentos:
  * s: cadena a buscar

* GET `ranking`: devuelve los productos más vendidos. Cuerpo:
  * fechaDesde
  * fechaHasta
  * rubros: arreglo con denominaciones de RubroProductos

### Pedido

* PUT `estado`: actualiza el estado de un pedido. Argumentos:
  * id: id del pedido
  * estado: el nuevo estado que se le colocará


* GET `buscar`: devuelve los pedidos encontrados según su id y filtros. Cuerpo:
  * id: número contenido en la id
  * estados: arreglo con los posibles estados de los pedidos

* PUT `/agregarDetalle`: añade o modifica un DetallePedido al Pedido. Cuerpo:
  * idPedido
  * idProducto
  * cantidad: número a sumar a la cantidad ya existente en ese pedido del producto indicado.

### Insumo

* GET `stockBajo`: devuelve los insumos que se consideran bajos de stock.


### Factura

* GET `movimientos`: calcula, a partir de las facturas, los ingresos en un cierto período. Argumentos:
  * fechaDesde
  * fechaHasta

### NotaCredito

* GET `movimientos`: calcula, a partir de las notas de crédito, los egresos en un cierto período. Argumentos:
  * fechaDesde
  * fechaHasta

### CompraInsumo

GET `movimientos`: calcula, a partir de las compras de insumos, los egresos en un cierto período. Argumentos:
  * fechaDesde
  * fechaHasta