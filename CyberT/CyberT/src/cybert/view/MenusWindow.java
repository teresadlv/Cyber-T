package cybert.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class MenusWindow extends JFrame{
	
	private static final int MAX_WIDTH= 800;
	private static final int MAX_HEIGTH = 600;
	private static final int BUTTOM_WIDTH = 150;
	private static final int BUTTOM_HEIGTH = 20;
	private static final String BIENVENIDA = "¡Bienvenid@,[USER]!";
	
	private JPanel panel;
	private JLabel cyberTLabel;
	private JLabel labelImagen;
	
	
	//Opciones
	JPanel panelOpciones;
	//Reservas
	private JButton hacerReserva;
	private JButton reservasActivas;
	private JButton reservasHistoricas;
	
	//Comida
	private JButton comida;
	private JButton videojuegos;
	
	//Opcioens usuario
	JPanel panelUsuario;
	
	private JButton miPerfil;
	private JButton sugerencias;
	private JButton cerrarSesion;
	
	public MenusWindow() {
		initGUI();
	}
	
	private void initGUI() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,3, 10,10));
		panel.setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGTH));
		panel.setBackground(Color.LIGHT_GRAY);
		
		panel.add(image());
		
		JPanel centro = new JPanel();
	    centro.setLayout(new BorderLayout()); // Usar FlowLayout para centrar los componentes
	    centro.setBackground(Color.LIGHT_GRAY);
	    centro.setBorder(BorderFactory.createEmptyBorder(230 ,50,115,0));
	    opcionesMenu();
	    centro.add(panelOpciones, BorderLayout.CENTER);
	    panel.add(centro);
	    
	    JPanel arriba = new JPanel();
	    arriba.setLayout(new GridLayout(3,1, 10,10)); // Usar FlowLayout para centrar los componentes
	    arriba.setBackground(Color.LIGHT_GRAY);
	    arriba.setBorder(BorderFactory.createEmptyBorder(0,50,0,0));
	    opcionesUsuario();
	    arriba.add(panelUsuario);
	    panel.add(arriba);
	    
	  
	    add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);//para que aparezca en el centro
		setVisible(true);
		
	}
	
	private void opcionesMenu() {
		panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
		panelOpciones.setBackground(Color.LIGHT_GRAY);
		
		customButton(hacerReserva, "Hacer reserva",15, new Dimension(BUTTOM_WIDTH, BUTTOM_HEIGTH + 5));
		panelOpciones.add(Box.createVerticalStrut(15));
		
		customButton(reservasActivas, "<html>Reservas<br><div style='text-align:center;'>activas</div></html>",15,new Dimension(BUTTOM_WIDTH, BUTTOM_HEIGTH + 15));
		panelOpciones.add(Box.createVerticalStrut(15));
		customButton(reservasHistoricas, "<html>Reservas<br><div style='text-align:center;'>historicas</div></html>", 15, new Dimension(BUTTOM_WIDTH, BUTTOM_HEIGTH + 15));
		panelOpciones.add(Box.createVerticalStrut(15));
		
		panelOpciones.add(Box.createVerticalStrut(40));
		
		customButton(comida, "<html>Catalogo de<br><div style='text-align:center;'>comida</div></html>",15, new Dimension(BUTTOM_WIDTH,BUTTOM_HEIGTH+ 15));
		panelOpciones.add(Box.createVerticalStrut(15));
		customButton(videojuegos, "<html>Catalogo de<br><div style='text-align:center;'>videojuegos</div></html>", 13, new Dimension(BUTTOM_WIDTH, BUTTOM_HEIGTH+ 15));
	}
	
	private void opcionesUsuario() {
		panelUsuario = new JPanel();
		panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
		panelUsuario.setBackground(Color.LIGHT_GRAY);
		
		customButton(miPerfil, "Mi perfil",15, new Dimension(BUTTOM_WIDTH, BUTTOM_HEIGTH + 5));
		panelUsuario.add(Box.createVerticalStrut(15));
		
		customButton(sugerencias, "Sugerencias",15,new Dimension(BUTTOM_WIDTH, BUTTOM_HEIGTH + 5));
		panelUsuario.add(Box.createVerticalStrut(15));
		customButton(cerrarSesion, "Cerrar Sesion", 15, new Dimension(BUTTOM_WIDTH, BUTTOM_HEIGTH + 5));
		panelUsuario.add(Box.createVerticalStrut(15));

	}
	private void customButton(JButton buton, String text, int tamanyo, Dimension dim) {
		buton = new JButton(text);
		buton.setBackground(Color.GRAY);
		buton.setPreferredSize(dim);
		buton.setMinimumSize(dim);
		buton.setMaximumSize(dim);
		buton.setFont(new Font("Arial", Font.BOLD, tamanyo));
		
		panelOpciones.add(buton);
	}
	private JPanel image() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1,10,10));
		panel.setBackground(Color.LIGHT_GRAY);
		
		JPanel izquierda = new JPanel(new BorderLayout());
		izquierda.setPreferredSize(new Dimension(125,125));
		izquierda.setBackground(Color.LIGHT_GRAY);
		izquierda.setBorder(BorderFactory.createEmptyBorder(15, 15, 0,0));
		icono();
		cyberText();
		izquierda.add(labelImagen, BorderLayout.NORTH);
		 
		JPanel textoPanel = new JPanel(new BorderLayout());
		textoPanel.setBackground(Color.LIGHT_GRAY);
		textoPanel.setPreferredSize(new Dimension(50, 20));
		textoPanel.setMaximumSize(new Dimension(50, 20));
		textoPanel.setMinimumSize(new Dimension(50, 20));
		textoPanel.setBorder(BorderFactory.createEmptyBorder(7, 25, 7, 25));
		    
		cyberTLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textoPanel.add(cyberTLabel, BorderLayout.CENTER);
		 
		izquierda.add(textoPanel, BorderLayout.CENTER);
		panel.add(izquierda);
		
		
		return panel;
	}
	
	private void icono() {
		ImageIcon icono = new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\CyberT\\icon\\cybertIcon.jpg");
	    Image imagen = icono.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT); // Ajustar tamaño aquí
	    labelImagen = new JLabel(new ImageIcon(imagen));
	    labelImagen.setAlignmentX(Component.CENTER_ALIGNMENT); 
	
	}
	private void cyberText() {
        cyberTLabel = new JLabel("Cyber<T>");
        cyberTLabel.setBackground(Color.DARK_GRAY);
        cyberTLabel.setFont(new Font("Arial", Font.BOLD, 12));;
        cyberTLabel.setOpaque(true);
        cyberTLabel.setForeground(Color.WHITE);
        cyberTLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cyberTLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Espacio alrededor del texto
        
        cyberTLabel.setHorizontalAlignment(SwingConstants.CENTER);
	       
	 }
	
	private void bienvenida() {
        cyberTLabel = new JLabel(BIENVENIDA);
        cyberTLabel.setBackground(Color.DARK_GRAY);
        cyberTLabel.setFont(new Font("Arial", Font.BOLD, 12));;
        cyberTLabel.setOpaque(true);
        cyberTLabel.setForeground(Color.WHITE);
        cyberTLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cyberTLabel.setPreferredSize(new Dimension(125, 20)); // Ancho igual al de la imagen y altura menor
        cyberTLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Espacio alrededor del texto
        
        cyberTLabel.setHorizontalAlignment(SwingConstants.CENTER);
       
 }
}
