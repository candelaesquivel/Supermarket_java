package controlador;

public class ResultadoView {

	private boolean resultado;
	private String mensaje;
	private float valores;

	public ResultadoView(boolean resultado, String mensaje, float valores) {
		super();
		this.resultado = resultado;
		this.mensaje = mensaje;
		this.valores = valores;
	}

	public boolean isResultado() {
		return resultado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public float getValores() {
		return valores;
	}

}
