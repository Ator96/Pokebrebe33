package pokeprebe;

/**
* @author David Yaxkin Sánchez Neri
* Clase que define los metodos de una pocima de defensa
*/
public class PocimaDefensa extends Pocima {
	
	public PocimaDefensa() {
		bonificacion = 0.15f;
	}

	public float usar(Monstruo monstruo) {
		float aumento = monstruo.defensa * bonificacion;
		monstruo.recibirDefensa(aumento);
		return aumento;
	}

	/**
	*Formato personalizado
	*/
	public String toString(){
		return "Pocima de defensa";
	}
}