package supermercadoTpo;

public class Proveedor {
	// atributos
	private int CUIT;
	private String razonSocial;
	private String domicilio;
	private int telefono;
	private String email;
	private String estado;

	// constructor
	public Proveedor(int CUIT, String razonSocial, String domicilio, int telefono, String email) {
		super();
		this.CUIT = CUIT;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
		this.estado = "activo";

	}
	// getters y setters

	public int getCUIT() {
		return CUIT;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// metodos proveedor

	public boolean sosElProveedor(int CUIT2) {
		return (CUIT2 == CUIT);
	}

	public void modificar(String razonSocial2, String domicilio2, int telefono2, String email2) {
		setRazonSocial(razonSocial2);
		setDomicilio(domicilio2);
		setTelefono(telefono2);
		setEmail(email2);

	}

	public boolean sosActivo() {
		return estado.equalsIgnoreCase("activo");
	}

	public ProveedorView getView() {
		return (new ProveedorView(CUIT, razonSocial, domicilio, telefono, email, estado));
	}

}
