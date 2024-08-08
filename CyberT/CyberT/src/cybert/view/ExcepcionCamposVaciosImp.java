package cybert.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExcepcionCamposVaciosImp extends JDialog{
	
	private JPanel panel;
	private JLabel textoInformativo;
	private JLabel icono;
	
	public ExcepcionCamposVaciosImp() {
		initGUI();
	}
	
	private void initGUI() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300,150));
		setBackground(Color.LIGHT_GRAY);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		create_icono();
		create_text();
		
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Para cerrar con la cruz
		setResizable(false); 
		pack();
		setLocationRelativeTo(null);//para que aparezca en el centro
		setVisible(true);
	}
	
	private void create_text() {
		textoInformativo = new JLabel("<html><div style='text-align: center;'>Uups! Los campos están vacíos,<br>debes completarlos para iniciar sesión</div></html>");
		textoInformativo.setFont(new Font("Arial", Font.BOLD, 15));
		textoInformativo.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
		panel.add(textoInformativo);
	}
	
	private void create_icono() {
		ImageIcon iconoError = new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\CyberT\\icon\\errorIcon.png");
		Image imagen = iconoError.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagen);
		
		icono = new JLabel(iconoRedimensionado);
		 icono.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(icono);
	}

}
