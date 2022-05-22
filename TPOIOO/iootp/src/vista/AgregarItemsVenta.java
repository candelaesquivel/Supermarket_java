package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ResultadoView;
import controlador.Supermercado;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Color;

public class AgregarItemsVenta extends JFrame {

	private JPanel contentPane;
	private JTextField numeroVenta;
	private JTextField cantidad;
	private JTextField codigoProd;

	/**
	 * Create the frame.
	 */
	public AgregarItemsVenta() {
		setTitle("Agregar items de venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 280);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		numeroVenta = new JTextField();
		numeroVenta.setBounds(140, 37, 227, 20);
		contentPane.add(numeroVenta);
		numeroVenta.setColumns(10);

		cantidad = new JTextField();
		cantidad.setBounds(140, 77, 227, 20);
		contentPane.add(cantidad);
		cantidad.setColumns(10);

		codigoProd = new JTextField();
		codigoProd.setBounds(140, 114, 227, 20);
		contentPane.add(codigoProd);
		codigoProd.setColumns(10);

		JLabel lblNewLabel = new JLabel("Numero de venta:");
		lblNewLabel.setBounds(19, 39, 176, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cantidad:");
		lblNewLabel_1.setBounds(19, 80, 176, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Codigo prod. :");
		lblNewLabel_2.setBounds(19, 116, 176, 17);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					int NUMVENTA = Integer.parseInt(numeroVenta.getText());
					int CANTIDAD = Integer.parseInt(cantidad.getText());

					if (!codigoProd.getText().equals("") && NUMVENTA > 0 && CANTIDAD >= 0) {
						ResultadoView resultado = Supermercado.getInstancia().agregarItemsVenta(NUMVENTA, CANTIDAD,
								codigoProd.getText());
						if (resultado.isResultado())
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Confirmación",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "ERROR",
									JOptionPane.ERROR_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					numeroVenta.setText("");
					cantidad.setText("");
					codigoProd.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(163, 191, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroVenta.setText("");
				cantidad.setText("");
				codigoProd.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}

		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(294, 191, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 167, 115, 65);
		ImageIcon ImageIcon = new ImageIcon(
				new ImageIcon("foto\\supermercado.png").getImage().getScaledInstance(115, 65, Image.SCALE_DEFAULT));

		lblNewLabel_3.setIcon(ImageIcon);
		contentPane.add(lblNewLabel_3);

	}

}
