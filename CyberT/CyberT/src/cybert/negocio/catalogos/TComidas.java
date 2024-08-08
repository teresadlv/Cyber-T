package cybert.negocio.catalogos;

public class TComidas extends TCatalogos{

	private int _price;

	public TComidas(int id, String name, int price, Boolean active) {
		super (id, name, active);
		this._price = price;
	}

	// GETS
	public int get_price() {
		return _price;
	}

	// SETS
	public void set_price(int _price) {
		this._price = _price;
	}

}
