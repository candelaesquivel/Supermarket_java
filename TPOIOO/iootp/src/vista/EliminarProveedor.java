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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EliminarProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField cuit;

	/**
	 * Create the frame.
	 */
	public EliminarProveedor() {
		setTitle("Eliminar proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 210);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CUIT:");
		lblNewLabel.setBounds(32, 60, 49, 14);
		contentPane.add(lblNewLabel);

		cuit = new JTextField();
		cuit.setBounds(91, 57, 245, 20);
		contentPane.add(cuit);
		cuit.setColumns(10);

		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int CUIT = Integer.parseInt(cuit.getText());

					ResultadoView resultado = Supermercado.getInstancia().eliminarProveedor(CUIT);

					if (resultado.isResultado())
						JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Eliminación",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Eliminación",
								JOptionPane.INFORMATION_MESSAGE);
					cuit.setText("");

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(63, 125, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuit.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(215, 125, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
