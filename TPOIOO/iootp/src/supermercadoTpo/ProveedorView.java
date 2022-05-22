package supermercadoTpo;

public class ProveedorView {
	private int CUIT;
	private String razonSocial;
	private String domicilio;
	private int telefono;
	private String email;
	private String estado;

	public ProveedorView(int cUIT, String razonSocial, String domicilio, int telefono, String email, String estado) {
		super();
		CUIT = cUIT;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
	}

	public int getCUIT() {
		return CUIT;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getEstado() {
		return estado;
	}

}
