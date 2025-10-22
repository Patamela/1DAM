package juegoAhorcado;

import java.util.ArrayList;

public class MainC5 {

	public static void main(String[] args) {
		int opcion = 0;
		DBConnection db = new DBConnection();
		while(opcion!=3) {
			menu();
			opcion = Lector.leerEntero("¿Qué desea hacer?");
			tratarMenu(opcion,db);
		}
	}

	private static void tratarMenu(int opcion, DBConnection db) {
		switch(opcion) {
		case 1:
			iniciarSesion(db);
			break;
		case 2:
			registrarse(db);
			break;
		case 3:
			System.out.println("Saliendo del programa...");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
		
	}

	private static void registrarse(DBConnection db) {
		System.out.println("----REGISTRARSE-----");
		String nombre = Lector.leerCadena("Introduzca el nombre: ");
		Auxiliar.setNombre(nombre);
		String contrasenia = Lector.leerCadena("Introduzca la contraseña: ");
		Auxiliar.setContrasenia(contrasenia);
		Jugador j = new Jugador(nombre, contrasenia);
		if(db.registrarJugador(j)) {
			System.out.println("Registrado correctamente.");
		}else {
			System.out.println("Ha habido un error al registrarse.");
		}
	}

	private static void iniciarSesion(DBConnection db) {
		boolean iniciado=false;
		String nombre = "";
		String contrasenia = "";
		int opcion= 0;
		while(!iniciado) {
			nombre = Lector.leerCadena("Introduzca el nombre: ");
			contrasenia = Lector.leerCadena("Introduzca la contraseña: ");
			Jugador j = new Jugador(nombre, contrasenia);
			if(db.iniciarSesionJugador(j)) {
				System.out.println("Se ha iniciado sesión.");
				iniciado = true;
			}else {
				System.out.println("No se ha podido iniciar sesión.");
			}
		}
		
		while(opcion!=4) {
			menu2();
			opcion=Lector.leerEntero("¿Qué desea hacer?");
			tratarMenu2(opcion,db, nombre, contrasenia);
		}
		
		
		
		
	}

	private static void tratarMenu2(int opcion, DBConnection db, String nombre, String contrasenia) {
		switch(opcion) {
		case 1:
			registrarPalabra(db);
			break;
		case 2:
			jugar(db, nombre, contrasenia);
			break;
		case 3:
			mostrarPartidas(db,nombre, contrasenia);
			break;
		case 4:
			System.out.println("Has cerrado sesión.");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
		
	}

	private static void mostrarPartidas(DBConnection db, String nombre, String contrasenia) {
		int id_jugador = db.obtencionIdJugador(nombre,contrasenia);
		ArrayList<Partida> partidas = db.mostrarPartidas(id_jugador);
		for(Partida p : partidas) {
			System.out.println("Palabra: "+p.getPalabra());
			System.out.println("Fecha: "+p.getFecha());
			System.out.println("Intentos: "+p.getIntentos());
			if(p.isSuperado()) {
				System.out.println("Victoria");
			}else {
				System.out.println("Derrota");
			}
			
		}
		
	}

	private static void jugar(DBConnection db, String nombre, String contrasenia) {
		int intentos = 0;
		boolean victoria = false;

		String tematica = Lector.leerCadena("Introduce una temática: ");
		String dificultad = Lector.leerCadena("Introduce una dificultad: ");
		String palabra = db.jugar(tematica, dificultad).toUpperCase();
		System.out.println("La palabra cuenta con " + palabra.length() + " letras.");

		char[] letrasVacias = new char[palabra.length()];
		for (int i = 0; i < palabra.length(); i++) {
		    letrasVacias[i] = '_';
		}

		char[] letras = palabra.toCharArray();

		while (!victoria && intentos < 6) {
		    System.out.print("\nPalabra: ");
		    for (char c : letrasVacias) System.out.print(c + " ");
		    
		    char letra = Character.toUpperCase(Lector.leerCaracter("\nIntroduce una letra: "));
		    boolean acierto = false;

		    for (int i = 0; i < letras.length; i++) {
		        if (letra == letras[i] && letrasVacias[i] == '_') {
		            letrasVacias[i] = letra;
		            acierto = true;
		        }
		    }

		    if (!acierto) {
		        intentos++;
		        System.out.println("Letra incorrecta. Te quedan " + (6 - intentos) + " intentos.");
		    } else {
		        System.out.println("¡Bien! Has acertado una letra.");
		    }

		    // Comprobamos si ya no quedan guiones bajos
		    victoria = true;
		    for (char c : letrasVacias) {
		        if (c == '_') {
		            victoria = false;
		            break;
		        }
		    }
		}

		System.out.println("\nPalabra final: " + String.valueOf(letras));
		if (victoria) {
		    System.out.println("¡Felicidades! Has adivinado la palabra con " + intentos + " errores.");
		} else {
		    System.out.println("¡Has perdido! No has conseguido adivinar la palabra.");
		}
		int id_palabra = db.obtenerPalabraId(palabra);
		int id_jugador = db.obtencionIdJugador(nombre, contrasenia);
		if(db.guardarPartida(id_jugador, id_palabra, intentos, victoria)) {
			System.out.println("Se ha guardado la partida correctamente.");
		}else {
			System.out.println("Ha habido un fallo al guardar la partida.");
		}
		
	}

	private static void registrarPalabra(DBConnection db) {
		String palabra = Lector.leerCadena("Introduce la palabra: ");
		String tematica = Lector.leerCadena("Introduzca al temática de la palabra: ");
		String dificultad = Lector.leerCadena("Introduce la dificultad de la palabra");
		if(db.agregarPalabra(palabra, tematica, dificultad)) {
			System.out.println("Se ha registrado la palabra correctamente.");
		}else {
			System.out.println("Ha habido un error al registrar la palabra.");
		}
		
	}

	private static void menu2() {
		System.out.println("------Menu secundario-------");
		System.out.println("1. Registrar palabra.");
		System.out.println("2. Jugar.");
		System.out.println("3. Mostrar mis partidas.");
		System.out.println("4. Cerrar sesión.");
		
	}

	private static void menu() {
		System.out.println("------Menu principal-------");
		System.out.println("1. Iniciar sesión.");
		System.out.println("2. Registrarse.");
		System.out.println("3. Cerrar.");
	}


	

	
}
