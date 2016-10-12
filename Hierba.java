package pokeprebe;

/**
 * @author Ator97
 */
public abstract class Hierba extends Monstruo{
    
    float multiplicador;
    public Hierba(int nivel, String apodo) {
        super(nivel, apodo);
    }
    public Hierba(int nivel) {
        super(nivel);
    }
    
    /**
     * @param m
     * @return
     */
    @Override
    public float multiplicadorElemental(MonstruoEspecifico m) {
	if (m instanceof Agua){
		multiplicador = 2.0f; 
	}
	//if (m  instanceof Fuego){
	//	multiplicador = (float) 0.5; 
	//}
	//if (m  instanceof Hierba){
	//	multiplicador = (float) 0.5; 
	//}		
	//if (m  instanceof Electrico){
	//	multiplicador = (float) 1.0; 

        //}    
        return 0;
        
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
}
