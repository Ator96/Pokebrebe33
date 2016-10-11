public  abstract class Monstruos{
	
	float hp;
	String apodo;
	int nivel;
	float ataque;
	float defensa;
	float velocidad;
	String estado;

	public abstract void recibirDanio(float ataque);
	public abstract void recibirAtaque(pocima);
	public abstract void recibirDefensa();
	public abstract void getAtaque();
	public abstract void getDefensa();
	public abstract void getVelocidad();
	public abstract void setAtaque();
	public abstract void setDefensa();
	public abstract void setVelocidad();
	public abstract void multiplicadorElemental();
	public abstract void ataque1();
	public abstract void ataque2();
}