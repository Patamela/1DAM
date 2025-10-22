package gru;

public class Villano {
	private String nombre;
	private int maldad;
	private static int victorias = 0;
	private static int ejercito = 0;
	
	//CONSTRUCTORES
	public Villano() {
		
	}
	
	
	public Villano(String nombre, int maldad, int victorias, int ejercito) {
		this.nombre = nombre;
		this.maldad = maldad;
		this.victorias = victorias;
		this.ejercito = ejercito;
	}


	public Villano(String nombre, int maldad) {
		this.nombre = nombre;
		if(maldad>4) {
			maldad = 4;
		}else if(maldad<1) {
			maldad = 1;
		}
		this.maldad = maldad;
		setEjercito(maldad);
		
	}
	
	
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getMaldad() {
		return maldad;
	}
	
	
	public int getVictorias() {
		return victorias;
	}


	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	

	public int getEjercito() {
		return ejercito;
	}


	public void setEjercito(int maldad) {
		int ejercito = 0;
		if(maldad==1) {
			ejercito = 10;
		}else if(maldad==2){
			ejercito = 20;
		}else if(maldad==3){
			ejercito=30;
		}else if(maldad==4){
			ejercito = 40;
		}else {
			ejercito=0;
		}
		this.ejercito = ejercito;
	}


	//TO STRING
	@Override
	public String toString() {
		return "Villano [nombre=" + nombre + ", maldad=" + maldad + ", ejercito=" + ejercito +", victorias="+victorias +"]";
	}
	
	//METODOS	
	
	public static int registrarVictorias(boolean victoria) {
		if(victoria==true) {
			victorias+=1;
			return victorias;
		}else {
			return victorias;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
