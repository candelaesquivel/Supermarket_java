package controlador;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Vector;

import supermercadoTpo.Caja;
import supermercadoTpo.CajaView;
import supermercadoTpo.ItemVenta;
import supermercadoTpo.Producto;
import supermercadoTpo.ProductoView;
import supermercadoTpo.Proveedor;
import supermercadoTpo.ProveedorView;
import supermercadoTpo.Venta;

public class Supermercado {

	private ArrayList<Caja> cajas;
	private ArrayList<Producto> productos;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Venta> ventas;
	private static Supermercado instancia;

	private Supermercado() {

		this.cajas = new ArrayList<Caja>();
		this.productos = new ArrayList<Producto>();
		this.proveedores = new ArrayList<Proveedor>();
		this.ventas = new ArrayList<Venta>();
		cargoInicial();
	}

	public static Supermercado getInstancia() {
		if (instancia == null) {
			instancia = new Supermercado();
		}
		return instancia;
	}

	public ResultadoView crearProveedor(int CUIT, String razonSocial, String domicilio, int telefono, String email) {
		Proveedor newProveedor = buscarProveedor(CUIT);
		if (newProveedor == null) {
			newProveedor = new Proveedor(CUIT, razonSocial, domicilio, telefono, email);
			proveedores.add(newProveedor);
			return new ResultadoView(true, "Se creo el proveedor", 0);
		} else {
			return new ResultadoView(false, "Ya existe ese proveedor", 0);
		}
	}

	private Proveedor buscarProveedor(int CUIT) {

		for (Proveedor aux : proveedores) {
			if (aux.sosElProveedor(CUIT) && aux.sosActivo()) {
				return aux;
			}
		}
		return null;
	}

	public ProveedorView buscarProveedorView(int CUIT) {
		Proveedor prov = buscarProveedor(CUIT);
		if (prov != null)
			return prov.getView();
		else
			return null;
	}

	public ResultadoView modificarProovedor(int CUIT, String razonSocial, String domicilio, int telefono,
			String email) {
		Proveedor proveedor = buscarProveedor(CUIT);
		if (proveedor != null) {
			proveedor.modificar(razonSocial, domicilio, telefono, email);
			return new ResultadoView(true, "Se modifico el proveedor", 0);
		} else {

			return new ResultadoView(false, "NO se modifico el proveedor", 0);
		}

	}

	public ResultadoView eliminarProveedor(int CUIT) {
		boolean eliminar = false;
		Proveedor proveedor = buscarProveedor(CUIT);
		if (proveedor != null) {
			for (Producto prod : productos) {
				if (prod.sosProductoProveedor(CUIT))
					eliminar = true;
			}
			if (eliminar) {
				proveedor.setEstado("eliminado");
				return new ResultadoView(true, "Se elimino el proveedor", 0);

			} else {
				proveedores.remove(proveedor);// eliminacion fisica
				return new ResultadoView(false, "El proveedor eliminado no tenia productos asociados", 0);
			}
		} else {
			return new ResultadoView(false, "El proveedor no existe en el sistema", 0);
		}

	}

	public ResultadoView crearProducto(String codigo, String descripcion, String marca, float precio, int stockMinimo,
			int pedidoReposicion, int stock, int CUIT) {
		Producto newProducto = buscarProducto(codigo);
		Proveedor proveedor = buscarProveedor(CUIT);
		if (newProducto == null && proveedor != null) {
			newProducto = new Producto(codigo, descripcion, marca, precio, stockMinimo, pedidoReposicion, stock, CUIT);
			productos.add(newProducto);
			return new ResultadoView(true, "Se creo el producto", 0);
		}
		return new ResultadoView(false, "NO se creo el producto", 0);
	}

	private Producto buscarProducto(String codigo) {

		for (int i = 0; i < productos.size(); i++) {
			Producto aux = productos.get(i);
			if (aux.sosProducto(codigo) && aux.sosActivo()) {
				return aux;
			}
		}
		return null;
	}

	private boolean buscarProductoVendido(String codigoprod) {
		for (Venta venta : ventas) {
			if (venta.tieneEseProducto(codigoprod))
				return true;
		}
		return false;
	}

	public ProductoView buscarProductoView(String codigo) {
		Producto prod = buscarProducto(codigo);
		if (prod != null)
			return prod.getView();
		else
			return null;
	}

	public ResultadoView modificarProducto(String codigo, String descripcion, String marca, float precio,
			int stockMinimo, int pedidoReposicion, int stock, int CUIT) {
		Producto producto = buscarProducto(codigo);
		Proveedor provedor = buscarProveedor(CUIT);
		if (producto != null && provedor != null) {
			producto.modificar(descripcion, marca, precio, stockMinimo, pedidoReposicion, stock, CUIT);
			return new ResultadoView(true, "Se modifico el producto", 0);
		} else {
			return new ResultadoView(false, "No se modifico el producto", 0);
		}

	}

