package cybert.integracion;

public abstract class FactoriaDAO {
	private static FactoriaDAO instancia = null;
	static public FactoriaDAO getInstancia() {
		if(instancia == null) instancia = new FactoriaDAOImp();
		return instancia;
	}
	
	public abstract DAOUsuario nuevoDAOUsuario();
}
