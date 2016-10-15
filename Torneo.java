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
    public Torneo(String nombre1, String nombre2){
        jugador1 = new Contrincante("Pepe");
        jugador2 = new Contrincante("Luis");
        
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

    public void iniciaBatalla() {
        monstruo_jugador1 = jugador1.elegirMonstruo();
        System.out.println(jugador1.nombre + " ha enviado a " + monstruo_jugador1.apodo);
        monstruo_jugador2 = jugador2.elegirMonstruo();
        System.out.println(jugador2.nombre + " ha enviado a " + monstruo_jugador2.apodo);
    }

    public void estadoJuego() {
    System.out.println("Jugador 1:" + monstruo_jugador1.apodo + 
            "HP: " + monstruo_jugador1.hp +
            "Estado: " + monstruo_jugador1.estado);
        System.out.println("Jugador 2:" + monstruo_jugador2.apodo + 
            "HP: " + monstruo_jugador2.hp +
            "Estado: " + monstruo_jugador2.estado);
    }

    public int darInstrucciones(Contrincante jugador, Monstruo monstruo_jugador) {
        
        int accion;
    System.out.println("1. Atacar" + 
            "\n2. Cambiar monstruo" + 
            "\n3. Usar pócima");
    System.out.println(jugador.nombre + ", ¿qué acción desea realizar? ");
    accion = leer.nextInt();

    if(accion == 1) {
            int ataque;
            System.out.println("1. Ataque 1" +
        "\n2. Ataque 2");
            System.out.println("Elige ataque: ");
            ataque = leer.nextInt();
            return ataque;
    }
    if(accion == 2) {
            jugador.guardaMonstruo(monstruo_jugador);
            monstruo_jugador = jugador.elegirMonstruo();
            System.out.println(jugador.nombre + " ha cambiado por " + monstruo_jugador.apodo);
    }
    if(accion == 3) {
            int opcion_pocima;
            int opcion_monstruo;
            for(int i = 0; i < jugador.pocimas.size(); i++){
        System.out.println((i+1) + ". " + jugador.pocimas.get(i).toString());
            }
            do {
        System.out.println("Elige pócima a usar: ");
        opcion_pocima = leer.nextInt();
            } while(opcion_pocima <= 0 && opcion_pocima > jugador.pocimas.size());

            for(int i = 0; i < jugador.monstruos.size(); i++){
        System.out.println((i+1) + ". " + jugador.monstruos.get(i).apodo);
            }
            do {
                jugador.listaMonstruo();
        System.out.println("Elige monstruo donde se usará la pócima: ");
        opcion_monstruo = leer.nextInt();
            } while(opcion_monstruo <= 0 && opcion_monstruo > jugador.monstruos.size());
            jugador.usarPocima(jugador.pocimas.get(opcion_pocima-1),jugador.monstruos.get(opcion_monstruo-1));
    }
    return 0;
    }

    public void ataqueMonstruos(Monstruo m1, Monstruo m2, int ataque) {
        if(ataque == 1) {
            m1.ataque1(m2);
        }
        if(ataque == 2) {
            m1.ataque2(m2);
        }
        if(m2.hp <= 0) {
            System.out.println(m2.apodo + "se ha debilitado.");
            m2.estado = "debilitado";
            jugador2.guardaMonstruo(m2);
            monstruos_jugador2--;
            if(monstruos_jugador2 > 0){
                m2 = jugador2.elegirMonstruo();
            }
        }   
    }

    public void horaChingazos(int ataque1, int ataque2) {
        if(ataque1 == 0 && ataque2 == 0) {
                return;
        }
        else if(ataque1 != 0 && ataque2 == 0) {
            ataqueMonstruos(monstruo_jugador1,monstruo_jugador2,ataque1);
            return;
        }
        else if(ataque1 == 0 && ataque2 != 0) {
            ataqueMonstruos(monstruo_jugador2,monstruo_jugador1,ataque2);
            return;
        }
        else {
            if(monstruo_jugador1.velocidad > monstruo_jugador2.velocidad) {
                ataqueMonstruos(monstruo_jugador1,monstruo_jugador2,ataque1);
                ataqueMonstruos(monstruo_jugador2,monstruo_jugador1,ataque2);
                return;
            }
            else {
                ataqueMonstruos(monstruo_jugador2,monstruo_jugador1,ataque2);
                ataqueMonstruos(monstruo_jugador2,monstruo_jugador1,ataque2);
                return;
            }
        }
    }

    public static void main(String[] args) {
            
            Torneo torneo = new Torneo("Pepe","Luis");
        torneo.iniciaBatalla();
        do {
            torneo.estadoJuego();
            int ataque1 = torneo.darInstrucciones(torneo.jugador1,torneo.monstruo_jugador1);
            int ataque2 = torneo.darInstrucciones(torneo.jugador2,torneo.monstruo_jugador2);
            if(ataque1 != 0 && ataque2 != 0) {
                 torneo.horaChingazos(ataque1,ataque2);
            }
        } while(torneo.monstruos_jugador1 != 0 && torneo.monstruos_jugador2 != 0);
        if(torneo.monstruos_jugador1 == 0) {
            System.out.println("¡" + torneo.jugador2.nombre + " ha ganado la batalla!");
        }
        if(torneo.monstruos_jugador2 == 0) {
            System.out.println("¡" + torneo.jugador1.nombre + " ha ganado la batalla!");
        }
    }
}

