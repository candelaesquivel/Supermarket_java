package supermercadoTpo;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Vector;

public class Caja {
	
	private LocalDate fecha;
	private int numeroCaja;
	private String nombreCajero;
	private float saldoInicialEfectivo;
	private float saldoFinalEfectivo;
	private ArrayList<Venta> ventas;

	
	public Caja(LocalDate fecha, int numeroCaja, String nombreCajero, float saldoInicialEfectivo  ) {
		super();
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.saldoInicialEfectivo = saldoInicialEfectivo;
		this.saldoFinalEfectivo = saldoInicialEfectivo;
		this.ventas = new ArrayList<Venta>();

	}
	


	public float getSaldoFinalEfectivo() {
		return saldoFinalEfectivo;
	}

	public void setSaldoFinalEfectivo(float saldoFinalEfectivo) {
		this.saldoFinalEfectivo = saldoFinalEfectivo;
	}

	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(int numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	public String getNombreCajero() {
		return nombreCajero;
	}

	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}

	public float getSaldoInicialEfectivo() {
		return saldoInicialEfectivo;
	}

	public void setSaldoInicialEfectivo(float saldoInicialEfectivo) {
		this.saldoInicialEfectivo = saldoInicialEfectivo;
	}

	
	public boolean sosCaja(int numeroCaja2) {
		return (numeroCaja2 == numeroCaja);
	}

	public boolean tienesEseCajero(String nombreCajero2) {
		return nombreCajero.equalsIgnoreCase(nombreCajero2);
	}

	public boolean estaEnLaFecha(LocalDate fecha2) {
		return (fecha.equals(fecha2));
	}

	public float agregarVenta(int pagoCliente, Venta ventaa) {
		float vuelto;
		float monto;
		ventas.add(ventaa);
		monto = ventaa.getTotalVenta();
		vuelto = pagoCliente - monto;

		saldoFinalEfectivo += monto;

		return vuelto;

	}

	public ArrayList<Venta> getInformeConsultaVenta() {
		return ventas;

	}

	public Vector<Vector<String>> getVectorVenta() {
		Vector<Vector<String>> ventass = new Vector<Vector<String>>();
		for(Venta venta : ventas) {
			ventass.add(venta.getVectorVenta());
		}
		return ventass;
	}
	public Vector<String> getVector() {
		Vector<String> datos = new Vector<String>();
	
		datos.add(fecha.toString());
		datos.add(numeroCaja+"");
		datos.add(nombreCajero);
		datos.add(String.valueOf(saldoInicialEfectivo));
		datos.add(String.valueOf(saldoFinalEfectivo));
		return datos;
	}

	public CajaView getView() {
		return (new CajaView( fecha, numeroCaja, nombreCajero, saldoInicialEfectivo , saldoFinalEfectivo) );
	}
	
}
