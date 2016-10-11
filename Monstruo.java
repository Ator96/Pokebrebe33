public  abstract class Monstruos{
	
	protected float hp ;
	protected String apodo;
	protected int nivel;
	protected float ataque;
	protected float defensa;
	protected float velocidad;
	protected String estado = 'Ok';

	Monstruos (int nivel, String apodo){
		setAtaque((float)nivel * 15.0);
		setDefensa((float)nivel * 10.0);
		setVelocidad( (float)nivel * 10.0);
		this.hp = nivel  *15.0;
		this.apodo = apodo;
	}

	Monstruos (int nivel){
		setAtaque((float)nivel * 15.0);
		setDefensa((float)nivel * 10.0);
		setVelocidad( (float)nivel * 10.0);
		this.hp = nivel  *15.0;
	}

	public  void recibirDanio(float ataque){
		this.hp = this.hp - ataque * (1/3)* defensa;
	}
	public  void recibirHp(PocimaVida p);
		this.hp = this.hp + p.aumento;

	public  void recibirDefensa(PocimaDefensa p){
		this.defensa = this.defensa + p.aumento;
	}
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