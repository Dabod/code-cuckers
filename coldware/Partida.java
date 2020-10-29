package coldware;

import java.util.Scanner;

public class Partida {

	// Atributos
	private String ganadorPartida;
	private int opcionMenu;
	private String nombreEquipo;
	private int ronda;
	private int [][] matDefAtk= new int [6][6];

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
		
		defAtacar(matDefAtk);

	}
	
	public int defAtacar( int matDefAtk [][] ) {
		int x=0;
		
		
		return 0;
		
	}
	

	public void reglasJuego() {
		System.out.println("Aqui van las reglas del juego.");
		System.out.println("");
		System.out.println("");
	}

	public void infoJuego() {
		System.out.println("Aqui van la info del juego.");
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
