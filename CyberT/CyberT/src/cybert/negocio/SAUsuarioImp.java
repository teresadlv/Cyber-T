package cybert.negocio;

import cybert.integracion.DAOUsuario;
import cybert.integracion.DAOUsuarioImp;
import cybert.integracion.FactoriaDAO;
import cybert.view.Controlador;
import cybert.view.Eventos;

public class SAUsuarioImp implements SAUsuario{

	private DAOUsuario DAO;
	
	public SAUsuarioImp() {
		DAO =  FactoriaDAO.getInstancia().nuevoDAOUsuario();
	}
	
	@Override
	public void altaUsuario(TUsuario usuario) {
		if(!DAO.existeUsuario(usuario.getNombreUsuario())) {
			DAO.altaUsuario(usuario);
		}	
	}

	@Override
	public void bajaUsuario(TUsuario usuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modificarUsuario(TUsuario usuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void loginUsuario(TUsuario usuario) {
		Controlador.getInstancia().accion(Eventos.MENUS, null);
		
		//Por ahora, dejo las excepciones de lado
		/*
		if(DAO.existeUsuario(usuario.getNombreUsuario())) {
			if(DAO.comprobarDatos(usuario.getNombreUsuario(), usuario.getPassword())) {
				Controlador.getInstancia().accion(Eventos.MENUS, null);
			}
			else {
				Controlador.getInstancia().accion(Eventos.CONTRANYA_USUARIO_NO_CORRESPONDEN, null);
			}
		}
		else {
			Controlador.getInstancia().accion(Eventos.USUARIO_INCORRECTO, null);
		}
		*/
	}
	

	@Override
	public void logoutUusario(TUsuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
