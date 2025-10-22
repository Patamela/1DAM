package caja;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main009 {
	
	static Scanner numero = new Scanner(System.in);
	static Scanner letra = new Scanner(System.in);

	public static void main(String[] args) {
		TreeMap<Producto, Double> inventario = new TreeMap<>();
		int opcion = 0;
		
		
		while(opcion!=5) {
			menu();
			System.out.println("¿Qué desea hacer?");
			opcion = numero.nextInt();
			tratarMenu(opcion, inventario);
		}

	}

	

	private static void tratarMenu(int opcion, TreeMap<Producto, Double> inventario) {
		switch(opcion) {
		case 1:
			agregarProducto(inventario);
			break;
		case 2:
			actualizarPrecio(inventario);
			break;
		case 3:
			eliminarProducto(inventario);
			break;
		case 4:
			mostrarProductos(inventario);
			break;
		case 5:
			System.out.println("Saliendo del programa.");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
		
	}



	private static void eliminarProducto(TreeMap<Producto, Double> inventario) {
		System.out.println("Introduce el nombre del producto que desee eliminar: ");
		String nombre = letra.nextLine();
		for(Entry<Producto, Double> eliminar : inventario.entrySet()) {
			if(eliminar.getKey().getNombre().equalsIgnoreCase(nombre)) {
				inventario.remove(eliminar.getKey());
			}
		}
		
	}



	private static void mostrarProductos(TreeMap<Producto, Double> inventario) {
		for(Entry<Producto, Double> listar : inventario.entrySet()) {
			System.out.println(listar.getKey()+": "+listar.getValue());
		}
		
	}



	private static void actualizarPrecio(TreeMap<Producto, Double> inventario) {
		System.out.println("¿A qué producto quieres actualizar el precio?");
		String nombre = letra.nextLine();
		System.out.println("Introduzca el nuevo precio del producto: ");
		double precio = numero.nextDouble();
		Producto p2 = new Producto(nombre);
		
		if(inventario.containsKey(p2)) {
			inventario.put(p2, precio);
		}else {
			System.out.println("No existe ese producto.");
		}
		
	}



	private static void agregarProducto(TreeMap<Producto, Double> inventario) {
		System.out.println("Introduce el nombre del producto: ");
		String nombre = letra.nextLine();
		System.out.println("Introduce el precio del producto: ");
		double precio = numero.nextDouble();
		
		Producto p1 = new Producto(nombre);
		inventario.put(p1, precio);
		
	}



	private static void menu() {
		System.out.println("------------Menu-----------");
		System.out.println("1.Añadir un producto.");
		System.out.println("2.Actualizar precio.");
		System.out.println("3.Eliminar producto.");
		System.out.println("4.Mostrar productos.");
		System.out.println("5.Salir.");
		
	}

}
