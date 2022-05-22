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
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AbrirCaja extends JFrame {

	private JPanel contentPane;
	private JTextField NumeroCaja;
	private JTextField Cajero;
	private JTextField SaldoInicialEfectivo;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_2;

	public AbrirCaja() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Abrir Caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		NumeroCaja = new JTextField();
		NumeroCaja.setBounds(141, 47, 358, 20);
		contentPane.add(NumeroCaja);
		NumeroCaja.setColumns(10);

		Cajero = new JTextField();
		Cajero.setBounds(141, 91, 358, 20);
		contentPane.add(Cajero);
		Cajero.setColumns(10);

		SaldoInicialEfectivo = new JTextField();
		SaldoInicialEfectivo.setBounds(141, 136, 358, 20);
		contentPane.add(SaldoInicialEfectivo);
		SaldoInicialEfectivo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Numero de caja:");
		lblNewLabel.setBounds(10, 50, 135, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cajero:");
		lblNewLabel_1.setBounds(53, 94, 49, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Saldo inicial efectivo:");
		lblNewLabel_3.setBounds(10, 139, 135, 14);
		contentPane.add(lblNewLabel_3);

		btnNewButton = new JButton("Abrir Caja");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					float saldo = Float.valueOf(SaldoInicialEfectivo.getText());
					int numeroCaja = Integer.parseInt(NumeroCaja.getText());

					if (!Cajero.getText().equals("") && saldo >= 0 && numeroCaja >0) {
						ResultadoView resultado = Supermercado.getInstancia().abrirCaja(LocalDate.now(), numeroCaja,
								Cajero.getText(), saldo);

						if (resultado.isResultado())
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "Confirmación",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, resultado.getMensaje(), "ERROR",
									JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
					}

					NumeroCaja.setText("");
					Cajero.setText("");
					SaldoInicialEfectivo.setText("");

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, "Verifique datos ingresados", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnNewButton.setBounds(165, 251, 103, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumeroCaja.setText("");
				Cajero.setText("");
				SaldoInicialEfectivo.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada", "Cancelacion", JOptionPane.CANCEL_OPTION);
			}

		});
		btnNewButton_1.setBounds(312, 251, 103, 23);
		contentPane.add(btnNewButton_1);

		lblNewLabel_6 = new JLabel("Fecha de hoy :");
		lblNewLabel_6.setBounds(20, 186, 111, 14);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("");
		ImageIcon ImageIcon = new ImageIcon(
				new ImageIcon("foto\\organico.jpg").getImage().getScaledInstance(121, 79, Image.SCALE_DEFAULT));
		lblNewLabel_7.setBounds(10, 228, 121, 79);
		lblNewLabel_7.setIcon(ImageIcon);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_2 = new JLabel(LocalDate.now().toString());
		lblNewLabel_2.setBounds(141, 186, 166, 14);
		contentPane.add(lblNewLabel_2);

	}

}
