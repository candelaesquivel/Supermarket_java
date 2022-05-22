package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField cuit;
	private JTextField razonSocial;
	private JTextField domicilio;
	private JTextField telefono;
	private JTextField email;

	/**
	 * Create the frame.
	 */
	public ModificarProveedor() {
		setTitle("Modificar proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 396);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CUIT:");
		lblNewLabel.setBounds(30, 56, 49, 14);
		contentPane.add(lblNewLabel);

		cuit = new JTextField();
		cuit.setBounds(120, 53, 106, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);

		razonSocial = new JTextField();
		razonSocial.setBounds(120, 124, 209, 20);
		contentPane.add(razonSocial);
		razonSocial.setColumns(10);

		domicilio = new JTextField();
		domicilio.setBounds(120, 155, 209, 20);
		contentPane.add(domicilio);
		domicilio.setColumns(10);

		telefono = new JTextField();
		telefono.setBounds(120, 186, 209, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);

		email = new JTextField();
		email.setBounds(120, 227, 209, 20);
		contentPane.add(email);
		email.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Razon social:");
		lblNewLabel_2.setBounds(30, 127, 80, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Domicilio:");
		lblNewLabel_3.setBounds(30, 158, 80, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Telefono:");
		lblNewLabel_4.setBounds(30, 189, 80, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(30, 230, 80, 14);
		contentPane.add(lblNewLabel_5);

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					int CUIT = Integer.parseInt(cuit.getText());
					int TEL = Integer.parseInt(telefono.getText());

					ResultadoView resultado = Supermercado.getInstancia().modificarProovedor(CUIT,
							razonSocial.getText(), domicilio.getText(), TEL, email.getText());

					if (resultado.isResultado())
						JOptionPane.showMessageDialog(null, "Operación exitosa", "Confirmación",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Proveedor con CUIT " + CUIT + " inexistente", "ERROR",
								JOptionPane.ERROR_MESSAGE);

					cuit.setText("");
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
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.setBounds(86, 296, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuit.setText("");
				razonSocial.setText("");
				domicilio.setText("");
				telefono.setText("");
				email.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(261, 296, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBackground(new Color(189, 183, 107));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int CUIT = Integer.parseInt(cuit.getText());
					ProveedorView prov = Supermercado.getInstancia().buscarProveedorView(CUIT);
					if (prov != null) {

						razonSocial.setText(prov.getRazonSocial());
						domicilio.setText(prov.getDomicilio());
						telefono.setText(String.valueOf(prov.getTelefono()));
						email.setText(prov.getEmail());
					} else {
						JOptionPane.showMessageDialog(null, "Codigo invalido ", "ERROR", JOptionPane.ERROR_MESSAGE);

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Datos invalidos ", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnNewButton_2.setBounds(261, 52, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
