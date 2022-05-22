package supermercadoTpo;

import java.time.LocalDate;

public class CajaView {

	private LocalDate fecha;
	private int numeroCaja;
	private String nombreCajero;
	private float saldoInicialEfectivo;
	private float saldoFinalEfectivo;

	public CajaView(LocalDate fecha, int numeroCaja, String nombreCajero, float saldoInicialEfectivo,
			float saldoFinalEfectivo) {
		super();
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.saldoInicialEfectivo = saldoInicialEfectivo;
		this.saldoFinalEfectivo = saldoFinalEfectivo;

	}

	public LocalDate getFecha() {
		return fecha;
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public String getNombreCajero() {
		return nombreCajero;
	}

	public float getSaldoInicialEfectivo() {
		return saldoInicialEfectivo;
	}

	public float getSaldoFinalEfectivo() {
		return saldoFinalEfectivo;
	}

}
