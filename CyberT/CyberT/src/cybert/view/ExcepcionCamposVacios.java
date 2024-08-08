package cybert.view;

import javax.swing.JDialog;

public abstract class ExcepcionCamposVacios extends JDialog{
	public static ExcepcionCamposVacios instancia = null;
	
	public static ExcepcionCamposVacios getInstancia() {
		if(instancia == null) instancia = new ExcepcionCamposVaciosImp();
		return instancia;
	}
	
}
