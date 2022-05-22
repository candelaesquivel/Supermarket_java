package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Supermercado;
import supermercadoTpo.CajaView;
import supermercadoTpo.Venta;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class CierreCajaInforme extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollpane;
	
	

	/**
	 * Create the frame.
	 */
	public CierreCajaInforme(int numeroCaja) {
		setTitle("Cierre de caja ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
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
		scrollPane.setBounds(20, 146, 393, 82);
		contentPane.add(scrollPane);
		
		DefaultTableModel jTable1Model = new DefaultTableModel(datos, columNames);
		table = new JTable();		
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setModel(jTable1Model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setLocation(new Point(9, 9));
		table.getTableHeader().setVisible(true);
		scrollPane.setViewportView(table);
		
		CajaView caja = Supermercado.getInstancia().buscarCajaView(numeroCaja);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha : "+ caja.getFecha().toString());
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(161, 54, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cajero: "+caja.getNombreCajero());
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(161, 35, 127, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Num.caja: "+ caja.getNumeroCaja()+"");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(161, 18, 137, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SaldoInicial: "+caja.getSaldoInicialEfectivo()+"");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(161, 71, 147, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("SaldoFinal: "+ caja.getSaldoFinalEfectivo()+"");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(161, 83, 127, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Ventas de la caja ");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(161, 108, 114, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		ImageIcon ImageIcon = new ImageIcon(new ImageIcon("foto\\cajaRegistradora.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
		lblNewLabel_6.setBounds(30, 35, 100, 100);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(ImageIcon);
		contentPane.add(lblNewLabel_6);
		
	
	}
}
