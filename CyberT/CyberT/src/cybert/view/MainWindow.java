package cybert.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainWindow extends JFrame{

	 private JButton loginButton;
	 private JButton registerButton;
	 private JPanel mainPanel;
	
	public MainWindow() {
		initGUI();
	}
	
	private void initGUI() {
		createMainPanel();
	    add(mainPanel);
		
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);//para que aparezca en el centro
		setVisible(true);
	}
	
	private void createMainPanel() {
		//Crea el panel con las dimension, color y tipo de layout
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(450, 600));
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));//Organiza los componentes de forma vertical

        //Añade la foto y el texto desde la clase que he creado
        mainPanel.add(new IconPlusWelcome());

        //Botones de login y register
        loginButton = createButton("Login", 25);
        //Anyadir listener del boton
        loginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		Controlador.getInstancia().accion(Eventos.LOGIN_USUARIO, null);;
        	}
        });
        //-------------------
        mainPanel.add(Box.createVerticalStrut(60));
        mainPanel.add(loginButton);

        registerButton = createButton("Register", 20);
        registerButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose(); 
        		Controlador.getInstancia().accion(Eventos.REGISTER_USUARIO, null);
        	}
        });
        mainPanel.add(Box.createVerticalStrut(60));
        mainPanel.add(registerButton);
    }
	
	private JButton createButton(String text, int fontSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

	@Override
	public void actualizar(int evento, Object datos) {
		if(evento == Eventos.LOGIN_USUARIO) {
			JOptionPane.showMessageDialog(this, "Hey you");
		}
	}

	
}
