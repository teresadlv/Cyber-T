package cybert.view;

import javax.swing.JFrame;

public abstract class MainWindowInstance extends JFrame{
	private static MainWindowInstance instancia = null;
	
	public static MainWindowInstance getInstancia() {
		if(instancia == null) instancia = new MainWindow();
		return instancia;
	}
	
	public abstract void actualizar(int evento, Object datos);
}
