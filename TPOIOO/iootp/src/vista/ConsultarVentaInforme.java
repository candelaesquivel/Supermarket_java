package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Supermercado;
import java.awt.Color;

public class ConsultarVentaInforme extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollpane;

	/**
	 * Create the frame.
	 */
	public ConsultarVentaInforme(String cajero,  int numeroCaja , LocalDate fecha) {
		setTitle("Ventas Consultadas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Vector <String> columNames = new Vector <String>();
		columNames.add("Fecha");
		columNames.add("Num.Venta");
		columNames.add("Num.Caja");
		columNames.add("Cajero");
		columNames.add("Total");
		
	
		Vector <Vector <String>> datos = Supermercado.getInstancia().getVectorConsultaVenta(cajero , numeroCaja , fecha);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 45, 344, 154);
		contentPane.add(scrollPane);
		
		DefaultTableModel jTable1Model = new DefaultTableModel(datos, columNames);
		table = new JTable();		
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setModel(jTable1Model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setLocation(new Point(9, 9));
		table.getTableHeader().setVisible(true);
		scrollPane.setViewportView(table);
		
	}

}
