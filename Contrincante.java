package pokeprebe;

import java.util.ArrayList;
import java.util.Scanner;

/**
* @author David Yaxkin Sánchez Neri
* Clase que representa a un contrincante
*/
public class Contrincante {
	
	public String nombre;
	public ArrayList<Monstruo> monstruos;
	public ArrayList<Pocima> pocimas;

	public Contrincante(String nombre) {
		this.nombre = nombre;
		this.pocimas = new ArrayList<Pocima>();
		this.pocimas.add(new PocimaVida());
		this.pocimas.add(new PocimaVida());
		this.pocimas.add(new PocimaAtaque());
		this.pocimas.add(new PocimaAtaque());
		this.pocimas.add(new PocimaDefensa());
		this.pocimas.add(new PocimaDefensa());
		/*Esto queda por definir de acuerdo a las clases de monstruo que definamos*/
		this.monstruos = new ArrayList<Monstruo>();
		/**/
	}
	/**
	* Guarda el monstruo activo en la banca
	* @param monstruo Monstruo activo 
	*/
	public void guardaMonstruo(Monstruo monstruo) {
		this.monstruos.add(monstruo);
	}

	/**
	* Cambia el monstruo activo en el combate
	* @return Monstruo elegido para salir a combatir
	*/
	public Monstruo elegirMonstruo() {
		Scanner leer = new Scanner(System.in);
		int opcion;
		listaMonstruo();
		do {
			System.out.println("Elige un monstruo");
			opcion = leer.nextInt();
                }
		while(monstruos.get(opcion-1).estado.equals("debilitado"));
		
		return monstruos.remove(opcion-1);
	}

	/**
	* Usa la pocima elegida en el monstruo elegido
	* @param pocima Pocima a usar
	* @param monstruo Monstruo en el que se usara la pocima
	*/
	public void usarPocima(Pocima pocima, Monstruo monstruo) {
		pocima.usar(monstruo);
		pocimas.remove(pocima);
	}

	/**
	* Muestra los monstruos en la banca del contrincante.
	*/
	public void listaMonstruo() {
		for (int i = 0; i < monstruos.size(); i++) {
			System.out.println((i+1) + ". Monstruo: " + monstruos.get(i).apodo);
			System.out.println("\tNivel: " + monstruos.get(i).nivel);
			System.out.println("\tHP: " + monstruos.get(i).hp);
			System.out.println("\tEstado: " + monstruos.get(i).estado);
		}
	}
}