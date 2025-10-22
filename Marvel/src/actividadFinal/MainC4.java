package actividadFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MainC4 {

	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		int opcion = 0;
		while(opcion!=9) {
			menu();
			opcion = Lector.leerEntero("¿Qué desea hacer?");
			tratarMenu(opcion,db);
		}

	}

	private static void tratarMenu(int opcion,DBConnection db) {
		switch(opcion) {
		case 1:
			agregarPersonaje(db);
			break;
		case 2:
			eliminarPersonaje(db);
			break;
		case 3:
			modificarPersonaje(db);
			break;
		case 4:
			listarPersonajes(db);
			break;
		case 5:
			agregarBatalla(db);
			break;
		case 6:
			listarBatallas(db);
			break;
		case 7:
			listarBatallasGanadas(db);
			break;
		case 8:
			listarBatallasPerdidas(db);
			break;
		case 9:
			System.out.println("Saliendo del programa...");
			break;
		default:
			System.out.println("No hay más opciones.");
		}
	}	

	private static void listarBatallasGanadas(DBConnection db) {
		int id = Lector.leerEntero("Introduzca la id del personaje que desee ver sus batallas ganadas: ");
		
		ArrayList<String> batallas = db.listarTodasBatallasGanador(id);
		for(String b : batallas) {
			System.out.println(b);
		}
		
	}
	
	private static void listarBatallasPerdidas(DBConnection db) {
		int id = Lector.leerEntero("Introduzca la id del personaje que desee ver sus batallas perdidas: ");
		
		ArrayList<String> batallas = db.listarTodasBatallasPerdedor(id);
		for(String b : batallas) {
			System.out.println(b);
		}
		
	}

	private static void listarBatallas(DBConnection db) {
		ArrayList<String> batallas = db.listarTodasBatallas();
		for(String b : batallas) {
			System.out.println(b);
		}
		
	}

	private static void agregarBatalla(DBConnection db) {
		int salir = 0;
		String fecha = Lector.leerCadena("Ingrese la fecha de la batalla(dd-mm-yyyy): ");
		String lugar = Lector.leerCadena("Ingrese el lugar donde sucede la batalla: ");
		LocalDate fechaTransformada = transformarFecha(fecha);
		int heroe = 0;
		int villano = 0;
		while (salir != 2) {
			salir = 0;
			heroe = Lector.leerEntero("¿Qué héroe está en esta batalla? Introduzca su id: ");
			villano = Lector.leerEntero("¿Qué villano está en esta batalla? Introduzca su id: ");

			if (db.verficarPersonaje(heroe).equalsIgnoreCase("heroe")) {
				salir += 1;
			} else {
				System.out.println("La id introducida del héroe no es correcta.");
			}

			if (db.verficarPersonaje(villano).equalsIgnoreCase("villano")) {
				salir += 1;
			} else {
				System.out.println("La id introducida del villano no es correcta.");
			}
		}
		Batalla b = new Batalla(fechaTransformada, lugar);
		if(accionBatalla()==1) {
			b.setGanador(heroe);
			b.setPerdedor(villano);
		}else if(accionBatalla()==2) {
			b.setGanador(villano);
			b.setPerdedor(heroe);
		}
		
		System.out.println("El ganador de esta batalla ha sido: "+b.getGanador());
		System.out.println("El perdedor de esta batalla ha sido: "+b.getPerdedor());
		
		if(db.ingresarBatallas(b)) {
			System.out.println("Se ha ingresado la batalla correctamente.");
		}else {
			System.out.println("Ha ahbido un error al ingresar la batalla.");
		}
		
		
	}

	private static int accionBatalla() {
		Random r = new Random();
		int poderHeroe = r.nextInt(100)+1;
		int poderVillano = r.nextInt(100)+1;
		if(poderHeroe>poderVillano) {
			return 1;
		}else if(poderVillano>poderHeroe) {
			return 2;
		}else {
			return 0;
		}
		
		
	}

	private static LocalDate transformarFecha(String fecha) {
		int dia = Integer.parseInt(fecha.substring(0,fecha.indexOf("-")));
		int mes = Integer.parseInt(fecha.substring(fecha.indexOf("-")+1, fecha.lastIndexOf("-")));
		int anio = Integer.parseInt(fecha.substring(fecha.lastIndexOf("-")+1));
		return LocalDate.of(anio, mes, dia);
	}

	private static void listarPersonajes(DBConnection db) {
		ArrayList<String> personajes = db.listarTodosPersonajes();
		for(String p : personajes) {
			System.out.println(p);
		}
		
	}

	private static void modificarPersonaje(DBConnection db) {
		Personaje p = new Personaje();
		boolean modificado = false;
		
		int id = Lector.leerEntero("Introduzca la id del personaje que desea modificar: ");
		
		String nombre=Lector.leerCadena("Introduzca el nuevo nombre del personaje: ");
		String poderes=Lector.leerCadena("Introduce los nuevos poderes del personaje:");
		boolean mascara=Lector.leerBooleano("¿Este personaje tiene máscara?(si o no): ");
		boolean capa=Lector.leerBooleano("¿Este personaje tiene capa?(si o no)");
		String tipo=Lector.leerCadena("¿El personaje es un heroe o un villano?");
		
		if(tipo.equalsIgnoreCase("heroe")) {
			p = new Personaje(nombre,poderes,mascara,capa,Rol.HEROE);
			modificado=true;
		}else if(tipo.equalsIgnoreCase("villano")){
			p = new Personaje(nombre,poderes,mascara,capa,Rol.VILLANO);
			modificado=true;
		}
		
		if(modificado) {
			if(db.modificaPersonaje(id, p)) {
				System.out.println("Personaje modificado perfectamente.");
			}else {
				System.out.println("Ha habido un fallo al modificar el personaje.");
			}
		}else {
			System.out.println("Tiene que poner bien el campo de tipo de personaje.");
		}
		
		
		
	}

	private static void eliminarPersonaje(DBConnection db) {
		int id = Lector.leerEntero("Introduzca la id del personaje que desea eliminar: ");
		if(db.eliminarPersonaje(id)) {
			System.out.println("El personaje se ha eliminado correctamente.");
		}else {
			System.out.println("Ha habido un fallo al eliminar un personaje.");
		}
		
	}

	private static void agregarPersonaje(DBConnection db) {
		Personaje p = new Personaje();
		boolean creado = false;
		
		String nombre=Lector.leerCadena("Introduzca el nombre del personaje: ");
		String poderes=Lector.leerCadena("¿Qué poderes tiene el personaje?");
		boolean mascara=Lector.leerBooleano("¿Este personaje tiene máscara?(si o no): ");
		boolean capa=Lector.leerBooleano("¿Este personaje tiene capa?(si o no)");
		String tipo=Lector.leerCadena("¿El personaje es un heroe o un villano?");
		
		if(tipo.equalsIgnoreCase("heroe")) {
			p = new Personaje(nombre,poderes,mascara,capa,Rol.HEROE);
			creado = true;
			
		}else if(tipo.equalsIgnoreCase("villano")){
			p = new Personaje(nombre,poderes,mascara,capa,Rol.VILLANO);
			creado=true;
		}
		
		
		if (creado) {
			if (db.ingresarPersonaje(p)) {
				System.out.println("El personaje se ha creado correctamente.");
			} else {
				System.out.println("Ha habido un fallo al guardar el personaje.");
			}
		} else {
			System.out.println("Tiene que poner correctamente el campo de tipo de personaje.");
		}
	}

	private static void menu() {
		System.out.println("--------------------Menú-------------------");
		System.out.println("1.Agregar personaje.");
		System.out.println("2.Eliminar personaje.");
		System.out.println("3.Modificar personaje.");
		System.out.println("4.Listar todos los personajes.");
		System.out.println("5.Agregar batalla.");
		System.out.println("6.Listar todas las batallas.");
		System.out.println("7.Batallas donde ha ganado un personaje.");
		System.out.println("8.Batallas donde ha perdido un personaje.");
		System.out.println("9.Salir del programa.");
		System.out.println("____________________________________________");
	}

}
