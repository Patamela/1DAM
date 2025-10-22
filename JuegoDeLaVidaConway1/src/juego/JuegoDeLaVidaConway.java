package juego;


import java.util.Scanner;

public class JuegoDeLaVidaConway {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		

		int vivo = 1;
		int muerto = 0;

		int rondas = 0;
		int i = 1;
		
	
		

		System.out.println(
				"El Juego de la vida Conway \nElige un modo de juego: \n1. Básico. \n2. Aleatorio. \n3. Personalizado. \n4. Avanzado. \n--------------------------");
		int menu = entrada.nextInt();

		switch (menu) {
		case 1:
			System.out.println("---MODO BÁSICO---");
			System.out.println("Introduzca a continuacion una serie de diez numeros, las cuales,"
					+ " (0) serán celulas muertas y (1) serán celulas vivas.");

			int seriePrincipal = entrada.nextInt();

			int celda1 = seriePrincipal % 10;
			int celda2 = (seriePrincipal / 10) % 10;
			int celda3 = (seriePrincipal / 100) % 10;
			int celda4 = (seriePrincipal / 1000) % 10;
			int celda5 = (seriePrincipal / 10000) % 10;
			int celda6 = (seriePrincipal / 100000) % 10;
			int celda7 = (seriePrincipal / 1000000) % 10;
			int celda8 = (seriePrincipal / 10000000) % 10;
			int celda9 = (seriePrincipal / 100000000) % 10;
			int celda10 = (seriePrincipal / 1000000000) % 10;

			while (rondas < 10) {

				System.out.print("\n Turno " + (rondas + i) + ": ");

				int celda1Ronda = (celda2 == 0) ? (muerto) : (vivo);
				int celda2Ronda = (celda1 == celda3) ? (muerto) : (vivo);
				int celda3Ronda = (celda2 == celda4) ? (muerto) : (vivo);
				int celda4Ronda = (celda3 == celda5) ? (muerto) : (vivo);
				int celda5Ronda = (celda4 == celda6) ? (muerto) : (vivo);
				int celda6Ronda = (celda5 == celda7) ? (muerto) : (vivo);
				int celda7Ronda = (celda6 == celda8) ? (muerto) : (vivo);
				int celda8Ronda = (celda7 == celda9) ? (muerto) : (+vivo);
				int celda9Ronda = (celda8 == celda10) ? (muerto) : (vivo);
				int celda10Ronda = (celda9 == 0) ? (muerto) : (vivo);

				System.out.print(celda10Ronda + " " + celda9Ronda + " " + celda8Ronda + " " + celda7Ronda + " "
						+ celda6Ronda + " " + celda5Ronda + " " + celda4Ronda + " " + celda3Ronda + " "
						+ celda2Ronda + " " + celda1Ronda);

				celda1 = celda1Ronda;
				celda2 = celda2Ronda;
				celda3 = celda3Ronda;
				celda4 = celda4Ronda;
				celda5 = celda5Ronda;
				celda6 = celda6Ronda;
				celda7 = celda7Ronda;
				celda8 = celda8Ronda;
				celda9 = celda9Ronda;
				celda10 = celda10Ronda;

				rondas = rondas + i;
			}

			break;
		case 2:
			System.out.println("---MODO ALEATORIO---");
			
			
			int celda1Random = (int) (Math.random() * (1-0+1));
			int celda2Random = (int) (Math.random() * (1-0+1));
			int celda3Random = (int) (Math.random() * (1-0+1));
			int celda4Random = (int) (Math.random() * (1-0+1));
			int celda5Random = (int) (Math.random() * (1-0+1));
			int celda6Random = (int) (Math.random() * (1-0+1));
			int celda7Random = (int) (Math.random() * (1-0+1));
			int celda8Random = (int) (Math.random() * (1-0+1));
			int celda9Random = (int) (Math.random() * (1-0+1));
			int celda10Random = (int) (Math.random() * (1-0+1));
			
			
			System.out.println("La serie principal generada aleatoriamente es: "+celda10Random+""+celda9Random+""+celda8Random+""+celda7Random+""+celda6Random+""+celda5Random+""+celda4Random+""+celda3Random+""+celda2Random+""+celda1Random);

			while (rondas < 10) {
				System.out.print("\n Turno " + (rondas + i) + ": ");

				int celda1Ronda = (celda2Random == 0) ? (muerto) : (vivo);
				int celda2Ronda = (celda1Random == celda3Random) ? (muerto) : (vivo);
				int celda3Ronda = (celda2Random == celda4Random) ? (muerto) : (vivo);
				int celda4Ronda = (celda3Random == celda5Random) ? (muerto) : (vivo);
				int celda5Ronda = (celda4Random == celda6Random) ? (muerto) : (vivo);
				int celda6Ronda = (celda5Random == celda7Random) ? (muerto) : (vivo);
				int celda7Ronda = (celda6Random == celda8Random) ? (muerto) : (vivo);
				int celda8Ronda = (celda7Random == celda9Random) ? (muerto) : (+vivo);
				int celda9Ronda = (celda8Random == celda10Random) ? (muerto) : (vivo);
				int celda10Ronda = (celda9Random == 0) ? (muerto) : (vivo);

				System.out.print(celda10Ronda + " " + celda9Ronda + " " + celda8Ronda + " " + celda7Ronda + " "
						+ celda6Ronda + " " + celda5Ronda + " " + celda4Ronda + " " + celda3Ronda + " "
						+ celda2Ronda + " " + celda1Ronda);

				celda1Random = celda1Ronda;
				celda2Random = celda2Ronda;
				celda3Random = celda3Ronda;
				celda4Random = celda4Ronda;
				celda5Random = celda5Ronda;
				celda6Random = celda6Ronda;
				celda7Random = celda7Ronda;
				celda8Random = celda8Ronda;
				celda9Random = celda9Ronda;
				celda10Random = celda10Ronda;

				rondas = rondas + i;
			}

			break;
		case 3:
			System.out.println("---MODO PERSONALIZADO---");
			System.out.println("Introduzca la cantidad de ronda:");
			int cantidad = entrada.nextInt();

			System.out.println("Introduzca a continuacion una serie de diez numeros, las cuales,"
					+ " (0) serán celulas muertas y (1) serán celulas vivas");
			seriePrincipal = entrada.nextInt();

			celda1 = seriePrincipal % 10;
			celda2 = (seriePrincipal / 10) % 10;
			celda3 = (seriePrincipal / 100) % 10;
			celda4 = (seriePrincipal / 1000) % 10;
			celda5 = (seriePrincipal / 10000) % 10;
			celda6 = (seriePrincipal / 100000) % 10;
			celda7 = (seriePrincipal / 1000000) % 10;
			celda8 = (seriePrincipal / 10000000) % 10;
			celda9 = (seriePrincipal / 100000000) % 10;
			celda10 = (seriePrincipal / 1000000000) % 10;

			while (rondas < cantidad) {
				System.out.print("\n Turno " + (rondas + i) + ": ");

				int celda1Ronda = (celda2 == 0) ? (muerto) : (vivo);
				int celda2Ronda = (celda1 == celda3) ? (muerto) : (vivo);
				int celda3Ronda = (celda2 == celda4) ? (muerto) : (vivo);
				int celda4Ronda = (celda3 == celda5) ? (muerto) : (vivo);
				int celda5Ronda = (celda4 == celda6) ? (muerto) : (vivo);
				int celda6Ronda = (celda5 == celda7) ? (muerto) : (vivo);
				int celda7Ronda = (celda6 == celda8) ? (muerto) : (vivo);
				int celda8Ronda = (celda7 == celda9) ? (muerto) : (+vivo);
				int celda9Ronda = (celda8 == celda10) ? (muerto) : (vivo);
				int celda10Ronda = (celda9 == 0) ? (muerto) : (vivo);


				System.out.print(celda10Ronda + " " + celda9Ronda + " " + celda8Ronda + " " + celda7Ronda + " "
						+ celda6Ronda + " " + celda5Ronda + " " + celda4Ronda + " " + celda3Ronda + " "
						+ celda2Ronda + " " + celda1Ronda);

				celda1 = celda1Ronda;
				celda2 = celda2Ronda;
				celda3 = celda3Ronda;
				celda4 = celda4Ronda;
				celda5 = celda5Ronda;
				celda6 = celda6Ronda;
				celda7 = celda7Ronda;
				celda8 = celda8Ronda;
				celda9 = celda9Ronda;
				celda10 = celda10Ronda;

				rondas = rondas + i;
			}

			break;
		case 4:
			System.out.println("---MODO AVANZADO---");

			System.out.println("Introduzca a continuacion una serie de diez numeros, las cuales,"
					+ " (0) serán celulas muertas y (1) serán celulas vivas");
			seriePrincipal = entrada.nextInt();

			celda1 = seriePrincipal % 10;
			celda2 = (seriePrincipal / 10) % 10;
			celda3 = (seriePrincipal / 100) % 10;
			celda4 = (seriePrincipal / 1000) % 10;
			celda5 = (seriePrincipal / 10000) % 10;
			celda6 = (seriePrincipal / 100000) % 10;
			celda7 = (seriePrincipal / 1000000) % 10;
			celda8 = (seriePrincipal / 10000000) % 10;
			celda9 = (seriePrincipal / 100000000) % 10;
			celda10 = (seriePrincipal / 1000000000) % 10;

			while (rondas < 10) {
				System.out.print("\n Turno " + (rondas + i) + ": ");

				int celda1Ronda = (celda2 == celda10) ? (muerto) : (vivo);
				int celda2Ronda = (celda1 == celda3) ? (muerto) : (vivo);
				int celda3Ronda = (celda2 == celda4) ? (muerto) : (vivo);
				int celda4Ronda = (celda3 == celda5) ? (muerto) : (vivo);
				int celda5Ronda = (celda4 == celda6) ? (muerto) : (vivo);
				int celda6Ronda = (celda5 == celda7) ? (muerto) : (vivo);
				int celda7Ronda = (celda6 == celda8) ? (muerto) : (vivo);
				int celda8Ronda = (celda7 == celda9) ? (muerto) : (+vivo);
				int celda9Ronda = (celda8 == celda10) ? (muerto) : (vivo);
				int celda10Ronda = (celda9 == celda1) ? (muerto) : (vivo);

				System.out.print(celda10Ronda + " " + celda9Ronda + " " + celda8Ronda + " " + celda7Ronda + " "
						+ celda6Ronda + " " + celda5Ronda + " " + celda4Ronda + " " + celda3Ronda + " "
						+ celda2Ronda + " " + celda1Ronda);

				celda1 = celda1Ronda;
				celda2 = celda2Ronda;
				celda3 = celda3Ronda;
				celda4 = celda4Ronda;
				celda5 = celda5Ronda;
				celda6 = celda6Ronda;
				celda7 = celda7Ronda;
				celda8 = celda8Ronda;
				celda9 = celda9Ronda;
				celda10 = celda10Ronda;

				rondas = rondas + i;
			}
			break;

		}

	}

}
