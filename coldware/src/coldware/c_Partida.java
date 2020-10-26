package coldware;

import java.util.Scanner;

public class c_Partida {

	// Atributos
	private String ganadorPartida;
	private int opcionMenu;

	// Objetos
	Scanner teclado = new Scanner(System.in);

	c_Planeta planeta1 = new c_Planeta();
	c_Planeta planeta2 = new c_Planeta();
	c_Planeta planeta3 = new c_Planeta();
	c_Planeta planeta4 = new c_Planeta();
	c_Planeta planeta5 = new c_Planeta();

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

	public void iniciarPartida() {
		// jugar menu.
		System.out.println("¡Partida iniciada!");
		System.out.println(planeta1.getVidas());

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