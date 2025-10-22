package actividadFinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lector {
	
	public static String leerCadena(String pregunta) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String respuesta = "";
		boolean valido = false;
		if(!valido) {
			System.out.print(pregunta+" ");
			try {
				respuesta = br.readLine();
				valido = true;
			} catch (IOException e) {
				System.out.println("Error al leer la entrada. Intenta nuevamente.");
			}
		}
		return respuesta;
	}
	
	public static int leerEntero(String pregunta) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numero=0;
		boolean valido=false;
		if(!valido) {
			System.out.print(pregunta+" ");
			try {
				numero=Integer.parseInt(br.readLine());
				valido=true;
			} catch (IOException e) {
				System.out.println("Error al leer la entrada. Intenta nuevamente.");
			}catch(NumberFormatException e) {
				System.out.println("Introduzca un número entero válido");
			}
		}
		return numero;
		
	}
	
	public static boolean leerBooleano(String pregunta) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String respuesta="";
		boolean booleano=false;
		boolean valido=false;
		if(!valido) {
			System.out.print(pregunta+" ");
			try {
				respuesta=br.readLine();
				if(respuesta.equalsIgnoreCase("si")) {
					booleano = true;
					valido=true;
				}else if(respuesta.equalsIgnoreCase("no")) {
					booleano = false;
					valido=true;
				}
				
			} catch (IOException e) {
				System.out.println("Error al leer la entrada. Intenta nuevamente.");
			}
		}
		return booleano;
		
	}
}
