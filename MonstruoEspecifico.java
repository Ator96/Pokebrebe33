/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokeprebe;

/**
 *
 * @author Ator97
 */
class  MonstruoEspecifico extends Agua{

    public MonstruoEspecifico(int nivel, String apodo) {
        super(nivel, apodo);
    }

    public MonstruoEspecifico(int nivel  ) {
        super(nivel);
    }    

    @Override
    public String ataque2(MonstruoEspecifico m) {
        float danio = (float) (getAtaque() -  m.getDefensa() * 1.5);
            if (danio <= 0){
		return "parece que no ha habido daño alguno";
           }
	m.recibirDanio(danio);
        return null;
    }
 

}
    

