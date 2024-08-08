package cybert.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegisterWindow extends JFrame{
	
	private static final int MAX_WIDTH= 450;
	private static final int MAX_HEIGTH = 600;
	private static final String INFORMACION = "Los campos marcados con un * son obligatorios";
	

	private MainWindow mainPanel;
	
	private JPanel panel;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField fechaNac;
	private JTextField nombreUsuario;
	private JLabel textoInformativo;
	private JButton registrar;
	private JButton leftArrow;
	
	private static String name;
	private static String secondName;
	private static String birthday;
	private static String userName;
	
	public RegisterWindow() {
		initGUI();
	}
	
	private void initGUI() {
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
		setVisible(true);
	}
	
	private void campos() {
		JPanel centerPanel = new JPanel();
		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        centerPanel.setBackground(Color.LIGHT_GRAY);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 20, 60));
        
        centerPanel.add(nombre());
        centerPanel.add(apellido());
        centerPanel.add(fechaNacimiento());
        centerPanel.add(nombreUsuario());
        centerPanel.add(botonRegistrar());
        
        generalPanel.add(centerPanel, BorderLayout.CENTER);
        generalPanel.add(mensajeInformativo(), BorderLayout.SOUTH);
        
        panel.add(generalPanel, BorderLayout.CENTER);
	}
	private JPanel nombre() {
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel nombrePanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nombreLabel = new JLabel("Nombre*");
		nombreLabel.setFont(new Font("Arial", Font.BOLD, 14));
		nombreLabel.setForeground(Color.BLACK);
		nombrePanel1.add(nombreLabel);
		
		JPanel nombrePanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nombre = new JTextField("Nombre");
		nombre.setFont(new Font("Arial", Font.ITALIC, 14)); // Tamaño de fuente personalizado
		nombre.setPreferredSize(new Dimension(300, 30));
		
		nombre.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String newText = nombre.getText();
				if(!nombre.equals(newText))
					name = nombre.getText();
			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String newText = nombre.getText();
				if(!nombre.equals(newText))
					name = nombre.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String newText = nombre.getText();
				if(!nombre.equals(newText))
					name = nombre.getText();
			}
			
		 });
		nombrePanel2.add(nombre);
		
		panel.add(nombrePanel1, BorderLayout.NORTH);
		panel.add(nombrePanel2, BorderLayout.CENTER);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return panel;
	}
	private JPanel apellido() {
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel apellidoPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel apellidoLabel = new JLabel("Apellido*");
		apellidoLabel.setFont(new Font("Arial", Font.BOLD, 14));
		apellidoLabel.setForeground(Color.BLACK);
		apellidoPanel1.add(apellidoLabel);
		
		JPanel apellidoPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		apellido = new JTextField("Apellido");
		apellido.setFont(new Font("Arial", Font.ITALIC, 14)); // Tamaño de fuente personalizado
		apellido.setPreferredSize(new Dimension(300, 30));
		
		apellido.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String newText = apellido.getText();
				if(!apellido.equals(newText))
					secondName = apellido.getText();
			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String newText = apellido.getText();
				if(!apellido.equals(newText))
					secondName = apellido.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String newText = apellido.getText();
				if(!apellido.equals(newText))
					secondName = apellido.getText();
			}
			
		 });
		apellidoPanel2.add(apellido);
		
		panel.add(apellidoPanel1, BorderLayout.NORTH);
		panel.add(apellidoPanel2, BorderLayout.CENTER);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return panel;
	}
	private JPanel fechaNacimiento() {
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel fechaNacPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel fechaNacLabel = new JLabel("Fecha de nacimiento*");
		fechaNacLabel.setFont(new Font("Arial", Font.BOLD, 14));
		fechaNacLabel.setForeground(Color.BLACK);
		fechaNacPanel1.add(fechaNacLabel);
		
		JPanel fechaNacPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		fechaNac = new JTextField("Fecha de nacimiento");
		fechaNac.setFont(new Font("Arial", Font.ITALIC, 14)); // Tamaño de fuente personalizado
		fechaNac.setPreferredSize(new Dimension(300, 30));
		
		fechaNac.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String newText = fechaNac.getText();
				if(!fechaNac.equals(newText))
					birthday = fechaNac.getText();
			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String newText = fechaNac.getText();
				if(!fechaNac.equals(newText))
					birthday = fechaNac.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String newText = fechaNac.getText();
				if(!fechaNac.equals(newText))
					birthday = fechaNac.getText();
			}
			
		 });
		fechaNacPanel2.add(fechaNac);
		
		panel.add(fechaNacPanel1, BorderLayout.NORTH);
		panel.add(fechaNacPanel2, BorderLayout.CENTER);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return panel;
	}
	private JPanel nombreUsuario() {
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel userNamePanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel userNameLabel = new JLabel("Nombre de Usuario*");
		userNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		userNameLabel.setForeground(Color.BLACK);
		userNamePanel1.add(userNameLabel);
		
		JPanel userNamePanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nombreUsuario = new JTextField("Fecha de nacimiento");
		nombreUsuario.setFont(new Font("Arial", Font.ITALIC, 14)); // Tamaño de fuente personalizado
		nombreUsuario.setPreferredSize(new Dimension(300, 30));
		
		nombreUsuario.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String newText = nombreUsuario.getText();
				if(!nombreUsuario.equals(newText))
					userName = nombreUsuario.getText();
			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String newText = nombreUsuario.getText();
				if(!nombreUsuario.equals(newText))
					userName = nombreUsuario.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String newText = nombreUsuario.getText();
				if(!nombreUsuario.equals(newText))
					userName = nombreUsuario.getText();
			}
			
		 });
		userNamePanel2.add(nombreUsuario);
		
		panel.add(userNamePanel1, BorderLayout.NORTH);
		panel.add(userNamePanel2, BorderLayout.CENTER);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		return panel;
	}
	private JButton botonRegistrar() {
		registrar = new JButton("Regístrate");
		registrar.setFont(new Font("Arial", Font.BOLD, 30));
		registrar.setForeground(Color.WHITE);
		registrar.setBackground(Color.DARK_GRAY);
		registrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalStrut(60));
		
		registrar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if(name == null || secondName == null || birthday == null || userName == null
					|| name.equals("") || secondName.equals("") || birthday.equals("") || userName.equals("")){
						Controlador.getInstancia().accion(Eventos.CAMPOS_VACIOS, null);
					}
					else {
						Object[] usuario = {name, secondName, birthday, userName};
						Controlador.getInstancia().accion(Eventos.REGISTRAR_USUARIO, usuario);
					}
				 
				 dispose();
				 Controlador.getInstancia().accion(Eventos.PAGINA_PRINCIPAL, null);
			 };
		 });
		
		return registrar;
	}
	private JPanel mensajeInformativo() {
		JPanel text = new JPanel();
        text.setLayout(new FlowLayout(FlowLayout.LEFT));
        text.setBackground(Color.LIGHT_GRAY);
        text.setBorder(BorderFactory.createEmptyBorder(0, 20, 20,0));
        textoInformativo = new JLabel(INFORMACION);
        textoInformativo.setFont(new Font("Arial", Font.ITALIC, 10));
        textoInformativo.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        //text.addMouseListener(e-> );
        text.add(textoInformativo);
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
		 
		 panel.add(top, BorderLayout.NORTH);
	}
}
