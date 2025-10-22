package buscacaptura;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CapturarVelociraptores {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int[] posicionesVelociraptores = new int[10];
		
		inicializacionVelociraptores(posicionesVelociraptores, random);
		
		int opcion= 0;
		boolean salida = true;
		
		do {
			menu();
			try {
				System.out.println("¿Qué acción desea realizar?");
			    opcion = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("No es válido ese caracter.");
				sc.next();
			}
			
			eleccion(opcion, sc, posicionesVelociraptores);
			
		
		}while(salida=true);

	}

	private static void inicializacionVelociraptores(int posicionesVelociraptores[], Random random) {
		
		
		for(int i=0; i<posicionesVelociraptores.length; i++) {
			posicionesVelociraptores[i]=random.nextInt(2);
			
		}
		
	}

	private static void eleccion(int opcion, Scanner sc, int posicionesVelociraptores[]) {
		try {
		switch(opcion){
		case 1:
			System.out.println("¿En qué posición quiere buscar?");
			opcion=sc.nextInt();
			busqueda(opcion, sc, posicionesVelociraptores);
			break;
		case 2:
			System.out.println("Diga la posición para capturar al Velociraptor.");
			opcion=sc.nextInt();
			capturar(opcion, sc, posicionesVelociraptores);
			break;
		case 3:
			System.out.println("---Mapa---");
			mapa(posicionesVelociraptores);
			break;
		default:
			System.out.println("No es una opción válida.");
			break;
		}
		}catch(InputMismatchException e) {
			System.out.println("Este caracter no es válido.");
		}
	}

	private static void mapa(int posicionesVelociraptores[]) {
		for(int i=0; i<posicionesVelociraptores.length; i++) {
			
			if(posicionesVelociraptores[i]==1){
				System.out.print("X ");
			}else {
				System.out.print("- ");
			}
			
		}
		
	}

	private static void capturar(int opcion, Scanner sc, int posicionesVelociraptores[]) {
		for(int i=1; i<=10; i++) {
			
			if(opcion==i) {
				if(posicionesVelociraptores[opcion-1]==1) {
					posicionesVelociraptores[opcion-1]=0;
					System.out.println("¡Enhorabuena! Has capturado a un Velociraptor.");
				}else {
					System.out.println("No hay nada en esta posición. Has fallado la captura.");
				}
			}
		}
		
	}

	private static void busqueda(int opcion, Scanner sc, int posicionesVelociraptores[]) {
		
		for(int i=1; i<=10; i++) {
			
			if(opcion==i) {
				if(posicionesVelociraptores[opcion-1]==1) {
					System.out.println("¡Has encontrado un Velociraptor!");
					
				}else {
					System.out.println("Esta posición está libre de Velociraptores.");
				}
			}
		}
	}

	private static void menu() {
		System.out.println("\n------------------------------------------------------");
		System.out.println("1.Buscar Velociraptores en una posicón.");
		System.out.println("2.Capturar Velociraptor en una posicón.");
		System.out.println("3.Mostrar mapa.");
	}


	}


