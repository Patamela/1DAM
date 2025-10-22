package juegoAhorcado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lector {
	public static String leerCadena(String pregunta) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String respuesta="";
		boolean valido = false;
		if(!valido) {
			System.out.println(pregunta+"");
			try {
				respuesta=br.readLine();
				valido=true;
			} catch (IOException e) {
				System.out.println("Ha habido un error al introducir su respuesta, intetelo de nuevo");
			}	
		}
		return respuesta;
	}
	
	public static int leerEntero(String pregunta) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int respuesta=0;
		boolean valido = false;
		if(!valido) {
			System.out.println(pregunta+"");
			try {
				respuesta=Integer.parseInt(br.readLine());
				valido=true;
			} catch (IOException e) {
				System.out.println("Ha habido un error al introducir su respuesta, intetelo de nuevo");
			}	
		}
		return respuesta;
	}
	
	public static boolean leerBooleano(String pregunta) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean booleano =false;
		boolean valido = false;
		if(!valido) {
			System.out.println(pregunta+"");
			try {
				String respuesta=br.readLine();
				if(respuesta.equalsIgnoreCase("si")) {
					booleano = true;
					valido=true;
				}else if(respuesta.equalsIgnoreCase("no")){
					booleano = false;
					valido=true;
				}
			} catch (IOException e) {
				System.out.println("Ha habido un error al introducir su respuesta, intetelo de nuevo");
			}	
		}
		return booleano;
	}
	
	public static char leerCaracter(String pregunta) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char letra = '\u0000';
		boolean valido = false;

		while (!valido) {
			try {
				System.out.println(pregunta + ": ");
				String linea = reader.readLine();

				if (linea != null && linea.length() == 1) {
					letra = linea.charAt(0);
					valido = true;
				} else {
					System.out.println("Por favor, ingresa solo un carácter.");
				}

			} catch (IOException e) {
				System.out.println("Error al leer la entrada. Intenta nuevamente.");
			}
		}
		return letra;
	}
}
