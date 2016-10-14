package pokeprebe;

/**
 * @author Oscar Gutiérrez
 */
public abstract class Electrico extends Monstruo{
    
    /**
    *@param nivel Para definir los estatus inicailes del monstruo
    *@param apodo En caso de que el usuario asigne un sobrenombre a su monstruo, en caso de que el usuaruo no de un apodo se pone el nombre default del monstruo
    */
    public Electrico(int nivel, String apodo) {
        super(nivel, apodo);
    }

    
    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */
    @Override
    public float multiplicadorElemental(Agua m) {
		return (float)2.0f; 
	}
    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */    
	public float multiplicadorElemental(Hierba m ){
		return (float) 0.5; 
	}
    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */
	public float multiplicadorElemental(Electrico m){
		return  (float) 0.5; 
	}
    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */
	public float multiplicadorElemental(Fuego m){
	 	return  (float) 1.0;     
    }

    /**
     * @param m Se recibe gracias al polimorfismo el tipo de monstruo a atacar, se aplica  un potenciador de daño
     * @return Estado sobre el daño
     */
    @Override
    public float ataque1(Agua m){
    	float multiplicador = multiplicadorElemental(m);
	float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
	if (danio <= 0){
		return "parece que no ha habido daño alguno";
	}
	m.recibirDanio(danio);    
        return null;
    }
    /**
     * @param m Se recibe gracias al polimorfismo el tipo de monstruo a atacar, se aplica  un potenciador de daño
     * @return Estado sobre el daño
     */
    @Override
    public float ataque1(Fuego m){
    	float multiplicador = multiplicadorElemental(m);
	float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
	if (danio <= 0){
		return "parece que no ha habido daño alguno";
	}
	m.recibirDanio(danio);    
        return null;
    }
    /**
     * @param m Se recibe gracias al polimorfismo el tipo de monstruo a atacar, se aplica  un potenciador de daño
     * @return Estado sobre el daño
     */
    @Override
    public float ataque1(Hierba m){
    	float multiplicador = multiplicadorElemental(m);
	float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
	if (danio <= 0){
		return "parece que no ha habido daño alguno";
	}
	m.recibirDanio(danio);    
        return null;
    }
    /**
     * @param m Se recibe gracias al polimorfismo el tipo de monstruo a atacar, se aplica  un potenciador de daño
     * @return Estado sobre el daño
     */
    @Override
    public float ataque1(Electrico m){
    	float multiplicador = multiplicadorElemental(m);
	float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
	if (danio <= 0){
		return "parece que no ha habido daño alguno";
	}
	m.recibirDanio(danio);    
        return null;
    }
