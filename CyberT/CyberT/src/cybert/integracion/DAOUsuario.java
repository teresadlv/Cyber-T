package cybert.integracion;

import cybert.negocio.TUsuario;

public interface DAOUsuario {
	public void altaUsuario(TUsuario tu);
	public void bajaUsuario(TUsuario tu);//Delete
	public int modificarUsuario(TUsuario tu);//UPDATE
	public boolean existeUsuario(String username);
	public boolean comprobarDatos(String username, String password);
}
