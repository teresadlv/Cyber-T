package cybert.negocio;

public interface SAUsuario {
	public void altaUsuario(TUsuario usuario);
	public void bajaUsuario(TUsuario usuario);
	public void modificarUsuario(TUsuario usuario);
	public void loginUsuario(TUsuario usuario);
	public void logoutUusario(TUsuario usuario);
}
