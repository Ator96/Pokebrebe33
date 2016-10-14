package pokeprebe;

/**
* @author David Yaxkin Sánchez Neri
* Clase que define los metodos de una pocima de vida
*/
public class PocimaVida extends Pocima {
	
	bonificacion = 0.2;

	public float usar(Monstruo monstruo) {
		float aumento = monstruo.hp * bonificacion;
		monstruo.recibirHp(aumento);
	}
}