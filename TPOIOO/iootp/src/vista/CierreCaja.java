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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CierreCaja extends JFrame {

	private JPanel contentPane;
	private JTextField numeroCaja;

	/**
	 * Create the frame.
	 */
	public CierreCaja() {
		setTitle("Cierre Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 235);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		numeroCaja = new JTextField();
		numeroCaja.setBounds(113, 66, 214, 20);
		contentPane.add(numeroCaja);
		numeroCaja.setColumns(10);

		JLabel lblNewLabel = new JLabel("Numero de caja: ");
		lblNewLabel.setBounds(10, 69, 164, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Cerrar caja");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int numeroCajaa = Integer.parseInt(numeroCaja.getText());
					ResultadoView cierreCaja = Supermercado.getInstancia().cierreCaja(numeroCajaa);

					if (cierreCaja.isResultado()) {

						CierreCajaInforme ventana2 = new CierreCajaInforme(numeroCajaa);
						ventana2.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, cierreCaja.getMensaje(), "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnNewButton.setBounds(102, 142, 124, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroCaja.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(240, 142, 114, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon ImageIcon = new ImageIcon(
				new ImageIcon("foto\\cerrado.png").getImage().getScaledInstance(50, 37, Image.SCALE_DEFAULT));
		lblNewLabel_1.setBounds(20, 129, 50, 37);
		lblNewLabel_1.setIcon(ImageIcon);
		contentPane.add(lblNewLabel_1);

	}
}
