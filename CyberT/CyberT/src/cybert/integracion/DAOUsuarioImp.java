package cybert.integracion;

import java.sql.Statement;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cybert.conexion.Conexion;
import cybert.negocio.TUsuario;

public class DAOUsuarioImp implements DAOUsuario{
	
	public void altaUsuario(TUsuario tu) {
		TUsuario tU = null;
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = Conexion.getInstancia().getConnection();
			
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

	@Override
	public void bajaUsuario(TUsuario tu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int modificarUsuario(TUsuario tu) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static boolean usuarioExiste(Connection conn, String username, String email) throws SQLException{
		String query = "SELECT COUNT(*) AS count FROM cuentas WHERE username = ? OR email = ?";
        
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("count");
                    return count > 0;
                }
            }
        }
        return false;
	}

	@Override
	public boolean existeUsuario(String username) {
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
		Connection con = Conexion.getInstancia().getConnection();
		String query = "SELECT * FROM cuentas WHERE username='"+ username+"'";
		
		 stmt = con.prepareStatement(query);
	     rs = stmt.executeQuery();
	     
	     return rs.next();//Devuelve true si el usuario existe
	     //Si no es asi lanza una excepcion
	    }
	    catch(SQLException e) {//Capturamos la excepcion
	    	e.printStackTrace();
	    	return false;
	    }
		
	}
	
	@Override
	public boolean comprobarDatos(String username, String password) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//Consultas
			String query = "SELECT passwd FROM cuentas WHERE username = ?";
			//Creo un objeto y lo asocio a la base de datos para la consulta
			stmt = con.prepareStatement(query);
			
			//Reemplaza username por la primera interrogacion
			stmt.setString(1, username);
			
			rs = stmt.executeQuery();//Ejectuar consulta, me devuelve la informaci�n que se ha preguntado
			
			if(rs.next()) {
				String contrasenya = rs.getString("passwd");
				if(contrasenya.equals(password)) {
					return true;
				}
			}
		}
		catch(Exception e){
			return false;
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
				if(stmt != null) stmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}