package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ResultadoView;
import controlador.Supermercado;
import supermercadoTpo.Proveedor;
import supermercadoTpo.ProveedorView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CrearProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField CUIT;
	private JTextField razonSocial;
	private JTextField domicilio;
	private JTextField telefono;
	private JTextField email;

	/**
	 * Create the frame.
	 */
	public CrearProveedor() {
		setTitle("Crea Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		CUIT = new JTextField();
		CUIT.setBounds(120, 48, 397, 20);
		contentPane.add(CUIT);
		CUIT.setColumns(10);

		razonSocial = new JTextField();
		razonSocial.setBounds(120, 91, 397, 20);
		contentPane.add(razonSocial);
		razonSocial.setColumns(10);

		domicilio = new JTextField();
		domicilio.setBounds(120, 132, 397, 20);
		contentPane.add(domicilio);
		domicilio.setColumns(10);

		telefono = new JTextField();
		telefono.setBounds(120, 172, 397, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);

		email = new JTextField();
		email.setBounds(120, 216, 397, 20);
		contentPane.add(email);
		email.setColumns(10);

		JLabel lblNewLabel = new JLabel("CUIT:");
		lblNewLabel.setBounds(46, 50, 73, 17);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Razon social:");
		lblNewLabel_1.setBounds(32, 93, 108, 17);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Domicilio:");
		lblNewLabel_2.setBounds(46, 134, 77, 17);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefono:");
		lblNewLabel_3.setBounds(46, 175, 71, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setBounds(46, 219, 49, 14);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton = new JButton("Crear proveedor");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cuit = Integer.parseInt(CUIT.getText());
					int tel = Integer.parseInt(telefono.getText());
					if (!razonSocial.getText().equals("") && !domicilio.getText().equals("")
							&& !email.getText().equals("") && tel >0 && cuit >= 0) {
						ResultadoView resultado = Supermercado.getInstancia().crearProveedor(cuit,
								razonSocial.getText(), domicilio.getText(), tel, email.getText());
						if (resultado.isResultado())
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Confirmación",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "ERROR",
									JOptionPane.ERROR_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Algun campo esta vacio", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
					CUIT.setText("");
					razonSocial.setText("");
					domicilio.setText("");
					telefono.setText("");
					email.setText("");
				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnNewButton.setBounds(110, 274, 133, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CUIT.setText("");
				razonSocial.setText("");
				domicilio.setText("");
				telefono.setText("");
				email.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(353, 274, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_5 = new JLabel("");
		ImageIcon ImageIcon = new ImageIcon(
				new ImageIcon("foto\\supermercado.png").getImage().getScaledInstance(194, 70, Image.SCALE_DEFAULT));
		lblNewLabel_5.setBounds(198, 319, 194, 70);
		lblNewLabel_5.setIcon(ImageIcon);
		contentPane.add(lblNewLabel_5);

	}
}
