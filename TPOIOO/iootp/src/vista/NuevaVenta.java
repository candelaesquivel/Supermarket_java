package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ResultadoView;
import controlador.Supermercado;
import supermercadoTpo.Caja;

import supermercadoTpo.Venta;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NuevaVenta extends JFrame {

	private JPanel contentPane;
	private JTextField numeroVenta;
	private JTextField numeroCaja;
	private JTextField cajero;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_4;

	/**
	 * Create the frame.
	 */
	public NuevaVenta() {
		setTitle("Nueva Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 563, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		numeroVenta = new JTextField();
		numeroVenta.setBounds(154, 37, 368, 20);
		contentPane.add(numeroVenta);
		numeroVenta.setColumns(10);

		numeroCaja = new JTextField();
		numeroCaja.setBounds(154, 83, 368, 20);
		contentPane.add(numeroCaja);
		numeroCaja.setColumns(10);

		cajero = new JTextField();
		cajero.setBounds(154, 127, 368, 20);
		contentPane.add(cajero);
		cajero.setColumns(10);

		JLabel lblNewLabel = new JLabel("Numero de venta:");
		lblNewLabel.setBounds(10, 40, 106, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numero de caja:");
		lblNewLabel_1.setBounds(10, 86, 106, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha de hoy: ");
		lblNewLabel_2.setBounds(29, 179, 87, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cajero:");
		lblNewLabel_3.setBounds(29, 130, 73, 14);
		contentPane.add(lblNewLabel_3);

		btnNewButton = new JButton("Crear venta");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int NUMEROCAJA = Integer.parseInt(numeroCaja.getText());
					int NUMEROVENTA = Integer.parseInt(numeroVenta.getText());

					if (!cajero.getText().equals("") && NUMEROVENTA >0 && NUMEROCAJA>0) {
						ResultadoView resultado = Supermercado.getInstancia().nuevaVenta(LocalDate.now(), NUMEROVENTA,
								NUMEROCAJA, cajero.getText());
						if (resultado.isResultado())
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Confirmación",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "ERROR",
									JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Dejo un campo vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					numeroVenta.setText("");
					numeroCaja.setText("");
					cajero.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(115, 209, 116, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroVenta.setText("");
				numeroCaja.setText("");
				cajero.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(298, 209, 116, 23);
		contentPane.add(btnNewButton_1);

		lblNewLabel_7 = new JLabel("");
		ImageIcon ImageIcon = new ImageIcon(
				new ImageIcon("foto\\supermercado.png").getImage().getScaledInstance(175, 61, Image.SCALE_DEFAULT));
		lblNewLabel_7.setBounds(166, 252, 175, 61);
		lblNewLabel_7.setIcon(ImageIcon);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_4 = new JLabel(LocalDate.now().toString());
		lblNewLabel_4.setBounds(154, 179, 106, 14);
		contentPane.add(lblNewLabel_4);

		;

	}

}
