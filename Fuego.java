package pokeprebe;

/**
 * @author Ator97
 */
public abstract class Fuego extends Monstruo{
    
    float multiplicador;
    public Fuego(int nivel, String apodo) {
        super(nivel, apodo);
    }
    public Fuego(int nivel) {
        super(nivel);
    }
    
    /**
     * @param m
     * @return
     */
    @Override
    public float multiplicadorElemental(Hierba m) {
		return (float)2.0f; 
	}
	public float multiplicadorElemental(Fuego m ){
		return (float) 0.5; 
	}
	public float multiplicadorElemental(Agua m){
		return  (float) 0.5; 
	}	
	public float multiplicadorElemental(Electrico m){
	 	return  (float) 1.0;     
    }

    /**
     *
     * @param multiplicador
     * @param m
     * @return
     */
    @Override
    public String ataque1(float multiplicador, MonstruoEspecifico m) {
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
