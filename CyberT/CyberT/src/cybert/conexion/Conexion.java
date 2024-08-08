package cybert.conexion;

import java.sql.Connection;

public abstract class Conexion {
	private static Conexion instancia = null;
	
	static public Conexion getInstancia() {
		if(instancia == null) instancia = new BDConexion();
		return instancia;
	}
	
	public abstract Connection getConnection();
	public abstract void desconectar();
	
	
}
