package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ResultadoView;
import controlador.Supermercado;
import supermercadoTpo.Venta;
import supermercadoTpo.VentaView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CobrarVenta extends JFrame {

	private JPanel contentPane;
	private JTextField pagoCliente;
	private JTextField numeroVenta;

	/**
	 * Create the frame.
	 */
	public CobrarVenta() {
		setTitle("Cobrar Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pago :");
		lblNewLabel.setBounds(30, 36, 49, 33);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numero de venta:");
		lblNewLabel_1.setBounds(10, 112, 131, 14);
		contentPane.add(lblNewLabel_1);

		pagoCliente = new JTextField();
		pagoCliente.setBounds(120, 42, 257, 20);
		contentPane.add(pagoCliente);
		pagoCliente.setColumns(10);

		numeroVenta = new JTextField();
		numeroVenta.setBounds(120, 109, 257, 20);
		contentPane.add(numeroVenta);
		numeroVenta.setColumns(10);

		JButton btnNewButton = new JButton("Cobrar venta");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int PAGOCLIENTE = Integer.parseInt(pagoCliente.getText());
					int NUMEROVENTA = Integer.parseInt(numeroVenta.getText());
					if (PAGOCLIENTE > 0 && NUMEROVENTA > 0) {
						ResultadoView resultado = Supermercado.getInstancia().cobrarVenta(PAGOCLIENTE, NUMEROVENTA);
						if (resultado.isResultado())
							JOptionPane.showMessageDialog(null, "su vuelto es : $ " + resultado.getValores(), "Vuelto",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "ERROR",
									JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "monto de pago ingresado invalido", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
					pagoCliente.setText("");
					numeroVenta.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(78, 165, 119, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagoCliente.setText("");
				numeroVenta.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(244, 165, 119, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon ImageIcon = new ImageIcon(
				new ImageIcon("foto\\cajaRegistradora.png").getImage().getScaledInstance(95, 62, Image.SCALE_DEFAULT));
		lblNewLabel_2.setBounds(170, 211, 95, 62);
		lblNewLabel_2.setIcon(ImageIcon);
		contentPane.add(lblNewLabel_2);

	}

}
