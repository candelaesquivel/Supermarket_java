package supermercadoTpo;

import java.util.Vector;

public class Producto {
	// atributos
	private String codigo;
	private String descripcion;
	private String marca;
	private float precio;
	private int stockMinimo;
	private int pedidoReposicion;
	private int stock;
	private String estado;
	private int CUIT;

	// constructor

	public Producto(String codigo, String descripcion, String marca, float precio, int stockMinimo,
			int pedidoReposicion, int stock, int CUIT) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.stockMinimo = stockMinimo;
		this.pedidoReposicion = pedidoReposicion;
		this.stock = stock;
		this.estado = "activo";
		this.CUIT = CUIT;
	}

	// getter y setters
	public String getCodigo() {
		return codigo;
	}

	public int getCUIT() {
		return CUIT;
	}

	public void setCUIT(int cUIT) {
		CUIT = cUIT;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getPedidoReposicion() {
		return pedidoReposicion;
	}

	public void setPedidoReposicion(int pedidoReposicion) {
		this.pedidoReposicion = pedidoReposicion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean sosProducto(String codigo2) {

		return (codigo.equalsIgnoreCase(codigo2));
	}

	public boolean sosProductoStockMinimoOmenos() {

		return (stock <= stockMinimo);
	}

	public void modificar(String descripcion2, String marca2, float precio2, int stockMinimo2, int pedidoReposicion2,
			int stock2, int CUIT) {
		setDescripcion(descripcion2);
		setMarca(marca2);
		setPrecio(precio2);
		setStockMinimo(stockMinimo2);
		setPedidoReposicion(pedidoReposicion2);
		setStock(stock2);
		setCUIT(CUIT);

	}

	public void actualizarStock(int cantidadVendida) {
		int stockNuevo = getStock() - cantidadVendida;
		setStock(stockNuevo);

	}

	public boolean sosActivo() {
		return estado.equalsIgnoreCase("activo");
	}

	public boolean sosProductoProveedor(int CUIT2) {

		return (CUIT == CUIT2);
	}

	public Vector<String> getVector() {
		Vector<String> datos = new Vector<String>();
		datos.add(codigo);
		datos.add(descripcion);
		datos.add(marca);
		datos.add(String.valueOf(precio));
		datos.add(String.valueOf(stockMinimo));
		datos.add(String.valueOf(pedidoReposicion));
		datos.add(String.valueOf(stock));
		datos.add(estado);
		datos.add(String.valueOf(CUIT));

		return datos;
	}

	public ProductoView getView() {
		return (new ProductoView(codigo, descripcion, marca, precio, stockMinimo, pedidoReposicion, stock, estado,
				CUIT));
	}

}
