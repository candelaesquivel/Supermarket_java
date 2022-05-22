package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ResultadoView;
import controlador.Supermercado;
import supermercadoTpo.Producto;
import supermercadoTpo.ProductoView;
import supermercadoTpo.Proveedor;
import supermercadoTpo.ProveedorView;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ModificarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField descripcion;
	private JTextField marca;
	private JTextField precio;
	private JTextField stockMin;
	private JTextField pedidoRepo;
	private JTextField stock;
	private JTextField cuit;
	private JTextField codigo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Create the frame.
	 */
	public ModificarProducto() {
		setTitle("Modificar producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 398);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		descripcion = new JTextField();
		descripcion.setBounds(124, 253, 271, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);

		marca = new JTextField();
		marca.setBounds(124, 96, 271, 20);
		contentPane.add(marca);
		marca.setColumns(10);

		precio = new JTextField();
		precio.setBounds(124, 127, 271, 20);
		contentPane.add(precio);
		precio.setColumns(10);

		stockMin = new JTextField();
		stockMin.setBounds(124, 158, 271, 20);
		contentPane.add(stockMin);
		stockMin.setColumns(10);

		pedidoRepo = new JTextField();
		pedidoRepo.setBounds(124, 191, 271, 20);
		contentPane.add(pedidoRepo);
		pedidoRepo.setColumns(10);

		stock = new JTextField();
		stock.setBounds(124, 222, 271, 20);
		contentPane.add(stock);
		stock.setColumns(10);

		cuit = new JTextField();
		cuit.setBounds(124, 65, 117, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);

		codigo = new JTextField();
		codigo.setBounds(124, 34, 117, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);

		lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(32, 37, 49, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Descripcion:");
		lblNewLabel_1.setBounds(32, 256, 87, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setBounds(32, 99, 49, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(32, 130, 59, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Stock min. :");
		lblNewLabel_4.setBounds(32, 161, 70, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Pedido repo. :");
		lblNewLabel_5.setBounds(32, 194, 82, 14);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Stock:");
		lblNewLabel_6.setBounds(42, 225, 49, 14);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("CUIT:");
		lblNewLabel_7.setBounds(32, 68, 49, 14);
		contentPane.add(lblNewLabel_7);

		btnNewButton = new JButton("Modificar");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float PRECIO = Float.parseFloat(precio.getText());
					int STOCKMIN = Integer.parseInt(stockMin.getText());
					int PEDIDOREPO = Integer.parseInt(pedidoRepo.getText());
					int STOCK = Integer.parseInt(stock.getText());
					int CUIT = Integer.parseInt(cuit.getText());

					ResultadoView resultado = Supermercado.getInstancia().modificarProducto(codigo.getText(),
							descripcion.getText(), marca.getText(), PRECIO, STOCKMIN, PEDIDOREPO, STOCK, CUIT);

					if (resultado.isResultado()) {

						JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Confirmación",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, resultado.getMensaje(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					descripcion.setText("");
					marca.setText("");
					precio.setText("");
					stockMin.setText("");
					pedidoRepo.setText("");
					stock.setText("");
					cuit.setText("");
					codigo.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(90, 314, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descripcion.setText("");
				marca.setText("");
				precio.setText("");
				stockMin.setText("");
				pedidoRepo.setText("");
				stock.setText("");
				cuit.setText("");
				codigo.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(269, 314, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int CUIT = Integer.parseInt(cuit.getText());
					ProveedorView prov = Supermercado.getInstancia().buscarProveedorView(CUIT);
					if (!codigo.getText().equals("")) {
						ProductoView prod = Supermercado.getInstancia().buscarProductoView(codigo.getText());
						if (prod != null && prov != null) {

							descripcion.setText(prod.getDescripcion());
							marca.setText(prod.getMarca());
							precio.setText(String.valueOf(prod.getPrecio()));
							stockMin.setText(String.valueOf(prod.getStockMinimo()));
							pedidoRepo.setText(String.valueOf(prod.getPedidoReposicion()));
							stock.setText(String.valueOf(prod.getStock()));

						} else {
							JOptionPane.showMessageDialog(null, "No se encontro un producto con esos datos ", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "No se ingreso un codigo ", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Datos invalidos ", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		}

		);
		btnNewButton_2.setBackground(new Color(189, 183, 107));
		btnNewButton_2.setBounds(266, 64, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