	public ResultadoView eliminarProducto(String codigo) {
		Producto producto = buscarProducto(codigo);
		if (producto != null) {
			if (buscarProductoVendido(codigo)) {
				producto.setEstado("eliminado");
				return new ResultadoView(true, "Se elimino el producto", 0);
			} else {
				productos.remove(producto);// eliminacion fisica
				return new ResultadoView(false, "El producto no tiene ventas asociadas", 0);
			}
		} else {
			return new ResultadoView(false, "No existe el producto en el sistema", 0);
		}
	}

	public ResultadoView abrirCaja(LocalDate fecha, int numeroCaja, String nombreCajero, float saldoInicialEfectivo) {
		Caja newCaja = buscarCaja(numeroCaja);
		if (newCaja == null) {
			newCaja = new Caja(fecha, numeroCaja, nombreCajero, saldoInicialEfectivo);
			cajas.add(newCaja);
			return new ResultadoView(true, "Caja abierta ", 0);
		} else {
			return new ResultadoView(false, "Ya esta abierta esa caja ", 0);
		}

	}

	private Caja buscarCaja(int numeroCaja) {

		for (int i = 0; i < cajas.size(); i++) {
			Caja aux = cajas.get(i);
			if (aux.sosCaja(numeroCaja)) {
				return aux;
			}
		}
		return null;
	}

	public CajaView buscarCajaView(int numeroCaja) {
		Caja caja = buscarCaja(numeroCaja);
		if (caja != null)
			return caja.getView();
		else
			return null;
	}

	public ResultadoView nuevaVenta(LocalDate fecha, int numeroVenta, int numeroCaja, String cajero) {
		Venta newVenta = buscarVenta(numeroVenta);
		Caja caja = buscarCaja(numeroCaja);
		if (newVenta == null && caja != null) {
			newVenta = new Venta(fecha, numeroVenta, numeroCaja, cajero);
			ventas.add(newVenta);
			return new ResultadoView(true, "Nueva venta creada", 0);
		}
		return new ResultadoView(false, "NO se creo la venta ", 0);
	}

	public ResultadoView agregarItemsVenta(int numeroVenta, int cantidad, String codigoProducto) {
		Venta newVenta = buscarVenta(numeroVenta);
		if (newVenta != null) {
			Producto productoItemventa = buscarProducto(codigoProducto);
			if (productoItemventa != null) {
				newVenta.agregarItemVenta(cantidad, productoItemventa);
				return new ResultadoView(true, "Se agregaron los items", 0);
			}
		}

		return new ResultadoView(false, "NO se agregaron los items", 0);
	}

	private Venta buscarVenta(int numeroVenta) {

		for (int i = 0; i < ventas.size(); i++) {
			Venta aux = ventas.get(i);
			if (aux.sosVenta(numeroVenta)) {
				return aux;
			}
		}
		return null;

	}

	public ResultadoView cobrarVenta(int pagoCliente, int numeroVenta) {

		float vuelto = 0;
		Venta ventaCobrar = buscarVenta(numeroVenta);
		if (ventaCobrar != null) {
			Caja newCaja = buscarCaja(ventaCobrar.getNumeroCaja());
			if (newCaja != null) {
				vuelto = newCaja.agregarVenta(pagoCliente, ventaCobrar);

				for (ItemVenta item : ventaCobrar.getItemsVenta()) {
					for (Producto productoActualizar : productos) {
						if (item.sosProdItem(productoActualizar.getCodigo())) {
							productoActualizar.actualizarStock(item.getCantidad());
							return new ResultadoView(true, "Se cobro la venta", vuelto);
						}
					}
				}

			}
		}
		return new ResultadoView(false, "NO se lo logro cobrar la venta ", 0);

	}

	public ResultadoView cierreCaja(int numeroCaja) {
		Caja cajaCierre = buscarCaja(numeroCaja);
		if (cajaCierre != null)
			return new ResultadoView(true, "Se cerro la caja", 0);
		else
			return new ResultadoView(false, "No existe esa caja", 0);
	}

	public ResultadoView informeDiarioCaja(LocalDate fecha, int numeroCaja, String nombreCajero) {
		Caja cajaConsultada = null;
		for (Caja caja : cajas) {
			if (caja.sosCaja(numeroCaja) && caja.estaEnLaFecha(fecha) && caja.tienesEseCajero(nombreCajero))
				cajaConsultada = caja;
		}

		if (cajaConsultada != null)
			return new ResultadoView(true, "", 0);
		else
			return new ResultadoView(false, "NO se pudo realizar el informe , verifique los datos", 0);
	}

