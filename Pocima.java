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
        * @return Cantidad que la pocima aumentara el atributo del monstruo
	*/
	public abstract float usar(Monstruo monstruo);
}