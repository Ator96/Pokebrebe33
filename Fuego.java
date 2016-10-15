package pokeprebe;

import java.util.Random;

/**
 * @author Oscar Gutiérrez Casillo
 */
public abstract class Fuego extends Monstruo{
    
    
    /**
    *@param nivel Para definir los estatus inicailes del monstruo
    *@param apodo En caso de que el usuario asigne un sobrenombre a su monstruo, en caso de que el usuaruo no de un apodo se pone el nombre default del monstruo
    */
    public Fuego(int nivel, String apodo) {
        super(nivel, apodo);
    }
    /**
     * @param m Es la clase padre del monstruo que recibe el ataque 
     * @return multiplicador La cadtidad de daño por la cual será multiplicado el daño que se reciba
     */
    public float multiplicadorElemental(Monstruo m) {
        if (m instanceof Fuego) {
            return (float)0.5f; 
    }
        if (m instanceof Agua) {
            return (float)0.5f; 
    }
        if (m instanceof Electrico) {
            return (float)1.0f; 
    }
        if (m instanceof Hierba) {
            return (float)2.0f; 
    }
        return 0;
    }
    
    /**
     * @param m Se recibe gracias al polimorfismo el tipo de monstruo a atacar, se aplica  un potenciador de daño
     */
    public void ataque1(Monstruo m){
        Random rand = new Random();
        float ran = rand.nextFloat();
        float multiplicador = multiplicadorElemental(m);
        if (ran < 0.8){
            float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
            if (danio <= 0){
                    System.out.println("parece que no ha habido daño alguno");
            }
            m.recibirDanio(danio);    
        }
            System.out.println( "El ataque no ha echo efecto, lo ha esquivado");
    }
}