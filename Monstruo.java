public  abstract class Monstruos{
	
	protected float hp ;
	protected String apodo;
	protected int nivel;
	protected float ataque;
	protected float defensa;
	protected float velocidad;
	protected String estado = 'Ok';

	Monstruos (int nivel, String apodo){
		this.ataque = nivel * 15;
		this.defensa = nivel * 10;
		this.velocidad = nivel * 10;
		this.hp = nivel  *15;
		this.apodo = apodo;
	}
	public  void recibirDanio(float ataque){
		this.hp = hp - ataque * (1/3)* defensa;
	}
	public  void recibirAtaque(Pocima p);
	public  void recibirDefensa();
	public  void getAtaque();
	public  void getDefensa();
	public  void getVelocidad();
	public  void setAtaque();
	public  void setDefensa();
	public  void setVelocidad();
	public abstract void multiplicadorElemental();
	public abstract void ataque1();
	public abstract void ataque2();
}