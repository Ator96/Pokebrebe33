package pokeprebe;

/**
* @author David Yaxkin Sánchez Neri
* Clase que define los metodos de una pocima de defensa
*/
public class PocimaDefensa extends Pocima {
	
	bonificacion = 0.15;

	public float usar(Monstruo monstruo) {
		float aumento = monstruo.defensa * bonificacion;
		monstruo.recibirDefensa(aumento);
	}
}