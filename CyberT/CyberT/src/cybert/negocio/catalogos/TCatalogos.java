package cybert.negocio.catalogos;

public class TCatalogos {

	private int _id;
	private String _name;
	private Boolean _active;
	
	public TCatalogos(int id, String name, Boolean active) {
		this._id = id;
		this._name = name;
		this._active = active;
	}
	
	// GETS
	public int get_id() {
		return _id;
	}

	public String get_name() {
		return _name;
	}

	public Boolean get_active() {
		return _active;
	}

	// SETS
	public void set_id(int _id) {
		this._id = _id;
	}

	public void set_name(String _name) {
		this._name = _name;
	}
	
	public void set_active(Boolean _active) {
		this._active = _active;
	}

}
