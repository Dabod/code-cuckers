package coldware;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcionMenu = 0;

		Scanner teclado = new Scanner(System.in);
		Partida partida = new Partida();

		System.out.println("Bienvenido/a a");
		System.out.println(" ___   _____ _____ _    ______   _    _  ___  ______   ___ ");
		System.out.println("|  _| /  __ \\  _  | |   |  _  \\ | |  | |/ _ \\ | ___ \\ |_  |");
		System.out.println("| |   | /  \\/ | | | |   | | | | | |  | / /_\\ \\| |_/ /   | |");
		System.out.println("| |   | |   | | | | |   | | | | | |/\\| |  _  ||    /    | |");
		System.out.println("| |   | \\__/\\ \\_/ / |___| |/ /  \\  /\\  / | | || |\\ \\    | |");
		System.out.println("| |_   \\____/\\___/\\_____/___/    \\/  \\/\\_| |_/\\_| \\_|  _| |");
		System.out.println("|___|                                                 |___|");
		System.out.println("                                                           ");

		System.out.println("\n1 - Jugar\n");
		System.out.println("2 - Reglas del Juego\n");
		System.out.println("3 - Información\n");
		System.out.println("4 - Opciones Musica\n");
		System.out.println("0 - Salir");
		System.out.println("\nElige una opción del menú introduciendo el número correspondiente a continuación:\n");
		opcionMenu = teclado.nextInt();

		while (opcionMenu < 0 || opcionMenu > 4) {
			System.err.println(
					"!Opción invalida! Asegurate de escoger un número correspondiente a alguna opción del menú.");

			System.out.println("\n1 - Jugar\n");
			System.out.println("2 - Reglas del Juego\n");
			System.out.println("3 - Información\n");
			System.out.println("4 - Opciones Musica\n");
			System.out.println("0 - Salir");
			System.out.println("\nElige una opción del menú introduciendo el número correspondiente a continuación:\n");
			opcionMenu = teclado.nextInt();

		}

		switch (opcionMenu) {
		case 1:
			partida.iniciarPartida();
			break;
		case 2:
			partida.reglasJuego();
			System.out.println("info");
			break;
		case 3:
			partida.infoJuego();
			System.out.println("infoooooooooooOOOOOOOO!!!!");
		case 4:
			partida.opcionesReproductor();
			System.out.println("opciones musiquilla");
			break;
		case 0:
			System.out.println("Adiós");
			break;
		}

	}
}
