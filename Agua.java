package pokeprebe;

/**
 * @author Oscar Gutiérrez Castillo
 */
public abstract class Agua extends Monstruo {

    float multiplicador;

    public Agua(int nivel, String apodo) {
        super(nivel, apodo);
    }

    /**
     * @param nivel
     */
    public Agua(int nivel) {
        super(nivel);
    }

    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */
    @Override
    public float multiplicadorElemental(Agua m) {
		return multiplicador = 0.5f; 
	}
    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */
	public float multiplicadorElemental(Fuego m){
		return multiplicador = (float) 2.0; 
	}
    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */
	public float multiplicadorElemental(Hierba m ){
		return multiplicador = (float) 0.5; 
	}
    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */		
	public float multiplicadorElemental(Electrico m ){
		return multiplicador = (float) 1.0; 

    }    
    /**
     * @param m 
     * @return
     */
    @Override
    public float ataque1(Agua m){
    	multiplicador = multiplicadorElemental(m);
	float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
	if (danio <= 0){
		return "parece que no ha habido daño alguno";
	}
	m.recibirDanio(danio);    
        return null;
    }
    /**
     * @param m 
     * @return
     */
    @Override
    public float ataque1(Fuego m){
    	multiplicador = multiplicadorElemental(m);
	float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
	if (danio <= 0){
		return "parece que no ha habido daño alguno";
	}
	m.recibirDanio(danio);    
        return null;
    }
    /**
     * @param m 
     * @return
     */
    @Override
    public float ataque1(Hierba m){
    	multiplicador = multiplicadorElemental(m);
	float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
	if (danio <= 0){
		return "parece que no ha habido daño alguno";
	}
	m.recibirDanio(danio);    
        return null;
    }
    /**
     * @param m 
     * @return
     */
    @Override
    public float ataque1(Electrico m){
    	multiplicador = multiplicadorElemental(m);
	float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
	if (danio <= 0){
		return "parece que no ha habido daño alguno";
	}
	m.recibirDanio(danio);    
        return null;
    }
    
}
