package cybert.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LogInWindow extends JFrame {
	
	private static final int MAX_WIDTH= 450;
	private static final int MAX_HEIGTH = 600;
	private static final String CONTRASENIA = "Contraseña";
	private static final String NOMBRE_USUARIO= "usuario@correo.com";
	
	private static final String INFORMACION = "¿Aún no eres miembro?";
	 
	private JFrame marco;
	private JPanel panel;
	private static String _user;
	private static char[] _password;
	private JTextField  userArea;
	private JPasswordField userPassword;
	private JLabel textoInformativo;
	private JButton login;
	private JButton leftArrow;
	
	LogInWindow(){
		marco = new JFrame("Login");
		initGIU();
	}
	
	private void initGIU() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGTH));
		panel.setBackground(Color.LIGHT_GRAY);
		
		leftArrow();
		campos();
		
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);//para que aparezca en el centro
		setVisible(false);
	}
	
	
	
	private JButton loginButton() {
		login = new JButton("Login");
		login.setFont(new Font("Arial", Font.BOLD, 20));
		login.setForeground(Color.WHITE);
		login.setBackground(Color.DARK_GRAY);
		login.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco.setVisible(false);
				//Si los campos están vacios, lanzamos JDialog
				if(_user == null || _password == null || _user.equals("") || _password.equals("")){
					Controlador.getInstancia().accion(Eventos.CAMPOS_VACIOS, null);
				}
				else {
					Object[] usuario = {_user, _password};
					Controlador.getInstancia().accion(Eventos.LOGEAR_USUARIO, usuario);
				}
			}
		});
		
		panel.add(Box.createVerticalStrut(60));
		
		return login;
	}
	private void campos() {
		JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 20, 60));
        
	    //Usuario
        JPanel panelUsuario = create_usuario_fields();
        centerPanel.add(panelUsuario);
        //------------------------
        
        //Boton d elogin
        JButton loginButton = loginButton();
        centerPanel.add(loginButton);

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(create_informativeLabel(), BorderLayout.SOUTH);
	}
	private JPanel create_informativeLabel() {
		 	JPanel text = new JPanel();
		 	text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
	        text.setBackground(Color.LIGHT_GRAY);
	        text.setBorder(BorderFactory.createEmptyBorder(0, 0, 40,0));
	        
	        JLabel infoLabel = new JLabel(INFORMACION);
	        infoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
	        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	        text.add(infoLabel);
	        
	        JLabel registerLabel = new JLabel("Regístrate");
	        registerLabel.setFont(new Font("Arial", Font.BOLD, 18));
	        registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	        registerLabel.setForeground(Color.BLUE);
	        registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        registerLabel.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	dispose(); 
	        		Controlador.getInstancia().accion(Eventos.REGISTER_USUARIO, null);
	            }
            });
	        	
	        text.add(registerLabel);
	        
	        JPanel texto = new JPanel();
	        texto.setBackground(Color.LIGHT_GRAY);
	        return text;
	}
	private void leftArrow() {
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		top.setBackground(Color.LIGHT_GRAY);
		leftArrow = new JButton();
		leftArrow.setIcon(new ImageIcon("C:\\Users\\PC\\eclipse-workspace\\CyberT\\icon\\flecha.png"));
		leftArrow.setPreferredSize(new Dimension(30, 30));
		leftArrow.setBackground(Color.LIGHT_GRAY);
		 
		leftArrow.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 	dispose();
				 	Controlador.getInstancia().accion(Eventos.PAGINA_PRINCIPAL, null);
			 };
		 });
		 
		top.add(leftArrow);
		JPanel conjunto = new JPanel();
		conjunto.setLayout(new BorderLayout());
		conjunto.setBackground(Color.LIGHT_GRAY);
		conjunto.add(top,BorderLayout.PAGE_START);
		conjunto.add(new IconPlusWelcome(), BorderLayout.CENTER);
		 
		panel.add(conjunto, BorderLayout.NORTH);
	}
	private JPanel create_usuario_fields() {
		 JPanel panelUsuario = new JPanel();
	        panelUsuario.setLayout(new GridLayout(0, 1, 10, 1));
	        panelUsuario.setBackground(Color.LIGHT_GRAY);
	        panelUsuario.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

		    JLabel email =new JLabel("Email");
		    email.setFont(new Font("Arial", Font.BOLD, 14));
		    email.setForeground(Color.BLACK);
		    panelUsuario.add(email);
			userArea = userField();
			panelUsuario.add(userArea);

	        // Campo de contraseña
	        JLabel password =new JLabel("Password");
	        password.setFont(new Font("Arial", Font.BOLD, 14));
	        password.setForeground(Color.BLACK);
	        panelUsuario.add(password);
	        userPassword = passwordField();
	        panelUsuario.add(userPassword);
	        
	       return panelUsuario;
	}
	
	private JTextField  userField() {
		JTextField  userArea = new JTextField(NOMBRE_USUARIO,15);
		userArea.setFont(new Font("Arial", Font.ITALIC, 14)); // Tamaño de fuente personalizado
		userArea.setPreferredSize(new Dimension(300, 30));
	      
		userArea.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					String newText = userArea.getText();
                    if (_user == null || (_user!= null && !_user.equals(newText))) {
                        _user = newText;
                    }
				}
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					String newText = userArea.getText();
                    if (_user == null || (_user!= null && !_user.equals(newText))) {
                        _user = newText;
                    }
				}
	
				@Override
				public void changedUpdate(DocumentEvent e) {
					String newText = userArea.getText();
                    if (!_user.equals(newText)) {
                        _user = newText;
                    }
				}
				
			 });
			
		return userArea;
	}
	
	private JPasswordField passwordField() {
		JPasswordField userPassword = new JPasswordField(CONTRASENIA, 20);
		userPassword.setFont(new Font("Arial", Font.PLAIN, 14)); // Tamaño de fuente personalizado
		userPassword.setPreferredSize(new Dimension(300, 30));
        
		userPassword.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				char[] newText = userPassword.getPassword();
				if(!_password.equals(newText))
					_password = userPassword.getPassword();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				char[] newText = userPassword.getPassword();
				if(_password == null || (_password!= null && !_password.equals(newText)))
					_password = userPassword.getPassword();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				char[] newText = userPassword.getPassword();
				if(!_password.equals(newText))
					_password = userPassword.getPassword();
			}
			
		});
		
		return userPassword;
	}
}

