package cybert.view;

import javax.swing.JFrame;

public abstract class LogInWindowInstance extends JFrame{
	public static LogInWindowInstance instancia = null;
	
	public static LogInWindowInstance getInstancia() {
		if(instancia == null) instancia = new LogInWindow();
		return instancia;
	}
	
	
}
