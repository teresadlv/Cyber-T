package cybert.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cybert.negocio.FactoriaSA;
import cybert.negocio.SAUsuario;
import cybert.negocio.TUsuario;

public class ControladorImp extends Controlador{
	
	private SAUsuario saUsuario;
	
	public ControladorImp() {
		saUsuario = FactoriaSA.getInstancia().nuevoSAUsuario();
	}
	
	public void accion(int evento, Object datos) {
		switch(evento) {
			case Eventos.PAGINA_PRINCIPAL:
				MainWindow mainWindow = new MainWindow();
			break;	
			
			case Eventos.LOGIN_USUARIO:{
				LogInWindow loginWindow = new LogInWindow();
			break;
			}
			
			case Eventos.REGISTER_USUARIO:
				RegisterWindow registerWindow = new RegisterWindow();
			break;
			
			case Eventos.LOGEAR_USUARIO:
				Object[] datosArrayLogin = (Object[]) datos;
				
			    String nombreUsuarioLogin = (String) datosArrayLogin[0];
			    char[] contraseniaLogin = (char[]) datosArrayLogin[1];
			    
			    TUsuario usuarioLogin = new TUsuario();
			    usuarioLogin.setNombreUsuario(nombreUsuarioLogin);
			    usuarioLogin.setPassword(new String(contraseniaLogin)); 
			    
				saUsuario.loginUsuario(usuarioLogin);
			break;
			
			case Eventos.REGISTRAR_USUARIO:
				Object[] datosArrayRegistrar = (Object[]) datos;
				TUsuario usuarioRegistrar = new TUsuario();
				
			    String nombreRegistrar = (String) datosArrayRegistrar[0];
			    String apellidoRegistrar = (String) datosArrayRegistrar[1];
			    
			    String fechaRegistrar = (String) datosArrayRegistrar[2];
			    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			    try {
			    	Date fecha = formatoFecha.parse(fechaRegistrar);
			    	usuarioRegistrar.setFecha(fecha); 
			    }
			    catch(ParseException e) {
			    	System.err.println("Error al analizar la fecha: " + e.getMessage());
			    }
			    
			    
			    String nombreUsuarioRegistrar = (String) datosArrayRegistrar[3];
			    
			    usuarioRegistrar.setNombre(nombreRegistrar);
			    usuarioRegistrar.setApellido(apellidoRegistrar);
			    usuarioRegistrar.setNombreUsuario(nombreUsuarioRegistrar);
			    
			   //Queda el password y el email, preguntar alonso
				saUsuario.altaUsuario(usuarioRegistrar);
			break;
			
			case Eventos.MENUS:
				MenusWindow menusWindow = new MenusWindow();
			break;
			
			case Eventos.CAMPOS_VACIOS:
				ExcepcionCamposVaciosImp excepcionCamposVacios = new ExcepcionCamposVaciosImp();
			break;
			
			case Eventos.USUARIO_INCORRECTO:
				ExcepcionUsuarioIncorrectoImp excepcionUsuarioIncorrecto = new ExcepcionUsuarioIncorrectoImp();
			break;
			
			case Eventos.CONTRANYA_USUARIO_NO_CORRESPONDEN:
			break;
		}
	}
}
