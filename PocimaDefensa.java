package pokeprebe;

public class PocimaDefensa extends Pocima {
	
	bonificacion = 0.15;

	public float usar(Monstruo monstruo) {
		float aumento = monstruo.defensa * bonificacion;
		monstruo.recibirDefensa(aumento);
	}
}