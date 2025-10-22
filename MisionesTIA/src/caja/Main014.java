package caja;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main014 {

	static Scanner numero = new Scanner(System.in);
	static Scanner letra = new Scanner(System.in);
	
	public static void main(String[] args) {
			TreeSet<Mision> misiones = new TreeSet<>();
			int opcion = 0;
			
			while(opcion!=4) {
				menu();
				System.out.println("¿Qué desea hacer?");
				opcion=numero.nextInt();
				tratarMenu(opcion, misiones);
			}

	}

	private static void tratarMenu(int opcion, TreeSet<Mision> misiones) {
		switch(opcion) {
		case 1:
			agregarMision(misiones);
			break;
		case 2:
			eliminarMision(misiones);
			break;
		case 3:
			mostrarMisiones(misiones);
			break;
		case 4:
			System.out.println("Saliendo del programa.");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
		
	}

	private static void mostrarMisiones(TreeSet<Mision> misiones) {
		System.out.println(misiones);
		
	}

	private static void eliminarMision(TreeSet<Mision> misiones) {
		System.out.println("Introduzca el nombre de la misión que quiere eliminar: ");
		String nombre = letra.nextLine();
		
		Iterator it = misiones.iterator();
		
		while(it.hasNext()) {
			Mision eliminar = (Mision) it.next();
			if(eliminar.getNombre().equals(nombre)) {
				it.remove();
			}
		}
		
		
	}

	private static void agregarMision(TreeSet<Mision> misiones) {
		System.out.println("Introduzca el nombre de la misión: ");
		String nombre = letra.nextLine();
		System.out.println("Introduzca el nivel de prioridad(ALTA, MEDIA, BAJA): ");
		String prioridad = letra.nextLine();
		
		
		Mision m1 = new Mision(nombre, prioridad);
		misiones.add(m1);
		
	}

	private static void menu() {
		System.out.println("-----------Menu------------");
		System.out.println("1.Añadir nueva misión.");
		System.out.println("2.Eliminar una misión.");
		System.out.println("3.Mostrar todas las misiones.");
		
		
	}

}
