package cybert.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class MenusWindowInstance extends JFrame{
	public static MenusWindowInstance instancia = null;
	
	public static MenusWindowInstance getInstancia() {
		if(instancia == null) instancia = new MenusWindow();
		return instancia;
	}
}
