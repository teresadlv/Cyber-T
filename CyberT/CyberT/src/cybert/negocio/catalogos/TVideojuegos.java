package cybert.negocio.catalogos;

public class TVideojuegos extends TCatalogos{

	private String _genre;
	private String _description;
	
	public TVideojuegos(int id, String nombre, String tipoJuego, String descripcion, Boolean activo) {
		super (id, nombre, activo);
		this._genre = tipoJuego;
		this._description = descripcion;
	}
	
	//GETS
	public String getTypeGame() {
		return this._genre;
	}
	public String getDescription() {
		return this._description;
	}
	
	//SETS
	public void setTypeGame(String typeGame) {
		this._genre = typeGame;
	}
	public void setDescripcion(String desc) {
		this._description = desc;
	}
	

}
