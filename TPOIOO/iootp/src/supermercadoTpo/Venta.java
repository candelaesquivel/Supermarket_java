package supermercadoTpo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class Venta {

	// atributos
	private LocalDate fecha;
	private int numeroVenta;
	private int numeroCaja;
	private String cajero;
	private ArrayList<ItemVenta> itemsVenta;

	// constructor
	public Venta(LocalDate fecha, int numeroVenta, int numeroCaja, String cajero) {
		super();
		this.fecha = fecha;
		this.numeroVenta = numeroVenta;
		this.numeroCaja = numeroCaja;
		this.cajero = cajero;
		this.itemsVenta = new ArrayList<ItemVenta>();
	}

	// getter y setters
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public int getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(int numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	public String getCajero() {
		return cajero;
	}

	public void setCajero(String cajero) {
		this.cajero = cajero;
	}

	public ArrayList<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public boolean sosVenta(int numeroVenta2) {
		return (numeroVenta2 == numeroVenta);
	}

	public boolean sosVentaEnEsaFecha(LocalDate fecha2) {
		return fecha.equals(fecha2);
	}

	public boolean sosVentaConEseCajero(String cajero2) {
		return cajero.equalsIgnoreCase(cajero2);
	}

	public boolean sosVentaConEsaCaja(int numeroCaja2) {
		return (numeroCaja2 == numeroCaja);
	}

	public float getTotalVenta() {
		float total = 0;
		for (int i = 0; i < itemsVenta.size(); i++) {
			ItemVenta aux = itemsVenta.get(i);
			total += aux.getTotalProd();
		}
		return total;
	}

	public void agregarItemVenta(int cantidad, Producto productoItemventa) {
		ItemVenta itemVentaNuevo = new ItemVenta(cantidad, productoItemventa);
		itemsVenta.add(itemVentaNuevo);
	}

	public boolean tieneEseProducto(String codigoprod) {
		for (ItemVenta item : itemsVenta) {
			if (item.sosProdItem(codigoprod))
				return true;
		}
		return false;
	}

	public Vector<String> getVectorVenta() {
		Vector<String> aux = new Vector<String>();
		aux.add(fecha.toString());
		aux.add(numeroVenta + "");
		aux.add(numeroCaja + "");
		aux.add(cajero);
		aux.add(getTotalVenta() + "");

		return aux;
	}

	public VentaView getView() {
		return (new VentaView(fecha, numeroVenta, numeroCaja, cajero, getTotalVenta()));
	}
}
