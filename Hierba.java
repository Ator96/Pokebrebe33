package pokeprebe;

/**
 * @author Oscar Gutiérrez Castillo
 */
public abstract class Hierba extends Monstruo{
    
    /**
    *@param nivel Para definir los estatus inicailes del monstruo
    *@param apodo En caso de que el usuario asigne un sobrenombre a su monstruo, en caso de que el usuaruo no de un apodo se pone el nombre default del monstruo
    */
    public Hierba(int nivel, String apodo) {
        super(nivel, apodo);
    }
     /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */
    public float multiplicadorElemetnal(Monstruo m){
        
    if (m instanceof Agua){
            return  2.0f; 
        }
        if (m instanceof Fuego ){
            return 0.5f; 
        }
        if (m instanceof Hierba ){
            return 0.5f; 
        }
        if(m instanceof Electrico ){
            return 1.0f;
        } 
        return 0;
    }

    /**
     * @param m Se recibe gracias al polimorfismo el tipo de monstruo a atacar, se aplica  un potenciador de daño
     * @return Estado sobre el daño
     */
    public String ataque1(Monstruo m){
        float multiplicador = multiplicadorElemental(m);
    float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
    if (danio <= 0){
        return "parece que no ha habido daño alguno";
    }
    m.recibirDanio(danio);    
        return null;
    }

}

