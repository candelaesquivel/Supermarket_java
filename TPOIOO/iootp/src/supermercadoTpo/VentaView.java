package supermercadoTpo;

import java.time.LocalDate;

public class VentaView {

	private LocalDate fecha;
	private int numeroVenta;
	private int numeroCaja;
	private String cajero;
	private float totalVenta;

	public VentaView(LocalDate fecha, int numeroVenta, int numeroCaja, String cajero, float totalVenta) {
		super();
		this.fecha = fecha;
		this.numeroVenta = numeroVenta;
		this.numeroCaja = numeroCaja;
		this.totalVenta = totalVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public int getNumeroVenta() {
		return numeroVenta;
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public String getCajero() {
		return cajero;
	}

	public float getTotalVenta() {
		return totalVenta;
	}

}
