package pokeprebe;

/**
* @author David Yaxkin Sánchez Neri
* Clase abstracta que define las caracteristicas de una pocima
*/

public abstract class Pocima {
	
	float bonificacion;

	/**
	* Metodo abstracto que hara uso de la pocima
	* @param monstruo Monstruo en el que se va a usar la pocima
	*/
	public abstract float usar(Monstruo monstruo);
}