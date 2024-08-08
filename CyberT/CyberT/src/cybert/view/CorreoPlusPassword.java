package cybert.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CorreoPlusPassword extends JPanel{
	

	private static final String CONTRASENIA = "Contraseña";
	private static final String NOMBRE_USUARIO= "usuario@correo.com";
	
	private static String _user;
	private static char[] _password;
	private JTextArea userArea;
	private JPasswordField userPassword;
	
	public CorreoPlusPassword() {
		initGUI();
	}
	
	private void initGUI() {
		
        
	}
	
	
	private JTextArea userField() {
		JTextArea userArea = new JTextArea(NOMBRE_USUARIO,0,15);
		userArea.setFont(new Font("Arial", Font.ITALIC, 14)); // Tamaño de fuente personalizado
		userArea.setPreferredSize(new Dimension(300, 30));
	      
		userArea.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					_user = userArea.getText();
				}
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					_user = userArea.getText();
				}
	
				@Override
				public void changedUpdate(DocumentEvent e) {
					_user = userArea.getText();
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
				_password = userPassword.getPassword();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				_password = userPassword.getPassword();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				_password = userPassword.getPassword();
			}
			
		});
		
		return userPassword;
	}
}

