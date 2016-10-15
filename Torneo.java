/**
*@author Oscar Gutiérrez Castillo
*@author David Yaxkin Sánchez Neri
*/
package pokeprebe;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Torneo{
    
    public Contrincante jugador1;
    public Contrincante jugador2;
    public Monstruo monstruo_jugador1;
    public Monstruo monstruo_jugador2;
    public int monstruos_jugador1;
    public int monstruos_jugador2;
    
    Scanner leer = new Scanner(System.in);
    /**
    *@param nombre1 Nombre del  jugador uno
    *@param nombre2 Nombre del jugador dos
    *La funcion aparte de dar nombres a los jugadores, se encarga de repartir, de manera aleatoria los monstruos.
    */
    public Torneo(String nombre1, String nombre2){
        jugador1 = new Contrincante(nombre1);
        jugador2 = new Contrincante(nombre2);
        
        ArrayList<Monstruo> monstruos = new ArrayList<>();
        monstruos.add(new Arbol(50));
        monstruos.add(new Carbon(50));
        monstruos.add(new Chispa(50));
        monstruos.add(new Escarcha(50));
        monstruos.add(new Hielo(50));
        monstruos.add(new Iman(50));
        monstruos.add(new Lava(50));
        monstruos.add(new Nieve(50));
        monstruos.add(new Planta(50));
        monstruos.add(new Rayo(50));
        monstruos.add(new Rosa(50));
        monstruos.add(new Termico(50));
        
        Random randomgenerator = new Random();
        int n = monstruos.size();
        int rand;
        while ( n > 0 ) {
            rand = randomgenerator.nextInt(monstruos.size());
            jugador1.monstruos.add(monstruos.get(rand));
            monstruos.remove(rand);
            n--;
            rand = randomgenerator.nextInt(monstruos.size());
            jugador2.monstruos.add(monstruos.get(rand));
            monstruos.remove(rand);
            n--;
        }
        monstruos_jugador1 = jugador1.monstruos.size();
        monstruos_jugador2 = jugador2.monstruos.size();
        
    }
    /**
    *La funcion se encarga de adminsitrar los cambios de monstruos que den los usuarios
    */
    public void iniciaBatalla() {
        monstruo_jugador1 = jugador1.elegirMonstruo();
        monstruo_jugador2 = jugador2.elegirMonstruo();
    }
    /**
    *Muestra los estatus del monstruo.
    *Da detalles de la vida, disponibilidad de combate y a que jugador pertence.
    */
    public void estadoJuego() {
    System.out.println(jugador1.nombre + ": " + monstruo_jugador1.apodo + 
            "\tHP: " + monstruo_jugador1.hp +
            "\tEstado: " + monstruo_jugador1.estado);
        System.out.println(jugador2.nombre + ": " + monstruo_jugador2.apodo + 
            "\tHP: " + monstruo_jugador2.hp +
            "\tEstado: " + monstruo_jugador2.estado);
    }
    /**
    *@param jugador Es el jugador en turno para atacar, dar pocima o quien cambiará su monstruo.
    *@param monstruo_jugador Monstruo que será afectato por la desisión que tome el jugador 
    *@return En caso de que se efectue un retorno se regresá el resultado de dicho ataque
    */
    public int darInstrucciones(Contrincante jugador, Monstruo monstruo_jugador) {
        
        int accion;
        System.out.println("1. Atacar" + 
            "\t2. Cambiar monstruo" + 
            "\t3. Usar pócima");
        System.out.print(jugador.nombre + ", ¿qué acción deseas realizar? ");
        accion = leer.nextInt();
        
        if(accion == 1) {
            int ataque;
            System.out.println("1. Ataque 1" +
                "\n2. Ataque 2");
            System.out.print("Elige ataque: ");
            ataque = leer.nextInt();
            return ataque;
        }
        if(accion == 2) {
            if(jugador == jugador1) {
                jugador1.guardaMonstruo(monstruo_jugador1);
                monstruo_jugador1 = jugador1.elegirMonstruo();
            }
            if(jugador == jugador2) {
                jugador2.guardaMonstruo(monstruo_jugador2);
                monstruo_jugador2 = jugador2.elegirMonstruo();
            }
        }
        if(accion == 3) {
            int opcion_pocima;
            int opcion_monstruo;
            for(int i = 0; i < jugador.pocimas.size(); i++){
                System.out.println((i+1) + ". " + jugador.pocimas.get(i).toString());
            }
            do {
                System.out.print("Elige pócima a usar: ");
                opcion_pocima = leer.nextInt();
            } while(opcion_pocima <= 0 && opcion_pocima > jugador.pocimas.size());

            jugador.listaMonstruo();
            do {
                
                System.out.println("6. Monstruo: " + monstruo_jugador.apodo +
                            "\tNivel: " + monstruo_jugador.nivel +
                            "\tHP: " + monstruo_jugador.hp +
                            "\tEstado: " + monstruo_jugador.estado);
                System.out.print("Elige monstruo donde se usará la pócima: ");
                opcion_monstruo = leer.nextInt();
            } while(opcion_monstruo <= 0 && opcion_monstruo > jugador.monstruos.size());
            
            if (jugador == jugador1 ){
                if(opcion_monstruo == 6 ){
                    jugador1.usarPocima(jugador1.pocimas.get(opcion_pocima-1), monstruo_jugador1);
                }
                else {
                    jugador.usarPocima(jugador1.pocimas.get(opcion_pocima-1),jugador1.monstruos.get(opcion_monstruo-1));
                }
            }
            if (jugador == jugador2 ){
                if(opcion_monstruo == 6 ){
                    jugador2.usarPocima(jugador2.pocimas.get(opcion_pocima-1), monstruo_jugador2);
                }
                else {
                    jugador.usarPocima(jugador2.pocimas.get(opcion_pocima-1),jugador2.monstruos.get(opcion_monstruo-1));
                }
            
            }
            
        }
        return 0;
    }
    /**
    *@param m1 Monstruo atacante
    *@param m2 Monstruo defensor
    *@param ataque ataque que se efectuara
    *La funcion manda los ataques del monstruo agresor al defensor, ataque 1 o ataque 2 determinan el daño recibido
    *Si el monstruo pierde toda su vida quedará inutil para el combate.
    */
    public void ataqueMonstruos(Monstruo m1, Monstruo m2, int ataque) {
        if(ataque == 1) {
            m1.ataque1(m2);
        }
        if(ataque == 2) {
            m1.ataque2(m2);
        }
    }
    
    /**
    *La funcion se encarga de sustituir un monstruo cuando ya se debilito.
    * @param jugador jugador al que pertenece el monstruo debilitado
    * @param m monstruo debilitado
    */
    public void sustituyeMonstruoDebilitado(Contrincante jugador, Monstruo m) {
        System.out.println(m.apodo + " se ha debilitado.");
        m.estado = "debilitado";
        if(jugador == jugador1) {
            jugador1.guardaMonstruo(m);
            monstruos_jugador1--;
            if(monstruos_jugador1 > 0){
                monstruo_jugador1 = jugador1.elegirMonstruo();
            }
        }
        if(jugador == jugador2) {
            jugador2.guardaMonstruo(m);
            monstruos_jugador2--;
            if(monstruos_jugador2 > 0){
                monstruo_jugador2 = jugador2.elegirMonstruo();
            }
        }
    }
    /**
    *@param ataque1 ataque con bonus elemetnal
    *@param ataque2 ataque normal,el genérico de todos los monstruos.
    */
    public void horaChingazos(int ataque1, int ataque2) {
        if (ataque1 == 0 && ataque2 == 0) {
            return;
        }
        else if(ataque1 != 0 && ataque2 == 0) {
            ataqueMonstruos(monstruo_jugador1,monstruo_jugador2,ataque1);
            if(monstruo_jugador2.hp <= 0){
                sustituyeMonstruoDebilitado(jugador2,monstruo_jugador2);
            }
        }
        else if(ataque1 == 0 && ataque2 != 0) {
            ataqueMonstruos(monstruo_jugador2,monstruo_jugador1,ataque2);
            if(monstruo_jugador1.hp <= 0){
                sustituyeMonstruoDebilitado(jugador1,monstruo_jugador1);
            }
        }
        else {
            if(monstruo_jugador1.velocidad > monstruo_jugador2.velocidad) {
                ataqueMonstruos(monstruo_jugador1,monstruo_jugador2,ataque1);
                if(monstruo_jugador2.hp <= 0){
                   sustituyeMonstruoDebilitado(jugador2,monstruo_jugador2);
                   return;
                }
                ataqueMonstruos(monstruo_jugador2,monstruo_jugador1,ataque2);
                if(monstruo_jugador1.hp <= 0){
                   sustituyeMonstruoDebilitado(jugador1,monstruo_jugador1);
                }
            }
            else {
                ataqueMonstruos(monstruo_jugador2,monstruo_jugador1,ataque2);
                if(monstruo_jugador1.hp <= 0){
                   sustituyeMonstruoDebilitado(jugador1,monstruo_jugador1);
                   return;
                }
                ataqueMonstruos(monstruo_jugador1,monstruo_jugador2,ataque2);
                if(monstruo_jugador2.hp <= 0){
                   sustituyeMonstruoDebilitado(jugador2,monstruo_jugador2);
                }
            }
        }
    }
    /**
    *Funcion principal, es la encargada de llevar el contador de monstrus vivos para determinar que jugador a ganado o no.
    *Compara el numero de monstruos, si uno llega a cero pierde en automático.
    */
    public static void main(String[] args) {
            
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Jugador 1: ");
        String j1 = leer.nextLine();
        System.out.print("Ingrese el nombre del Jugador 2: ");
        String j2 = leer.nextLine();
        
        Torneo torneo = new Torneo(j1,j2);
        torneo.iniciaBatalla();
        do {
            torneo.estadoJuego();
            int ataque1 = torneo.darInstrucciones(torneo.jugador1,torneo.monstruo_jugador1);
            int ataque2 = torneo.darInstrucciones(torneo.jugador2,torneo.monstruo_jugador2);
            torneo.horaChingazos(ataque1,ataque2);
        } while(torneo.monstruos_jugador1 != 0 && torneo.monstruos_jugador2 != 0);
        if(torneo.monstruos_jugador1 == 0) {
            System.out.println("¡" + torneo.jugador2.nombre + " ha ganado la batalla!");
        }
        if(torneo.monstruos_jugador2 == 0) {
            System.out.println("¡" + torneo.jugador1.nombre + " ha ganado la batalla!");
        }
    }
}

