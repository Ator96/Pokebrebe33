package pokeprebe;

/**
* @author David Yaxkin Sánchez Neri
* Clase que define los metodos de una pocima de ataque
*/
public class PocimaAtaque extends Pocima {
	
	bonificacion = 0.1;

	public float usar(Monstruo monstruo) {
		float aumento = monstruo.ataque * bonificacion;
		monstruo.recibirAtaque(aumento);
	}
}