
package pokeprebe;

/**
 *
 * @author Oscar Gutiérrez Castillo
 */
class  Termico extends Fuego{

    /**
    *@param nivel nivel dado por el usuario para definir los status del monstruo
    *@param apodo nombre que le da el usuario, solo sirve para personalizar
    */

    public Termico(int nivel, String apodo) {
        super(nivel, apodo);
    }

    /**
    *@param nivel nivel dado por el usuario para definir los status del monstruo
    */
    public Termico(int nivel  ) {
        super(nivel,"Termico");
    }    

    /**
    *@param m Por polimorfismo afectamos directamente el status de vida del monstruo a atacar
    */
    @Override
   public void ataque2(Monstruo m) {
        float danio = (float) ((getAtaque() -  m.getDefensa()) * 1.3);
        if (danio <= 0){
            danio = 0;
        }
        m.recibirDanio(danio);
        System.out.println(this.apodo + " ha usado Onda Calor, " + m.apodo + " ha recibido " + danio + " puntos de daño");
   }

}