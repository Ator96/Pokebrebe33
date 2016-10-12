package pokeprebe;

import java.util.ArrayList;
import java.util.Iterator;

public class Contrincante {
	
	public String nombre;
	public ArrayList<Monstruo> monstruos;
	public ArrayList<Pocima> pocimas;

	public Contrincante() {
		this.pocimas.add(new PocimaVida());
		this.pocimas.add(new PocimaVida());
		this.pocimas.add(new PocimaAtaque());
		this.pocimas.add(new PocimaAtaque());
		this.pocimas.add(new PocimaDefensa());
		this.pocimas.add(new PocimaDefensa());
		/*Esto queda por definir de acuerdo a las clases de monstruo que definamos
		this.monstruos.add(new Monstruo);
		this.monstruos.add(new Monstruo);
		this.monstruos.add(new Monstruo);
		this.monstruos.add(new Monstruo);
		this.monstruos.add(new Monstruo);
		this.monstruos.add(new Monstruo);
		*/
	}

	public void guardaMonstruo(Monstruo monstruo) {
		this.monstruos.add(monstruo);
	}

	public Monstruo elegirMonstruo(Monstruo monstruo) {
		return remove(mostruos.indexOf(monstruo));
	}

	public void usarPocima(Pocima pocima, Monstruo monstruo) {
		pocima.usar(monstruo);
		pocimas.remove(pocima);
	}

	public void listaMonstruo() {
		Iterator iterador = monstruos.iterator();
		while(iterador.hasNext()) {
			System.out.println("Monstruo: " + iterador.next().nombre);
			System.out.println("\tNivel: " + iterador.next().nivel);
			System.out.println("\tHP: " + iterador.next().hp);
			System.out.println("\tEstado: " + iterador.next().estado);
		}
	}
}