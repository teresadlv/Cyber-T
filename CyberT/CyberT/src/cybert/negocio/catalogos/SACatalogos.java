package cybert.negocio.catalogos;

import java.util.Set;

public interface SACatalogos {
	
	public TCatalogos crearElemento(TCatalogos tVideojuego);
	
	public TCatalogos modificarElemento(TCatalogos tVideojuego);
	
	public TCatalogos borrarElemento(TCatalogos tVideojuego);
	
	public TCatalogos mostrarElemento(TCatalogos tVideojuego);
	
	public Set<TCatalogos> mostrarElementos();
	
	public Set<TCatalogos> mostrarElementosPorGenero(String genero);
	
	public Set<TCatalogos> mostrarElementosPorNombre(String nombre);

}
