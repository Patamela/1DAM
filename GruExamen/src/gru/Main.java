package gru;

import java.util.Scanner;

public class Main {

	static Mision[] misiones = new Mision[10];
	static Minions[] minions = new Minions[40];
	
	public static void main(String[] args) {
		Scanner letra = new Scanner(System.in);
		Scanner numero = new Scanner(System.in);
		
		int opcion = 0;
		String nombreVillano;
		int maldad;
		
		
		System.out.println("---Creación de tu villano---");
		System.out.println("¿Cómo se llama tu villano?");
		nombreVillano = letra.nextLine();
		System.out.println("¿Cuál es su nivel de maldad?(1-4)");
		maldad = numero.nextInt();
		
		Villano v1 = new Villano(nombreVillano, maldad);
		
		while(opcion!=5) {
			menu();
			System.out.println("¿Qué desea hacer?");
			opcion = numero.nextInt();
			tratarMenu(opcion, numero, letra, v1);
		}
		

	}

	private static void tratarMenu(int opcion, Scanner numero, Scanner letra, Villano v1) {
		switch(opcion) {
		case 1:
			creacionMisiones(numero, letra);
			break;
		case 2:
			listarMisiones();
			break;
		case 3:
			listarEstadisticas(v1);
			break;
		case 4:
			conseguirVictorias(v1, numero);
			break;
		case 5:
			System.out.println("Saliendo del programa.");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
		
	}
	
	
	private static void conseguirVictorias(Villano v1, Scanner numero) {
		Minions minion = new Minions();
		int fuerzas = 0;
		int opcion = 0;
		boolean conseguido = false;
		listarMisiones();
		System.out.println("¿Qué misión quieres realizar?");
		opcion = numero.nextInt();

		reclutarMinions(v1);
		for (int i = 0; i < minions.length; i++) {
			if (minions[i] != null) {
				fuerzas += minions[i].getFuerza();
				fuerzas -= minions[i].getTorpeza();
			}
			
		}
		System.out.println("Fuerza de tus minions: "+fuerzas);
		if (fuerzas >= misiones[opcion-1].getPuntuacionNecesaria()){
			conseguido=true;
			v1.registrarVictorias(conseguido);
			misiones[opcion-1] = null;
		}else if(fuerzas < misiones[opcion-1].getPuntuacionNecesaria()) {
			conseguido = false;
			v1.registrarVictorias(conseguido);
		}
		
		
	}
		

	public static void reclutarMinions(Villano v1) {
		for (int i = 0; i < v1.getEjercito(); i++) {
			Minions minion1 = new Minions();

			for (int j = 0; j < (v1.getEjercito()); j++) {
				minions[i] = minion1;
			}
		}

	}
	

	private static void listarEstadisticas(Villano v1) {
		System.out.println(v1.toString());
		
	}

	private static void listarMisiones() {
		for(int i=0; i<misiones.length; i++) {
			if(misiones[i]!=null) {
				System.out.println(misiones[i]);
			}
		}
		
	}

	private static void creacionMisiones(Scanner numero, Scanner letra) {
		String nombre;
		String descripcion;
		int puntuacionNecesaria;
		
		System.out.println("Introduzca el nombre de la misión:");
		nombre = letra.nextLine();
		System.out.println("Introduzca la descripción de la misión:");
		descripcion = letra.nextLine();
		System.out.println("Introduzca la puntuación necesaria para poder conseguir la victoria:");
		puntuacionNecesaria = numero.nextInt();
		
		
		Mision m1 = new Mision(nombre, descripcion, puntuacionNecesaria);
		
		for(int i=0; i<misiones.length; i++) {
			if(misiones[i]==null) {
				misiones[i]=m1;
				i=misiones.length;
			}
		}
		
		
		
	}

	private static void menu() {
		System.out.println("--------------------------------");
		System.out.println("1.Crear misión.");
		System.out.println("2.Listar misiones.");
		System.out.println("3.Listar estadísticas de mi villano.");
		System.out.println("4.Conseguir victorias.");
		System.out.println("5.Salir.");
		
	}

}
