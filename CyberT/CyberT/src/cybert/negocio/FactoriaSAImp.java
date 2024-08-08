package cybert.negocio;

public class FactoriaSAImp extends FactoriaSA{

	@Override
	public SAUsuario nuevoSAUsuario() {
		return new SAUsuarioImp();
	}
	
}
