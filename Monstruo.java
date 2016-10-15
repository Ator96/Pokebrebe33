package pokeprebe;
import java.util.Random;

/**
*@author Oscar Gutiérrez Castillo
*@version 1.0.0.
* La clase Monstruo genera la plantilla básica de la cual emanarán todos los tipos  y 
* monstruos específicos.
*/

public abstract class Monstruo{
	
        Random randomGenerator = new Random();
	protected float hp ;
	protected String apodo;
	protected int nivel;
	protected float ataque;
	protected float defensa;
	protected float velocidad;
	protected String estado = "Ok";
	/**
	*@param nivel nivel del monstruo dado por el usuario
	*@param apodo apodo del monstruo dado por el usuario
        * El metodo define los status del mosntruo
        * Los parametros que recibe on gracias a la herencia 
        * dada por los cuatro tipos elementales.
        * Para este método construcor, se solicita saber el nivel y el apodo que identificará a futuro al monstruo.
	*/
        @SuppressWarnings("OverridableMethodCallInConstructor")
	Monstruo (int nivel, String apodo){
                this.nivel = nivel;
                int randomInt = randomGenerator.nextInt(10);
           	setAtaque((float)(nivel * (float)(15 + randomInt) ));
                randomInt = randomGenerator.nextInt(10);
		setDefensa((float)(nivel * (float)(10 + randomInt) ));
                randomInt = randomGenerator.nextInt(10);
		setVelocidad( (float)(nivel *(float)(10 + randomInt) ));
                randomInt = randomGenerator.nextInt(10);
		this.hp = nivel  * (float)(10 + randomInt);
		this.apodo = apodo;
	}

	/**
	*@param nivel nivel del mosntruo dado por el usuario
        * El método define los estatus del monstruo
        * Este constructor solo recibe el nivel del monstruo
        * El apodo será omitido y se dará un nombre default.
	*/
        @SuppressWarnings("OverridableMethodCallInConstructor")
	Monstruo (int nivel){        
                this.nivel = nivel;
                int randomInt = randomGenerator.nextInt(10);
           	setAtaque((float)(nivel * (float)(15 + randomInt) ));
                randomInt = randomGenerator.nextInt(10);
		setDefensa((float)(nivel * (float)(10 + randomInt) ));
                randomInt = randomGenerator.nextInt(10);
		setVelocidad( (float)(nivel *(float)(10 + randomInt) ));
                randomInt = randomGenerator.nextInt(10);
		this.hp = nivel  * (float)(10 + randomInt);

	}
	/**
	*@param ataque Danio recibido al monstruo
        *@return estado se regresa una cadena cuando el monstruo ha sido derrotado
        * El método  actualiza la vida del mosntruo acorde al numero de daño que se le apliqué
	*/
	public  String recibirDanio(float ataque){
		this.hp = this.hp - ataque;
		if (this.hp <= 0){
			estado = "fuera de combate";
			return "ha sido derrotado" ;
		}
		return "" ;

	}
	/**
	*@param aumento pocima de aumento de vida recibida por su dueño
        * @return Comentario sobre el estado
        * El método actualia la vida del monstruo aumentando la vida acorde a la posión que se le dé
	*/
	public  String recibirHp(float aumento){
		this.hp = this.hp + aumento;
		return "ha aumentado la vida";
	}
	/**
	*@param aumento pocima de aumento de ataque recibida por su dueño
        * Actualiza la cantidad de defensa que posee el monstruo al recibir una pocima
	*/
	public  void recibirAtaque(float aumento){
		this.ataque = this.ataque + aumento;
	}
	/**
	*@param aumento pocima de aumento de defensa recibida por el dueño
        * Actualiza la cantidad de defensa que posee el monstruo al recibir una pocima
	*/
	public  void recibirDefensa(float aumento){
		this.defensa = this.defensa + aumento;
	}
	/**
	*@return ataque Obtenemos poder de ataque que posee el monstruo
	*/
	public  float getAtaque(){
		return this.ataque;
	}
	/**
	*@return ataque Obtenemos la defensa  que posee el monstruo
	*/
	public  float getDefensa(){
		return this.defensa;
	}
	/**
	*@return ataque Obtenemos la vida que posee el monstruo
	*/
	public  float getVelocidad(){
		return this.velocidad;
	}
	/**
        * @param ataque nivel de ataque con el que es inicializado
        * Obtenemos poder de ataque que posee el monstruo
	*/
	public  void setAtaque(float ataque){
		this.ataque += ataque;
	}
	/**
        * @param defensa nivel de ataque con el que es inicializado
        * Obtenemos poder de defensa que posee el monstruo
	*/        
	public  void setDefensa(float defensa){
		this.defensa += defensa;
	}
	/**
        *@param velocidad nivel de ataque con el que es inicializado
        *Obtenemos poder de la velocidad que posee el monstruo
	*/        
	public  void setVelocidad(float velocidad){
		this.velocidad += velocidad;

	}
	public abstract float multiplicadorElemental(Monstruo m);
	public abstract void ataque1(Monstruo m);
	public abstract void ataque2(Monstruo m);
}
