package calculoconmatriz;

import java.util.Arrays;
import java.util.Scanner;

public class Matrices {

	public static void main(String[] args) {
		Scanner valor = new Scanner(System.in);

		int[][] matriz1 = new int[3][3];
		int[][] matriz2 = new int[3][3];
		int[][] matrizSuma = new int[3][3];
		
		/*MATRIZ 1*/
		for (int i = 0; i < matriz1.length; i++) {
			
			for (int j = 0; j < matriz1[i].length; j++) {
				System.out.println("Introduzca un número para la primera matríz: ");
				int numero = valor.nextInt();
				matriz1[i][j] = numero;
			}

		}
		System.out.println("Contenido de la primera matriz:");
		for (int i = 0; i <= matriz1.length - 1; i++) {
			
			
			for (int j = 0; j <= matriz1[i].length - 1; j++) {
				System.out.print(matriz1[i][j] + "\t");
			}
			System.out.println();
		}
		
		/*MATRIZ 2*/
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2[i].length; j++) {
				
				System.out.println("Introduzca un número para la segunda matríz:");
				int numero = valor.nextInt();
				
				matriz2[i][j] = numero;
			}
		}

		System.out.println("Contenido de la segunda matriz:");
		for (int i = 0; i <= matriz2.length - 1; i++) {
			for (int j = 0; j <= matriz2[i].length - 1; j++) {
				System.out.print(matriz2[i][j] + "\t");
			}
			System.out.println();
		}
		
		/*SUMA DE MATRICES*/
		for(int i=0; i<matriz1.length; i++) {
			for(int j=0; j<matriz1[i].length; j++) {
				matrizSuma[i][j]=matriz1[i][j]+matriz2[i][j];
				
			}
			
		}
		
		System.out.println("Suma de matrices:");
		for(int i=0; i<matriz1.length; i++) {
			for(int j=0; j<matriz1[i].length; j++) {
				System.out.print(matrizSuma[i][j]+"\t");
			}
			System.out.println();
		}

	}
}
