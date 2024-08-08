package cybert.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconPlusWelcome extends JPanel {
	
	private static final String BIENVENIDA = "¡Bienvenid@ a Cyber<T>!";
	private JLabel bienvenida;
	IconPlusWelcome(){
		setLayout(new GridLayout(0, 1, 10, 1));
		setPreferredSize(new Dimension(450,230));
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		icono();
        bienvenida();
	}
	
	private void icono() {
		ImageIcon icono = new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\CyberT\\icon\\cybertIcon.jpg");
	    Image imagen = icono.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); // Ajustar tamaño aquí
	    JLabel labelImagen = new JLabel(new ImageIcon(imagen));
	    labelImagen.setAlignmentX(Component.CENTER_ALIGNMENT); 
	    add(Box.createVerticalStrut(30));//Espacio entre el principio de la interfaz
        add(labelImagen);
        add(Box.createVerticalStrut(15));
	}
	private void bienvenida() {
	        bienvenida = new JLabel(BIENVENIDA);
	        bienvenida.setBackground(Color.DARK_GRAY);
	        bienvenida.setFont(new Font("Arial", Font.BOLD, 20));;
	        bienvenida.setOpaque(true);
	        bienvenida.setForeground(Color.WHITE);
	        bienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);
	        bienvenida.setPreferredSize(new Dimension(200,50));
	        
	        add(bienvenida);
	 }

}
