package pokeprebe;

public class PocimaAtaque extends Pocima {
	
	bonificacion = 0.1;

	public float usar(Monstruo monstruo) {
		float aumento = monstruo.ataque * bonificacion;
		monstruo.recibirAtaque(aumento);
	}
}