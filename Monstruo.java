/**
*@author Oscar Gutiérrez Castillo
*@version 1.0.0.
*/


public  abstract class Monstruos{
	
	protected float hp ;
	protected String apodo;
	protected int nivel;
	protected float ataque;
	protected float defensa;
	protected float velocidad;
	protected String estado = 'Ok';
	/**
	*
	*@param nivel nivel del monstruo dado por el usuario
	*@param apodo apodo del monstruo dado por el usuario
	*
	*/
	Monstruos (int nivel, String apodo){
		setAtaque((float)nivel * 15.0);
		setDefensa((float)nivel * 10.0);
		setVelocidad( (float)nivel * 10.0);
		this.hp = nivel  *15.0;
		this.apodo = apodo;
	}

	/**
	*@param nivel nivel del mosntruo dado por el usuario
	*/
	Monstruos (int nivel){
		setAtaque((float)nivel * 15.0);
		setDefensa((float)nivel * 10.0);
		setVelocidad( (float)nivel * 10.0);
		this.hp = nivel  *15.0;
	}
	/**
	*@param ataque Danio recibido al monstruo
	*/
	public  void recibirDanio(float ataque){
		this.hp = this.hp - ataque * (1/3)* defensa;
	}
	/**
	*@param p pocima de aumento de vida recibida por su dueño
	*/
	public  void recibirHp(PocimaVida p){
		this.hp = this.hp + p.aumento;
	}
	/**
	*@param p pocima de aumento de defensa recibida por el dueño
	*/
	public  void recibirDefensa(PocimaDefensa p){
		this.defensa = this.defensa + p.aumento;
	}
	/**
	*@param  p
	*/
	public  float getAtaque(){
		return this.ataque;
	}
	public  float getDefensa(){
		return this.defensa;
	}
	public  float getVelocidad(){
		return this.velocidad;
	}
	public  void setAtaque(float ataque){
		this.ataque += ataque;
	}
	public  void setDefensa(float defensa){
		this.defensa += defensa;
	}
	public  void setVelocidad(float velocidad){
		this.velocidad += velocidad;

	}
	public abstract void multiplicadorElemental();
	public abstract void ataque1();
	public abstract void ataque2();
}