
package pokeprebe;

/**
 *
 * @author Ator97
 */
class  Arbol extends Agua{

    public Arbol(int nivel, String apodo) {
        super(nivel, apodo);
    }

    public Arbol(int nivel  ) {
        super(nivel);
    }    

    @Override
    public String ataque2(Monstruo m) {
        float danio = (float) (getAtaque() -  m.getDefensa() * 1.5);
            if (danio <= 0){
		return "parece que no ha habido daño alguno";
           }
	m.recibirDanio(danio);
        return null;
    }
 

}