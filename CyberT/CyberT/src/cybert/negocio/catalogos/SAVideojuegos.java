package cybert.negocio.catalogos;

import java.util.Set;

public interface SAVideojuegos {
	
	public TVideojuegos crearVideojuego(TVideojuegos tVideojuego);
	
	public TVideojuegos modificarVideojuego(TVideojuegos tVideojuego);
	
	public TVideojuegos borrarVideojuego(TVideojuegos tVideojuego);
	
	public TVideojuegos mostrarVideojuego(TVideojuegos tVideojuego);
	
	public Set<TVideojuegos> mostrarVideojuegos();
	
	public Set<TVideojuegos> mostrarVideojuegosPorGenero(String genero);

}
