package cybert.conexion;

import java.sql.*;
public class BDConexion extends Conexion{
/**Parametros de conexion**/
	static String bd = "bd_cybert";
	static String login = "root";
			
	static String password = "ingsoftware";
	static String url = "jdbc:mysql://localhost/"+bd;
	
	Connection connection = null;
	public BDConexion() {
		try {
			connection = DriverManager.getConnection (url,login,password);}//Usar patron singletone
		catch ( SQLException ex) {
			connection = null ;
			ex. printStackTrace ();
			System.out.println (" SQLException : " + ex. getMessage ());System.out.println (" SQLState : " + ex. getSQLState ());System.out.println (" VendorError : " + ex. getErrorCode ());}
	}
	
	@Override
	public Connection getConnection(){
		return connection;
	}
	
	@Override
	public void desconectar(){
		connection = null;
	}
}
