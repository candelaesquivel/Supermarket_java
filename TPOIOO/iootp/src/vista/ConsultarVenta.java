package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Supermercado;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConsultarVenta extends JFrame {

	private JPanel contentPane;
	private JTextField cajero;
	private JTextField numeroCaja;
	private JTextField dia;
	private JTextField mes;
	private JTextField año;

	/**
	 * Create the frame.
	 */
	public ConsultarVenta() {
		setTitle("Consultar venta/s");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cajero = new JTextField();
		cajero.setBounds(145, 40, 238, 20);
		contentPane.add(cajero);
		cajero.setColumns(10);

		numeroCaja = new JTextField();
		numeroCaja.setBounds(145, 93, 238, 20);
		contentPane.add(numeroCaja);
		numeroCaja.setColumns(10);

		dia = new JTextField();
		dia.setBounds(172, 152, 42, 20);
		contentPane.add(dia);
		dia.setColumns(10);

		mes = new JTextField();
		mes.setBounds(259, 152, 42, 20);
		contentPane.add(mes);
		mes.setColumns(10);

		año = new JTextField();
		año.setBounds(341, 152, 42, 20);
		contentPane.add(año);
		año.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cajero:");
		lblNewLabel.setBounds(29, 43, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numero de caja:");
		lblNewLabel_1.setBounds(29, 96, 127, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setBounds(29, 155, 49, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Dia:");
		lblNewLabel_3.setBounds(145, 155, 49, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Mes:");
		lblNewLabel_4.setBounds(231, 155, 49, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("A\u00F1o:");
		lblNewLabel_5.setBounds(311, 155, 49, 14);
		contentPane.add(lblNewLabel_5);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					LocalDate FECHA;
					int NUMEROCAJA;

					if (dia.getText().equals("") || mes.getText().equals("") || año.getText().equals("")) {

						FECHA = null;

					} else {
						int DIA = Integer.parseInt(dia.getText());
						int MES = Integer.parseInt(mes.getText());
						int Año = Integer.parseInt(año.getText());

						FECHA = LocalDate.of(Año, MES, DIA);
					}

					if (numeroCaja.getText().equals("")) {
						NUMEROCAJA = 0;
					} else {
						NUMEROCAJA = Integer.parseInt(numeroCaja.getText());
					}

					ConsultarVentaInforme vista = new ConsultarVentaInforme(cajero.getText(), NUMEROCAJA, FECHA);
					vista.setVisible(true);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(75, 210, 103, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cajero.setText("");
				numeroCaja.setText("");
				dia.setText("");
				mes.setText("");
				año.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(253, 210, 107, 23);
		contentPane.add(btnNewButton_1);
	}

}
