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
import javax.swing.JLabel;
import java.awt.Color;

public class InformeDC extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollpane;
	

	/**
	 * Create the frame.
	 */
	public InformeDC(int numeroCaja , LocalDate fecha , String cajero) {
		setTitle("Informe Diario de Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 425, 243);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Numero de caja : "+ numeroCaja);
		lblNewLabel.setBounds(149, 30, 133, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cajero: "+ cajero);
		lblNewLabel_1.setBounds(149, 55, 133, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha :" + fecha);
		lblNewLabel_2.setBounds(149, 80, 109, 14);
		contentPane.add(lblNewLabel_2);

		Vector <String> columNames = new Vector <String>();
		columNames.add("Fecha");
		columNames.add("NumVenta");
		columNames.add("NC");
		columNames.add("Cajero");
		columNames.add("Total venta ");
	
		
		Vector <Vector <String>> datos = Supermercado.getInstancia().getVectorVentasCaja(numeroCaja);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 393, 82);
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
