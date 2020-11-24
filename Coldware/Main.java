import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcionMenu = -1;

		Scanner teclado = new Scanner(System.in);
		// Partida partida = new Partida();
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
		partida.parar(3000);

		while (opcionMenu != 0) {
			System.out.println("\n1 - Jugar\n");
			System.out.println("2 - Reglas del Juego\n");
			System.out.println("3 - Informaci�n\n");
			System.out.println("4 - Opciones Musica\n");
			System.out.println("0 - Salir");
			System.out.println("\nElige una opci�n del men� introduciendo el n�mero correspondiente:\n");
			opcionMenu = partida.intScanner();
			while (opcionMenu < 0 || opcionMenu > 4) {
				System.err.println(
						"!Opci�n invalida! Asegurate de escoger un n�mero correspondiente a alguna opci�n del men�.");

				System.out.println("\n1 - Jugar\n");
				System.out.println("2 - Reglas del Juego\n");
				System.out.println("3 - Informaci�n\n");
				System.out.println("4 - Opciones Musica\n");
				System.out.println("0 - Salir");
				System.out.println("\nElige una opci�n del men� introduciendo el n�mero correspondiente:\n");
				opcionMenu = partida.intScanner();
			}
			
			switch (opcionMenu) {
			case 1:
				partida.iniciarpartida2();
				break;
			case 2:
				partida.reglasJuego();
				break;
			case 3:
				partida.infoJuego();
				break;
			case 4:
				partida.opcionesReproductor();
				break;
			case 0:
				System.out.println("���ADI�S MUY BUENAS!!!");
				break;
			}
		}
		
		System.out.println("Fin del programa.");
		teclado.close();
	}
} // Nice