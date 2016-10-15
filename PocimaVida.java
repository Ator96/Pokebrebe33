package pokeprebe;

/**
* @author David Yaxkin Sánchez Neri
* Clase que define los metodos de una pocima de vida
*/
public class PocimaVida extends Pocima {
	
	public PocimaVida() {
		bonificacion = 0.2f;
	}

	public float usar(Monstruo monstruo) {
		float aumento = monstruo.hp * bonificacion;
		monstruo.recibirHp(aumento);
		return aumento;
	}
	
	/**
	*Formato personalizado
	*/
	public String toString(){
		return "Pocima de vida";
	}
}