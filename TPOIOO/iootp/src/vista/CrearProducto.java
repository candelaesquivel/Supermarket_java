package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ResultadoView;
import controlador.Supermercado;
import supermercadoTpo.Producto;

import supermercadoTpo.Proveedor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CrearProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField descripcion;
	private JTextField marca;
	private JTextField precio;
	private JTextField stockMinimo;
	private JTextField stock;
	private JTextField pedidoRepo;
	private JTextField cuit;

	/**
	 * Create the frame.
	 */
	public CrearProducto() {
		setTitle("Crear Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		codigo = new JTextField();
		codigo.setBounds(157, 23, 384, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);

		descripcion = new JTextField();
		descripcion.setBounds(157, 56, 384, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);

		marca = new JTextField();
		marca.setBounds(157, 87, 384, 20);
		contentPane.add(marca);
		marca.setColumns(10);

		precio = new JTextField();
		precio.setBounds(157, 118, 384, 20);
		contentPane.add(precio);
		precio.setColumns(10);

		stockMinimo = new JTextField();
		stockMinimo.setBounds(157, 149, 384, 20);
		contentPane.add(stockMinimo);
		stockMinimo.setColumns(10);

		stock = new JTextField();
		stock.setBounds(157, 180, 384, 20);
		contentPane.add(stock);
		stock.setColumns(10);

		pedidoRepo = new JTextField();
		pedidoRepo.setBounds(157, 211, 384, 20);
		contentPane.add(pedidoRepo);
		pedidoRepo.setColumns(10);

		cuit = new JTextField();
		cuit.setBounds(157, 242, 384, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);

		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(69, 26, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setBounds(53, 63, 81, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setBounds(69, 90, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(69, 121, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Stock Minimo:");
		lblNewLabel_4.setBounds(43, 149, 100, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Stock:");
		lblNewLabel_5.setBounds(69, 183, 49, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Pedido de reposicion:");
		lblNewLabel_6.setBounds(26, 214, 134, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("CUIT:");
		lblNewLabel_7.setBounds(69, 245, 49, 14);
		contentPane.add(lblNewLabel_7);

		JButton btnNewButton = new JButton("Crear producto");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int PRECIO = Integer.parseInt(precio.getText());
					int STOCKMIN = Integer.parseInt(stockMinimo.getText());
					int STOCK = Integer.parseInt(stock.getText());
					int PEDIDOREPO = Integer.parseInt(pedidoRepo.getText());
					int CUIT = Integer.parseInt(cuit.getText());

					if (PRECIO > 0 && STOCKMIN > 0 && STOCK >= 0 && PEDIDOREPO >= 0 && !codigo.getText().equals("")
							&& !descripcion.getText().equals("") && !marca.getText().equals("")) {
						ResultadoView resultado = Supermercado.getInstancia().crearProducto(codigo.getText(),
								descripcion.getText(), marca.getText(), PRECIO, STOCKMIN, STOCK, PEDIDOREPO, CUIT);
						if (resultado.isResultado())
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Confirmación",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "ERROR",
									JOptionPane.ERROR_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Datos invalidos", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					codigo.setText("");
					descripcion.setText("");
					marca.setText("");
					precio.setText("");
					stockMinimo.setText("");
					stock.setText("");
					pedidoRepo.setText("");
					cuit.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(69, 299, 164, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.setText("");
				descripcion.setText("");
				marca.setText("");
				precio.setText("");
				stockMinimo.setText("");
				stock.setText("");
				pedidoRepo.setText("");
				cuit.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(312, 299, 164, 23);
		contentPane.add(btnNewButton_1);
	}
}
