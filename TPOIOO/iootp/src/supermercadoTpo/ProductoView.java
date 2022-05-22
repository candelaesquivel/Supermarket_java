package supermercadoTpo;

public class ProductoView {
	private String codigo;
	private String descripcion;
	private String marca;
	private float precio;
	private int stockMinimo;
	private int pedidoReposicion;
	private int stock;
	private String estado;
	private int CUIT;

	public ProductoView(String codigo, String descripcion, String marca, float precio, int stockMinimo,
			int pedidoReposicion, int stock, String estado, int cUIT) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.stockMinimo = stockMinimo;
		this.pedidoReposicion = pedidoReposicion;
		this.stock = stock;
		this.estado = estado;
		CUIT = cUIT;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public float getPrecio() {
		return precio;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public int getPedidoReposicion() {
		return pedidoReposicion;
	}

	public int getStock() {
		return stock;
	}

	public String getEstado() {
		return estado;
	}

	public int getCUIT() {
		return CUIT;
	}

}
