package cybert.integracion;

public class FactoriaDAOImp extends FactoriaDAO{

	@Override
	public DAOUsuario nuevoDAOUsuario() {
		return new DAOUsuarioImp();
	}

}
