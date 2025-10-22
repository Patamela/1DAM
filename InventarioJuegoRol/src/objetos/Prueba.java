package objetos;

import java.util.Scanner;

public class Prueba {

	

	 static Scanner numero = new Scanner(System.in);
	 static Scanner letra = new Scanner(System.in);
	 
	public static void main(String[] args) {
		 
		int opcion = 0;
		Inventario inv1 = new Inventario();
		objetosPredeterminado(inv1);
		 while(opcion!=6) {
			 menu();
			 System.out.println("¿Qué desea hacer?");
			 opcion=numero.nextInt();
			 tratarmenu(opcion, inv1);
		 }
	
		 
	}

	private static void objetosPredeterminado(Inventario inventario1) {
		Objeto ob1 = new Objeto("Excalibur", "Arma", 50,"Espada empuñada por el Rey Arturo."); 
		Objeto ob2 = new Objeto("Barbarian", "Pocion", 20,"Espada empuñada por el Rey Arturo.");
		Objeto ob3 = new Objeto("Casilla", "Arma", 50,"Espada empuñada por el Rey Arturo.");
		
		inventario1.agregarObjeto(ob1); 
		inventario1.agregarObjeto(ob2); 
		inventario1.agregarObjeto(ob3); 
	}

	private static void tratarmenu(int opcion, Inventario inv1) {
		switch(opcion) {
		case 1:
			agregarObjetos(inv1);
			break;
		case 2:
			eliminarObjetos(inv1);
			break;
		case 3:
			listarObjetos(inv1);
			break;
		case 4:
			consultarObjetos(inv1);
			break;
		case 5:
			mostrarPesoTotal(inv1);
			break;
		case 6:
			System.out.println("Saliendo del inventario.");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
		
	}

	private static void mostrarPesoTotal(Inventario inv1) {
		System.out.println("Peso total en el inventario: "+inv1.calculoPesoTotal());
		
	}

	private static void consultarObjetos(Inventario inv1) {
		String categoria;
		System.out.println("Escriba la categoría que quiera filtrar:");
		categoria = letra.nextLine();
		inv1.filtroObjetosCategoria(categoria);
		
	}

	private static void listarObjetos(Inventario inv1) {
		inv1.listaObjetos();
		
	}

	private static void eliminarObjetos(Inventario inv1) {
		String nombre;
		System.out.println("Introduce el nombre del objeto que desea eliminar:");
		nombre = letra.nextLine();
		boolean eliminar = inv1.eliminarObjeto(nombre);
		
		if(eliminar==true) {
			System.out.println("El objeto se ha eliminado correctamente.");
		}else {
			System.out.println("No se ha encontrado ese objeto.");
		}
	}

	private static void agregarObjetos(Inventario inv1) {
		String nombre;
		String categoria;
		float peso;
		String descripcion;
		
		System.out.println("Escriba el nombre del objeto:");
		nombre = letra.nextLine();
		System.out.println("Escriba la categoría del objeto:");
		categoria = letra.nextLine();
		System.out.println("Escriba el peso del objeto:");
		peso =numero.nextFloat();
		System.out.println("Escriba una breve descripción del objeto:");
		descripcion = letra.nextLine();
		
		Objeto obj = new Objeto(nombre, categoria, peso, descripcion);
		boolean agregado = inv1.agregarObjeto(obj);
		
		if(agregado==true) {
			System.out.println("El objeto se ha agregado correctamente.");
		}else {
			System.out.println("El inventario está lleno.");
		}
		
	}

	private static void menu() {
		System.out.println("---------------------------");
		System.out.println("1.Agregar un nuevo objeto.");
		System.out.println("2.Eliminar un objeto.");	
		System.out.println("3.Lista de los objetos.");
		System.out.println("4.Consultar objetos por categoría.");
		System.out.println("5.Mostrar el peso total del inventario.");
		System.out.println("6.Salir.");
		}

}
