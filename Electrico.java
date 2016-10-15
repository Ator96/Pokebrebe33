package pokeprebe;

import java.util.Random;

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
    public float multiplicadorElemental(Monstruo m){
        if(m instanceof Agua){
            return 2.0f;
        }
        if(m instanceof Hierba ){
            return 0.5f;
        }
        if (m instanceof Electrico){
            return 0.5f;
        }
        if (m instanceof Fuego){
            return 1.0f;
        }
        return 0;
    }
    /**
     * @param m Se recibe gracias al polimorfismo el tipo de monstruo a atacar, se aplica  un potenciador de daño
     * @return Estado sobre el daño
     */
    public void ataque1(Monstruo m){
        Random rand = new Random();
        float ran = rand.nextFloat();
        float multiplicador = multiplicadorElemental(m);
        if (ran < 0.8){
            float danio = (getAtaque() -  m.getDefensa() ) * multiplicador;
            if (danio <0) {
                danio = 0;
            }
            System.out.println(this.apodo + " ha usado Rayo, " + m.apodo + " ha recibido " + danio + " puntos de daño");
            m.recibirDanio(danio);    
        }
        else{
            System.out.println(this.apodo + " ha fallado.");
        }
    }
}