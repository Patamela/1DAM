package caja;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main010 {
	
	static Scanner numero = new Scanner(System.in);
	static Scanner letra = new Scanner(System.in);
	
	public static void main(String[] args) {
		LinkedHashMap<String, String> usuarios = new LinkedHashMap<>();
		int opcion=0;
		
		
		while(opcion!=5) {
			menu();
			System.out.println("¿Qué deseas hacer?");
			opcion=numero.nextInt();
			tratarMenu(opcion, usuarios);
		}
	}

	private static void tratarMenu(int opcion, LinkedHashMap<String, String> usuarios) {
		switch(opcion) {
		case 1:
			crearUsuario(usuarios);
			break;
		case 2:
			iniciarSesion(usuarios);
			break;
		case 3:
			eliminarUsuarios(usuarios);
			break;
		case 4:
			mostrarUsuarios(usuarios);
			break;
		case 5:
			System.out.println("Saliendo del programa.");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
		
	}

	private static void mostrarUsuarios(LinkedHashMap<String, String> usuarios) {
		if(usuarios.isEmpty()) {
			System.out.println("No hay ningún usuario registrado.");
		}else {
			for(Entry<String, String> u : usuarios.entrySet()) {
				System.out.println(u.getKey()+": "+u.getValue());
			}
		}
		
	}

	private static void eliminarUsuarios(LinkedHashMap<String, String> usuarios) {
		System.out.println("Introduzca el nombre del producto que desee eliminar: ");
		String nombre= letra.nextLine();
		
		if(usuarios.containsKey(nombre)) {
			usuarios.remove(nombre);
		}else {
			System.out.println("No hay ningún usuario con ese nombre.");
		}
		
	}

	private static void iniciarSesion(LinkedHashMap<String, String> usuarios) {
		if(usuarios.isEmpty()) {
			System.out.println("No hay usuarios registrados.");
		}else {
		
		System.out.println("¿Con qué usuario quiere iniciar sesión?");
		String nombre = letra.nextLine();
		
		if(usuarios.containsKey(nombre)) {
			System.out.println("Has iniciado sesión con "+nombre);
		}else {
			System.out.println("No hay ningún usuario con ese nombre.");
		}
	}
}

	private static void crearUsuario(LinkedHashMap<String, String> usuarios) {
		System.out.println("Introduzca el nombre de usuario: ");
		String nombre = letra.nextLine();
		System.out.println("Introduzca la contraseña: ");
		String contrasenia = letra.nextLine();
		
		usuarios.put(nombre, contrasenia);
		
	}

	private static void menu() {
		System.out.println("------------Menu------------");
		System.out.println("1.Registrar usuario.");
		System.out.println("2.Iniciar sesión.");
		System.out.println("3.Eliminar usuario.");
		System.out.println("4.Mostrar todos los ususarios.");
		System.out.println("5.Salir.");
		
	}

}
