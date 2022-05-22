package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Supermercado;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class InformeProdStockMin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollpane;

	
	/**
	 * Create the frame.
	 */
	public InformeProdStockMin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Vector <String> columNames = new Vector <String>();
		columNames.add("Codigo");
		columNames.add("Desc.");
		columNames.add("Marca");
		columNames.add("Precio");
		columNames.add("StkMin ");
		columNames.add("PedRep");
		columNames.add("Stock");
		columNames.add("estado");
		columNames.add("CUIT");
		
		
		Vector <Vector <String>> datos = Supermercado.getInstancia().getVectorInformeProductosStockMinimo();
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 46, 512, 237);
		contentPane.add(scrollPane);
		
		DefaultTableModel jTable1Model = new DefaultTableModel(datos, columNames);
		table = new JTable();		
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setModel(jTable1Model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setLocation(new Point(9, 9));
		table.getTableHeader().setVisible(true);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Informe Producto/s que tienen un stock =< stockMinimo");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(100, 21, 363, 14);
		contentPane.add(lblNewLabel);
	}
}
