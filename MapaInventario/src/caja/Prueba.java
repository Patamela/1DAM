package caja;

import java.util.Scanner;
import java.util.TreeMap;

public class Prueba {
	static Scanner numero = new Scanner(System.in);
	static Scanner letra = new Scanner(System.in);

	public static void main(String[] args) {
		TreeMap<Producto, Double> inventario = new TreeMap<>();
		
		
		System.out.println("Introduce el nombre del producto: ");
		String nombre = letra.nextLine();
		
		
		Producto p1 = new Producto(nombre);
		
		System.out.println("Introduce el precio del producto: ");
		double precio = numero.nextDouble();
		inventario.put(p1, precio);

	}

}
