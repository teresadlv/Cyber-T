package cybert.integracion.catalogos;

import java.sql.Statement;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cybert.conexion.Conexion;
import cybert.negocio.TUsuario;


public class CatalogoVideojuegos extends DAOCatalogoImp{

	
	private static final String NOMBRE_CATALOGO_VIDEOJUEGOS = "Catalogo de videojuegos";
	
	
	@Override
	public void mostrarCatalogo() {
		Connection con = null;
		Statement stmt = null;
		ResultSet catalogQueryResult;
		List<>
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = Conexion.getInstancia().getConnection();
			
			
			
			String catalogQuery = "SELECT FROM videojuegos WHERE CatalogoRaiz = ?";
			PreparedStatement obtainCatalogStatement = con.prepareStatement(catalogQuery);
			obtainCatalogStatement.setString(1, NOMBRE_CATALOGO_VIDEOJUEGOS);
			
			if (obtainCatalogStatement.execute()) {
				catalogQueryResult = obtainCatalogStatement.executeQuery();
				catalogQueryResult.getInt(1, )
			}
			
			
			
			
			//Si el usuario intenta inserta un user o @ que ya existe:
			String username = tu.getNombreUsuario(); 
            String email = tu.getEmail();
            if (usuarioExiste(con, username, email)) {
                throw new Exception("El nombre de usuario o correo electr�nico ya est� en uso.");
            }
            
            //Si no existe, creo el usuario y lo inserto!
            String insertQuery = "INSERT INTO cuentas (ID, email, passwd, username,nombre,apellido, fNac) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement insertStatement = con.prepareStatement(insertQuery);
            insertStatement.setInt(1, tu.getId());
            insertStatement.setString(2, tu.getEmail());
            insertStatement.setString(3, tu.getPassword());
            insertStatement.setString(4, tu.getNombreUsuario());
            insertStatement.setString(5, tu.getNombre());
            insertStatement.setString(6, tu.getApellido());
            insertStatement.setDate(7, (java.sql.Date) new Date(tu.getFecha().getTime()));
			
            insertStatement.executeUpdate();
            
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}
		catch(Exception ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		
	}

}
