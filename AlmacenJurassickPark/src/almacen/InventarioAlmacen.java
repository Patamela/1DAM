package almacen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InventarioAlmacen {

	public static void main(String[] args) {
		Scanner valor = new Scanner(System.in);
		Scanner letra = new Scanner(System.in);

		String[] productos = new String[30];
		int opcion = 0;
		String nombre = "";
		boolean salida = true;

		do {
			menu();
			try {
				System.out.println("¿Qué operación desea realizar?");
				opcion = valor.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("El caracter no es válido.");
				valor.next();
			}
			tratarmenu(productos, opcion, valor, letra, nombre);
		} while (salida = true);

	}

	private static void tratarmenu(String[] productos, int opcion, Scanner valor, Scanner letra, String nombre) {

		switch (opcion) {
		case 1:
			agregar(productos, opcion, valor, letra);
			break;
		case 2:
			eliminar(productos, opcion, valor, letra, nombre);
			break;
		case 3:
			buscar(productos, opcion, valor, letra, nombre);
			break;
		case 4:
			inventario(productos);
			break;
		default:
			break;
		}

	}

	private static void inventario(String[] productos) {
		for (int i = 0; i < productos.length; i++) {
			System.out.print(productos[i] + " ");
			if ((i + 1) % 10 == 0) {
				System.out.println("");
			}
		}

	}

	private static void buscar(String[] productos, int opcion, Scanner valor, Scanner letra, String nombre) {
		System.out.println("¿Qué producto quiere buscar?");
		nombre = letra.nextLine();

		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null && productos[i].equalsIgnoreCase(nombre) == true) {
				System.out.println("El producto que buscaba esta en la posicion " + (i + 1) + ".");
			}
		}

	}

	private static void eliminar(String[] productos, int opcion, Scanner valor, Scanner letra, String nombre) {
		System.out.println("¿Qué producto quiere eliminar?");
		nombre = letra.nextLine();

		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null && productos[i].equalsIgnoreCase(nombre) == true) {
				productos[i] = "null";
			}
		}

	}

	private static void agregar(String[] productos, int opcion, Scanner valor, Scanner letra) {
		boolean terminar = true;

		do {
			try {
				System.out.println("¿Cuántos productos desea almacenar?");
				opcion = valor.nextInt();
				if (opcion > 0 && opcion < 30) {
					terminar = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("El caracter no es válido.");
				valor.next();
			}
		} while (terminar);

		for (int i = 0; i < opcion; i++) {
			System.out.println("Introduzca el nombre del producto:");
			productos[i] = letra.nextLine();

		}
	}

	private static void menu() {
		System.out.println("-------------------------");
		System.out.println("1.Agregar un producto.");
		System.out.println("2.Eliminar un producto.");
		System.out.println("3.Buscar un producto.");
		System.out.println("4.Mostrar inventario.");

	}

}
