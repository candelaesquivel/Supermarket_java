package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setBackground(Color.WHITE);
		
		
		setTitle("Menu Supermercado Organico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 369);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Proveedores");
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Crear proveedor");
		mntmNewMenuItem.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProveedor ventana = new CrearProveedor();
				ventana.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar proveedor");
		mntmNewMenuItem_1.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModificarProveedor ventana2 = new ModificarProveedor();
				ventana2.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Eliminar proveedor");
		mntmNewMenuItem_2.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProveedor ventana3 = new EliminarProveedor();
				ventana3.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Productos");
		mnNewMenu_1.setBackground(new Color(50, 205, 50));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crear producto ");
		mntmNewMenuItem_3.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProducto ventanaa = new CrearProducto();
				ventanaa.setVisible(true);
			
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Modificar producto");
		mntmNewMenuItem_4.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto ventanaa = new ModificarProducto();
				ventanaa.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Eliminar producto ");
		mntmNewMenuItem_5.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto ventana = new EliminarProducto();
				ventana.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Cajas");
		mnNewMenu_2.setBackground(new Color(189, 183, 107));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Abrir caja");
		mntmNewMenuItem_6.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirCaja cajaVentana = new AbrirCaja();
				cajaVentana.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Cerrar caja");
		mntmNewMenuItem_7.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CierreCaja ventana = new CierreCaja();
				ventana.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Crear nueva venta");
		mntmNewMenuItem_12.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaVenta ventana = new NuevaVenta();
				ventana.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Consultar venta");
		mntmNewMenuItem_8.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarVenta ventana = new ConsultarVenta();
				ventana.setVisible(true);
				
			}
		});
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Cobrar venta");
		mntmNewMenuItem_11.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CobrarVenta ventana = new CobrarVenta();
				ventana.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Agregar item/s venta");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarItemsVenta ventana = new AgregarItemsVenta();
				ventana.setVisible(true);
				
			}
		});
		mntmNewMenuItem_13.setBackground(new Color(189, 183, 107));
		mnNewMenu_3.add(mntmNewMenuItem_13);
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_4 = new JMenu("Informes");
		mnNewMenu_4.setBackground(new Color(189, 183, 107));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Generar informe diario de caja");
		mntmNewMenuItem_9.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				informeDiarioDeCaja ventana = new informeDiarioDeCaja();
				ventana.setVisible(true);
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Generar informe prod stock min");
		mntmNewMenuItem_10.setBackground(new Color(189, 183, 107));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeProdStockMin ventana = new InformeProdStockMin();
				ventana.setVisible(true);
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel imagen = new JLabel("");
		ImageIcon ImageIcon = new ImageIcon(new ImageIcon("foto\\supermercado.png").getImage().getScaledInstance(411,171,Image.SCALE_DEFAULT));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		imagen.setIcon(ImageIcon);
		contentPane.add(imagen);
		
		
		
		
	}

}
