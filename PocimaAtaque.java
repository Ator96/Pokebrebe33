package pokeprebe;

/**
* @author David Yaxkin Sánchez Neri
* Clase que define los metodos de una pocima de ataque
*/
public class PocimaAtaque extends Pocima {
	
	public PocimaAtaque() {
		bonificacion = 0.1f;
	}
	/**
	*@param monstruo recibe el monstruo al cual va a afectar
	*/
	public float usar(Monstruo monstruo) {
		float aumento = monstruo.ataque * bonificacion;
		monstruo.recibirAtaque(aumento);
		return aumento;
	}
	/**
	*Formato personalizado
	*/
	public String toString(){
		return "Pocima de vida";
	}
}