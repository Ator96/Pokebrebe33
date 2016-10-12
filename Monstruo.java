package pokeprebe;

/**
*@author Oscar Gutiérrez Castillo
*@version 1.0.0.
*/

public abstract class Monstruo{
	
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
	*/
        @SuppressWarnings("OverridableMethodCallInConstructor")
	Monstruo (int nivel, String apodo){
		setAtaque((float)(nivel * 15.0));
		setDefensa((float)(nivel * 10.0));
		setVelocidad( (float)(nivel * 10.0));
		this.hp = nivel  * 15;
		this.apodo = apodo;
	}

	/**
	*@param nivel nivel del mosntruo dado por el usuario
	*/
        @SuppressWarnings("OverridableMethodCallInConstructor")
	Monstruo (int nivel){
		setAtaque((float)(nivel * 15.0));
		setDefensa((float)(nivel * 10.0));
		setVelocidad( (float)(nivel * 10.0));
		this.hp = nivel * 15;
	}
	/**
	*@param ataque Danio recibido al monstruo
     * @return 
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
	*@param p pocima de aumento de vida recibida por su dueño
        * @return Comentario sobre el estado
	*/
	public  String recibirHp(float aumento){
		this.hp = this.hp + aumento;
		return "ha aumentado la vida";
	}
	/**
	*@param p pocima de aumento de vida recibida por su dueño
        * @return Comentario sobre el estado
	*/
	public  void recibirAtaque(float aumento){
		this.ataque = this.ataque + aumento;
	}
	/**
	*@param p pocima de aumento de defensa recibida por el dueño
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
	public abstract float multiplicadorElemental(MonstruoEspecifico m);
	public abstract String ataque1(float multiplicador,MonstruoEspecifico m);
	public abstract String ataque2(MonstruoEspecifico m);
}
