package cybert.view;

import javax.swing.JFrame;

public abstract class RegisterWindowInstance extends JFrame{
	public static RegisterWindowInstance instancia = null;
	
	public static RegisterWindowInstance getInstancia() {
		if(instancia == null) instancia = new RegisterWindow();
		return instancia;
	}
}
