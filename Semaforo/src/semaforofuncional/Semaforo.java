package semaforofuncional;

public class Semaforo {

	public static void main(String[] args) throws InterruptedException {
		
		boolean terminar = true;
		
		
		while(terminar=true) {
			terminar=true;
		
		System.out.print("\n\033[31m ⚫");
		
		for(int i=5; i>=1; i-- ) {
			System.out.print("\033[30m"+i+"s.");
			
			try {
				
				Thread.sleep(1000);
				
			}catch(IllegalArgumentException e) {
				System.out.println("ERROR");
			}
			
		}
		
		System.out.print("\n\033[33m ⚫");
		
		for(int i=2; i>=1; i-- ) {
			System.out.print("\033[30m"+i+"s.");
			
			try {
				
				Thread.sleep(1000);
				
			}catch(IllegalArgumentException e) {
				System.out.println("ERROR");
			}
			
		}
		
		
		System.out.print("\n\033[32m ⚫");
		
		
		for(int i=4; i>=1; i-- ) {
			System.out.print("\033[30m"+i+"s.");
			
			try {
				
				Thread.sleep(1000);
				
			}catch(IllegalArgumentException e) {
				System.out.println("ERROR");
			}
			
		}
		}
		
		
		
		

	}

}
