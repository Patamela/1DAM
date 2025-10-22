package listas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main004 {
	
	static Scanner letra = new Scanner(System.in);
	static Scanner numero = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcion=0;
		LinkedList<Productos> lista = new LinkedList<>();
		
		while(opcion!=5) {
			menu();
			System.out.println("¿Qué desea hacer?");
			opcion=numero.nextInt();
			tratarMenu(opcion, lista);
		}
		
	}

	private static void tratarMenu(int opcion, LinkedList<Productos> lista) {
		switch(opcion) {
		case 1:
			agregarProducto(lista);
			break;
		case 2:
			eliminarProducto(lista);
			break;
		case 3:
			buscarProducto(lista);
			break;
		case 4:
			listarProductos(lista);
			break;
		case 5:
			System.out.println("Saliendo del programa.");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
		
	}

	private static void buscarProducto(LinkedList<Productos> lista) {
		System.out.println("Introduzca el nombre del producto que desea buscar: ");
		String nombre = letra.nextLine();
		
		Iterator<Productos> it = lista.iterator();
		
		for(int i=0; i<lista.size(); i++) {
			Productos busqueda = it.next();
			if(busqueda.getNombre().equals(nombre)) {
				System.out.println(lista.get(i));
			}
		}
		
	}

	private static void listarProductos(LinkedList<Productos> lista) {
		for(Productos listar : lista) {
			System.out.println(listar);
		}
		
	}

	private static void eliminarProducto(LinkedList<Productos> lista) {
		System.out.println("Introduce el nombre del producto para eliminarlo: ");
		String nombre = letra.nextLine();
		
		Iterator<Productos> it = lista.iterator();
		
		//usar bucle for
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre)) {
				lista.remove(i);
				i=lista.size();
			}
		}
		/*while(it.hasNext()) {
			Productos eliminar = it.next();
			if(eliminar.getNombre().equals(nombre)) {
				it.remove();
			}
			
		}*/
		
	}

	private static void agregarProducto(LinkedList<Productos> lista) {
		System.out.println("Introduce el nombre del producto: ");
		String nombre = letra.nextLine(); 
		System.out.println("Introduce la categoría del producto: ");
		String categoria = letra.nextLine();
		System.out.println("Introduce el precio del producto: ");
		double precio = numero.nextDouble();
		
		Productos p1 = new Productos(nombre, categoria, precio);
		lista.add(p1);
		
	}

	private static void menu() {
		System.out.println("-------------Menu-------------");
		System.out.println("1.Agregar producto.");
		System.out.println("2.Eliminar producto.");
		System.out.println("3.Buscar producto.");
		System.out.println("4.Listar productos.");
		System.out.println("5.Salir.");
		
	}

}
