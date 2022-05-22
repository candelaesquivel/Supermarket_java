package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ResultadoView;
import controlador.Supermercado;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class informeDiarioDeCaja extends JFrame {

	private JPanel contentPane;
	private JTextField numeroCaja;
	private JTextField cajero;
	private JTextField dia;
	private JTextField mes;
	private JTextField año;

	
	/**
	 * Create the frame.
	 */
	public informeDiarioDeCaja() {
		setTitle("Informe diario de caja ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 249);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numeroCaja = new JTextField();
		numeroCaja.setBounds(115, 42, 204, 20);
		contentPane.add(numeroCaja);
		numeroCaja.setColumns(10);
		
		cajero = new JTextField();
		cajero.setBounds(115, 80, 204, 20);
		contentPane.add(cajero);
		cajero.setColumns(10);
		
		dia = new JTextField();
		dia.setBounds(109, 126, 31, 20);
		contentPane.add(dia);
		dia.setColumns(10);
		
		JButton btnNewButton = new JButton("Obtener informe");
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 
					if(numeroCaja.getText().equals("") || dia.getText().equals("") || mes.getText().equals("") 
							|| año.getText().equals("") || cajero.getText().equals("") ) {
						
						
					JOptionPane.showMessageDialog(null, "Dejo algun dato sin llenar","ERROR",JOptionPane.ERROR_MESSAGE);
					
					}else {
						int NUMEROCAJA = Integer.parseInt(numeroCaja.getText());
						int diaa = Integer.parseInt(dia.getText());
						int mess = Integer.parseInt(mes.getText());
						int anioo = Integer.parseInt(año.getText());
						LocalDate FECHA = LocalDate.of(anioo, mess, diaa);
						
						ResultadoView resultado= Supermercado.getInstancia().informeDiarioCaja(FECHA, NUMEROCAJA, cajero.getText());
						
						if(resultado.isResultado()) {
							InformeDC vista = new InformeDC(NUMEROCAJA , FECHA , cajero.getText());
							vista.setVisible(true);
						}else {
							
							JOptionPane.showMessageDialog(null, resultado.getMensaje(),"ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
						
					}
					catch (Exception ex) {
						
						JOptionPane.showMessageDialog(null, "Verifique datos ingresados","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					
			}
		});
		btnNewButton.setBounds(40, 166, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroCaja.setText("");
				cajero.setText("");
				dia.setText("");
				mes.setText("");
				año.setText("");
				JOptionPane.showMessageDialog(null, "Operación  Cancelada","Cancelacion",JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setBounds(194, 166, 125, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Numero de caja:");
		lblNewLabel.setBounds(10, 45, 119, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cajero:");
		lblNewLabel_1.setBounds(25, 83, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setBounds(25, 126, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		mes = new JTextField();
		mes.setBounds(186, 126, 31, 20);
		contentPane.add(mes);
		mes.setColumns(10);
		
		año = new JTextField();
		año.setBounds(269, 126, 31, 20);
		contentPane.add(año);
		año.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dia:");
		lblNewLabel_3.setBounds(80, 126, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mes:");
		lblNewLabel_4.setBounds(150, 126, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("A\u00F1o:");
		lblNewLabel_5.setBounds(234, 126, 49, 14);
		contentPane.add(lblNewLabel_5);
	}

}