	private ArrayList<Venta> consultarVenta(String cajero, int numeroCaja, LocalDate fecha) {
		ArrayList<Venta> ventasConsultadas = new ArrayList<Venta>();

		if (cajero.equals("") && numeroCaja == 0 && fecha == null) {
			ventasConsultadas = ventas;
		}
		if (!cajero.equals("") && numeroCaja == 0 && fecha == null) {
			for (Venta venta : ventas) {
				if (venta.sosVentaConEseCajero(cajero))
					ventasConsultadas.add(venta);
			}
		}
		if (cajero.equals("") && numeroCaja != 0 && fecha == null) {
			for (Venta venta : ventas) {
				if (venta.sosVentaConEsaCaja(numeroCaja))
					ventasConsultadas.add(venta);
			}
		}
		if (cajero.equals("") && numeroCaja == 0 && fecha != null) {
			for (Venta venta : ventas) {

				if (venta.sosVentaEnEsaFecha(fecha))
					ventasConsultadas.add(venta);
			}
		}
		if (!cajero.equals("") && numeroCaja != 0 && fecha == null) {
			for (Venta venta : ventas) {
				if (venta.sosVentaConEsaCaja(numeroCaja) && venta.sosVentaConEseCajero(cajero))
					ventasConsultadas.add(venta);
			}
		}
		if (!cajero.equals("") && numeroCaja == 0 && fecha != null) {
			for (Venta venta : ventas) {
				if (venta.sosVentaEnEsaFecha(fecha) && venta.sosVentaConEseCajero(cajero))
					ventasConsultadas.add(venta);
			}
		}
		if (cajero.equals("") && numeroCaja != 0 && fecha != null) {
			for (Venta venta : ventas) {
				if (venta.sosVentaConEsaCaja(numeroCaja) && venta.sosVentaEnEsaFecha(fecha))
					ventasConsultadas.add(venta);
			}
		}
		if (!cajero.equals("") && numeroCaja != 0 && fecha != null) {
			for (Venta venta : ventas) {
				if (venta.sosVentaConEsaCaja(numeroCaja) && venta.sosVentaEnEsaFecha(fecha)
						&& venta.sosVentaConEseCajero(cajero))
					ventasConsultadas.add(venta);
			}

		}

		return ventasConsultadas;
	}

	public Vector<Vector<String>> getVectorVentasCaja(int numeroCaja) {
		Caja caja = buscarCaja(numeroCaja);
		if (caja != null)
			return caja.getVectorVenta();
		return null;

	}

	public Vector<Vector<String>> getVectorConsultaVenta(String cajero, int numeroCaja, LocalDate fecha) {
		Vector<Vector<String>> aux = new Vector<Vector<String>>();

		ArrayList<Venta> informe = consultarVenta(cajero, numeroCaja, fecha);

		for (Venta venta : informe) {
			aux.add(venta.getVectorVenta());
		}
		return aux;
	}

	private ArrayList<Producto> getInformeProductosStockMinimo() {
		ArrayList<Producto> informe = new ArrayList<Producto>();

		for (int i = 0; i < productos.size(); i++) {
			Producto aux = productos.get(i);
			if (aux.sosProductoStockMinimoOmenos()) {
				informe.add(aux);
			}
		}
		return informe;
	}

	public Vector<Vector<String>> getVectorInformeProductosStockMinimo() {
		Vector<Vector<String>> aux = new Vector<Vector<String>>();
		ArrayList<Producto> informe = getInformeProductosStockMinimo();

		for (Producto producto : informe) {
			aux.add(producto.getVector());
		}

		return aux;
	}

	private void cargoInicial() {
		crearProveedor(1, "1", "1", 1, "1");
		crearProveedor(2, "2", "2", 2, "2");
		crearProveedor(24, "24", "24", 24, "24");

		crearProducto("1", "descrp", "marca", 1, 10, 0, 9, 1);
		crearProducto("2", "descrp", "marca", 2, 20, 0, 2, 2);
		crearProducto("3", "descrp", "marca", 2, 2, 0, 20, 2);

		abrirCaja(LocalDate.now(), 11, "11", 1000);
		abrirCaja(LocalDate.now(), 22, "22", 1000);
		abrirCaja(LocalDate.now(), 33, "33", 3000);

		nuevaVenta(LocalDate.now(), 1, 11, "11");
		nuevaVenta(LocalDate.now(), 2, 11, "11");
		nuevaVenta(LocalDate.now(), 3, 11, "11");
		nuevaVenta(LocalDate.now(), 4, 33, "33");
		nuevaVenta(LocalDate.now(), 5, 22, "22");

		agregarItemsVenta(1, 1, "1");
		agregarItemsVenta(2, 2, "2");
		agregarItemsVenta(3, 3, "3");
		agregarItemsVenta(4, 4, "3");
		agregarItemsVenta(5, 1, "3");

		cobrarVenta(100, 1);
		cobrarVenta(50000, 2);
		cobrarVenta(40, 3);
		cobrarVenta(40, 4);
		cobrarVenta(40, 5);

	}

}
