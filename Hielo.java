
package pokeprebe;

/**
 *
 * @author Oscar Gutiérrez Castillo
 */
class  Hielo extends Agua{

    /**
    *@param nivel nivel dado por el usuario para definir los status del monstruo
    *@param apodo nombre que le da el usuario, solo sirve para personalizar
    */

    public Hielo(int nivel, String apodo) {
        super(nivel, apodo);
    }

    /**
    *@param nivel nivel dado por el usuario para definir los status del monstruo
    */
    public Hielo(int nivel  ) {
        super(nivel,"Hielo");
    }    

    /**
    *@param m Por polimorfismo afectamos directamente el status de vida del monstruo a atacar
    */
    @Override
   public void ataque2(Monstruo m) {
        float danio = (float) (getAtaque() -  m.getDefensa() * 1.5);
            if (danio <= 0){
		System.out.println( "parece que no ha habido daño alguno");
           }
	m.recibirDanio(danio);
    System.out.println(m.apodo + "ha sido atacado y ha recibido un daño de:" + danio);
        }
 

}