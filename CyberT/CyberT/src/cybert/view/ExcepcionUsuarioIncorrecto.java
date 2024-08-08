package cybert.view;

import javax.swing.JDialog;

public abstract class ExcepcionUsuarioIncorrecto extends JDialog{
	private static ExcepcionUsuarioIncorrecto instancia = null;
		
	public static ExcepcionUsuarioIncorrecto getIInstancia() {
		if(instancia == null) instancia = new ExcepcionUsuarioIncorrectoImp();
		return instancia;
	}
}
