package coldware;

import java.util.Scanner;

public class Partida {

	// Atributos
	private String ganadorPartida;
	private int opcionMenu;
	private String nombreEquipo;
	private int ronda;
	private int[][] matDefAtk = new int[6][6];

	// Objetos
	Scanner teclado = new Scanner(System.in);

	Planeta equipo1 = new Planeta();
	Planeta equipo2 = new Planeta();
	Planeta equipo3 = new Planeta();
	Planeta equipo4 = new Planeta();
	Planeta equipo5 = new Planeta();
	Planeta equipos[] = { null, equipo1, equipo2, equipo3, equipo4, equipo5 };

	// Constructor Partida

	// Metodos
	public int menu(int opcionMenu) {
		this.opcionMenu = 0;

		System.out.println("\n1 - Jugar\n");
		System.out.println("2 - Reglas del Juego\n");
		System.out.println("3 - Información\n");
		System.out.println("4 - Opciones Musica\n");
		System.out.println("0 - Salir");
		System.out.println("\nElige una opción del menú introduciendo el número correspondiente a continuación:\n");
		this.opcionMenu = teclado.nextInt();

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

		return this.opcionMenu;
	}

	public int getOpcionMenu() {
		return opcionMenu;
	}

	public void setOpcionMenu(int nuevaOpMenu) {
		System.out.println(nuevaOpMenu);
		this.opcionMenu = nuevaOpMenu;

	}

	public void parar(int milisegons) {
		try {
			Thread.sleep(milisegons);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciarPartida() {
		// jugar menu.
		System.out.println("Iniciando partida en...");
		parar(1000);
		System.out.println("3...");
		parar(1000);
		System.out.println("2...");
		parar(1000);
		System.out.println("1...");
		parar(1000);
		System.out.println("¡Partida iniciada!");
		// System.out.println(planeta1.getVidas());
		parar(2000);
		System.out.println("Introduce el nombre de los equipos: ");
		for (int x = 1; x <= 5; x++) {
			System.out.println("Equipo " + x + ": ");

			nombreEquipo = teclado.nextLine();
			equipos[x].setNombreEquipo(nombreEquipo);

		}

		defAtacar(matDefAtk, equipos);

	}

	public int defAtacar(int matDefAtk[][], Planeta equipos[]) {
		Scanner teclado = new Scanner(System.in);
		int x = 0, y = 0;
		int atk = 0;
		int cc, cf, cEquipo = 0;

		for (cf = 0; cf < 6; cf++) {
			for (atk = 0; atk < 6; atk++) {

				do {

					System.out.print("introduce los atk/def");
					if (cEquipo == 0) {
						System.out.println("Turno equipo 1");
					}
					System.out.println("Aquien quieres atacar?");
					matDefAtk[0][1] = teclado.nextInt();
					
					if (matDefAtk[cf][atk] < 0 || matDefAtk[cf][atk] > 50) {
						System.err.println("Intoruce un valor correspondiente de 1 a 50 maximo.");
					}

				} while (matDefAtk[cf][atk] < 0 || matDefAtk[cf][atk] > 50);
				cEquipo++;

				if (cEquipo == 6) {
					System.out.println("Turno equipo 2:");

				}
				if (cEquipo == 12) {
					System.out.println("Turno equipo 3:");

				}

				if (cEquipo == 18) {
					System.out.println("Turno equipo 4:");

				}
				if (cEquipo == 24) {
					System.out.println("Turno equipo 5:");

				}

			}

		}

		for (cf = 0; cf < 6; cf++) {
			for (atk = 0; atk < 6; atk++) {
				System.out.print(" " + matDefAtk[cf][atk] + "  ");

			}

			System.out.print("\n");
		}

		return 0;

	}

	public void reglasJuego() {
		System.out.println("1- 5 Equipos con 200 de vida al principio de ronda");
		System.out.println("2- Cada Equipo tiene disponibles 50 misiles para atacar");
		System.out.println("3- Se puede atacar a diferentes equipos en un mismo turno");
		System.out.println("4- Los misiles de defensa cuentan x2");
		System.out.println("Ejemplo defensa--> si tenemos 50 misiles de ataque y nosotros");
		System.out.println("atacamos a un equipo con 40 misiles solo tendremos 5 misiles para defensa");

		System.out.println("Espera 25 segundos para volver al menu");
		parar(22000);
		System.out.println("Espera 3 segundos para volver al menu");
		parar(1000);
		System.out.println("Espera 2 segundos para volver al menu");
		parar(1000);
		System.out.println("Espera 1 segundo para volver al menu");
		parar(1000);

		menu(opcionMenu);

	}

	public void infoJuego() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Aqui van la info del juego.");
		System.out.println("Versión");
		System.out.println("Contacto: marcvaldiviaprim99@gmail.com, guepardar@gmail.com");
		System.out.println("Autores: David Alba, Marc Valdivia");

		System.out.println("");

		System.out.println("Espera 10 segundos para volver al menu");
		parar(6000);
		System.out.println("Espera 4 segundos para volver al menu");
		parar(1000);
		System.out.println("Espera 3 segundos para volver al menu");
		parar(1000);
		System.out.println("Espera 2 segundos para volver al menu");
		parar(1000);
		System.out.println("Espera 1 segundo para volver al menu");
		parar(1000);

		menu(opcionMenu);
	}

	public void opcionesReproductor() {
		System.out.println("Desde aqui se podrá configurar el reproductor.");
	}

	public int checkVivos() {// Comprobarequiposvivos

		return 0;
	}

	public void mostrarGanador() {

	}

	public void finalizarPartida() {

	}

}