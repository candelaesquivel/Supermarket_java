package supermercadoTpo;

public class ItemVenta {
	// atributos
	private int cantidad;
	private Producto producto;

	// constructor
	public ItemVenta(int cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;

	}

	// getters y setters
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	// metodos item venta
	public float getTotalProd() {
		float total = cantidad * producto.getPrecio();

		return total;
	}

	public boolean sosProdItem(String codigo2) {
		return (producto.getCodigo().equalsIgnoreCase(codigo2));
	}

}
