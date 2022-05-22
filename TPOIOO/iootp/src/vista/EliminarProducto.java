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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EliminarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;

	/**
	 * Create the frame.
	 */
	public EliminarProducto() {
		setTitle("Eliminar producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 191);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(22, 48, 49, 14);
		contentPane.add(lblNewLabel);

		codigo = new JTextField();
		codigo.setBounds(81, 45, 242, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);

		JButton btnNewButton = new JButton("Eliminar producto");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (!codigo.getText().equals("")) {
						ResultadoView resultado = Supermercado.getInstancia().eliminarProducto(codigo.getText());

						if (resultado.isResultado())
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Eliminación",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Eliminación",
									JOptionPane.INFORMATION_MESSAGE);

						codigo.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "No ingreso ningun codigo", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(22, 108, 149, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(193, 108, 149, 23);
		contentPane.add(btnNewButton_1);
	}
}
