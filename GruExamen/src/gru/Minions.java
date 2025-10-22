package gru;

import java.util.Random;

public class Minions {
	
	private int fuerza;
	private int torpeza;
	
	
	//CONSTRUCTORES
	public Minions() {
		Random random = new Random();
		this.fuerza = random.nextInt(10)+1;
		this.torpeza = random.nextInt(10)+1;
		
	}


	
	public Minions(int fuerza, int torpeza) {
		this.fuerza = fuerza;
		this.torpeza = torpeza;
	}




	//GETTERS Y SETTERS
	public int getFuerza() {
		return fuerza;
	}

	public int getTorpeza() {
		return torpeza;
	}



	//TO STRING
	
	@Override
	public String toString() {
		return "Minions [fuerza=" + fuerza + ", torpeza=" + torpeza + "]";
	}
	
	
	
	
	
	
}
