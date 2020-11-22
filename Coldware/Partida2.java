import java.util.ArrayList;
import java.util.Scanner;

// comprobar int partida1/main
public class Partida2 {
	private int cantidadEquipos;
	private int equiposMuertos = 0;
	private int numRonda;

	private ArrayList<Planeta> equipos = new ArrayList<Planeta>();

	public void iniciarpartida2() {

		int x;
		int tipoPlaneta = 0;
		boolean pocosEquipos;
		String nombre;

		Planeta guardarEquipo;

		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("Cuantos equipos van a jugar?");

			cantidadEquipos = intScanner();
			if (cantidadEquipos < 3) {

				System.out.println("Se necesita un minimo de 3 equipos.");
				pocosEquipos = true;

			} else {
				pocosEquipos = false;
			}

		} while (pocosEquipos);

		for (x = 0; x < cantidadEquipos; x++) {
			System.out.println("\nIntroduce el nombre del Equipo " + (x + 1) + ".");

			nombre = teclado.nextLine();

			for (x = 0; x < equipos.size(); x++) {
				while (equipos.get(x).getNombreEquipo().equals(nombre)) {
					System.out.println("Nombre en uso. Introduce un nombre único.");
					nombre = teclado.next();
				}

			}

			System.out.println("1) Planeta Normal:\n   200 de vida\n   50 misiles\n");
			System.out.println(
					"2) Planeta Rojo:\n   200 de vida\n   50 misiles\n   Ataques efectivos contra planeta verde (x2)\n   Poco efectivos contra planeta azul (/2)\n");
			System.out.println(
					"3) Planeta Azul:\n   200 de vida\n   50 misiles\n   Ataques efectivos contra planeta rojo (x2)\n   Poco efectivos contra planeta verde (/2)\n");
			System.out.println(
					"4) Planeta Verde:\n   200 de vida\n   50 misiles\n   Ataques efectivos contra planeta azul (x2)\n   Poco efectivos contra planeta rojo (/2)\n");
			System.out.println("5) Planeta Gaseoso:\n   400 de vida\n   10 base + 10 misiles por ronda.\n");
			System.out.println(
					"6) Planeta Enano:\n   100 de vida\n   50 misiles --> probabilidad de esquivar del 50%.\n");
			System.out.println("7) Planeta Berserker:\n   100 de vida\n   150 misiles, no puede defenderse.\n");
			System.out.println(
					"8) Planeta Oscuro:\n   200 de vida\n   50 misiles --> Si el objetivo atacado tiene menos del 20% de vida daño x2.\n");
			System.out.println(
					"9) Planeta Vegeta Super Saiyan 2:\n   100 de vida, +100 de vida extra por planeta en la partida.\n   30 misiles, +10 misiles extra por planeta en la partida.\n");
			System.out.println(
					"10) Planeta Nigromante:\n   175 de vida\n   40 misiles --> Cuando un equipo muere, se cura 40 puntos de vida y recibe +20 de ataque en forma de un 'planeta zombi'.\n");
			System.out.println("Selecciona un tipo de planeta:");

			tipoPlaneta = intScanner();
			guardarEquipo = (new Planeta(x, nombre, tipoPlaneta));
			equipos.add(guardarEquipo);

//			System.out.println(equipos.get(x).getTipoPlaneta());
//
//			System.out.println(equipos.get(x).getNombreEquipo());
//			System.out.println(equipos.get(x).getMisilesRonda());
//			System.out.println(equipos.get(x).getVidas());
		}

		partida();

	}

	public void partida() {
		int x;

		for (x = 0; x < equipos.size(); x++) { // Comprobamos si debemos activar la pasiva Planeta Vegeta
			equipos.get(x).pasivaVegeta(cantidadEquipos, equipos.get(x).getTipoPlaneta());
		}

		numRonda = 0;
		do {

			ronda();
			efectosRonda();
		} while (equipos.size() != 1 && equipos.size() != 0);
		if (equipos.size() == 1) {
			mostrarGanador();
		} else {
			empate();
		}
		finalizarPartida();

	}

	public void ronda() {
		int misilesEleccion;
		int x = 0, y = 0, cont = equipos.size();
		int opcion = 0;
		int tipoObjetivo; // Variable que guarda el numero del tipo del objetivo

		numRonda++;
		System.out.println("\n\nRONDA " + numRonda);
		for (x = 0; equipos.size() > x; x++) {

			equipos.get(x).resetMisiles(equipos.get(x).getTipoPlaneta());
			equipos.get(x).setPosicionEquipo(x);
			equipos.get(x).resetArrays();
			equipos.get(x).resetDefensa();

			if (equipos.get(x).getTipoPlaneta() == 10) {
				equipos.get(x).pasivaNigromante(equiposMuertos);
				equipos.get(x).resetMisiles(10);
				equiposMuertos = 0;
			}

			if (equipos.get(x).isVivo() == true) {

				System.out.println("\n-->TURNO DE " + equipos.get(x).getNombreEquipo() + "<--");
				while (equipos.get(x).getMisilesRonda() != 0) {
					if (equipos.get(x).getTipoPlaneta() == 5 && numRonda > 1) {
						System.out.println(equipos.get(x).getNombreMasTipo() + " crece...");
					}
					System.out.println("Misiles disponibles: " + equipos.get(x).getMisilesRonda() + ".\n");

					for (y = 0; y < equipos.size(); y++) {
						System.out.println("(" + y + ") " + equipos.get(y).getNombreMasTipo() + " ---> HP: "
								+ equipos.get(y).getVidas());
					}
					System.out.println("(" + cont + ") Misiles Restantes a defensa.\n");

					System.out.println("Introduce el numero del objetivo que quieres atacar o (" + (cont)
							+ ") para poner los misiles restantes a defensa");

					opcion = intScanner();

					// Comprobacion que no puedes atacarte a ti mismo
					while (opcion == equipos.get(x).getPosicionEquipo()) {
						System.out.println("No puedes atacarte a ti mismo ");
						opcion = intScanner();
					}

					while (opcion > cont || opcion < 0) { // Error opcion no valida
						System.out.println("¡Opcion no válida! Selecciona una opción de la lista.");
						opcion = intScanner();
					}

					if (opcion == cont) {// Defensa todo
						if (equipos.get(x).getTipoPlaneta() != 7) {

							equipos.get(x).defender(equipos.get(x).getMisilesRonda());
							equipos.get(x).usarMisiles(equipos.get(x).getMisilesRonda());
						} else {
							System.out.println("AAAAAAAAAAH! *Inserte musica de DOOM* (No te puedes defender)\n");
						}

					} else {
						equipos.get(x).introducirObjetivo(opcion);
						tipoObjetivo = equipos.get(opcion).getTipoPlaneta();

						do {
							System.out.println("¿Con cuantos misiles le vas a atacar?");
							misilesEleccion = intScanner();
							cantMisilesError(misilesEleccion, x);

						} while (misilesEleccion <= 0 || misilesEleccion > equipos.get(x).getMisilesRonda());

						equipos.get(x).usarMisiles(misilesEleccion);
						misilesEleccion = pasivaOscuro(x, opcion, misilesEleccion);
						equipos.get(x).ventajasColores(tipoObjetivo, misilesEleccion);
						System.out.println(misilesEleccion);
						equipos.get(x).introducirAtaque(misilesEleccion);
					}
				}

			}
		}
	}

	public void efectosRonda() {

		int x;

		System.out.println("\n\n<-- RESULTADOS DE LA RONDA -->");

		for (x = 0; x < equipos.size(); x++) {
			System.out.println("  ------------------------  ");
			if (equipos.get(x).getMisilesDefensa() != 0) {
				System.out.println(equipos.get(x).getNombreEquipo() + " se defiende con "
						+ equipos.get(x).getMisilesDefensa() + " misiles.");

			} else {
				System.out.println(equipos.get(x).getNombreEquipo() + " no se ha defendido.");
			}
			hacerAtaques(x);
		}

		eliminarEquipos();

	}

	public void hacerAtaques(int x) { // CREAR VARIABLE ATAQUE TOTAL PARA LA CORRECTA APLICACIÓN DE LA DEFENSA

		int y; // Equipo atacante
		int z; // Posicion de los arrays
		boolean noAtaque = true;

		for (y = 0; y < equipos.size(); y++) { // Recorre los posibles equipos atacantes

			for (z = 0; z < equipos.get(y).objetivos.size(); z++) { // Recorre el array objetivos

				if (equipos.get(y).objetivos.get(z) == x) { // Comprobamos si el equipo atacante esta atacando al equipo
															// con posicion x

					System.out.println("El equipo " + equipos.get(y).getNombreMasTipo() + " le ha atacado con "
							+ equipos.get(y).cantidadAtk.get(z) + " missiles");

					if (equipos.get(x).getTipoPlaneta() == 6 && equipos.get(x).planetaEnano() == 1) {
						System.out.println("Eres jodido matrix (esquivas todos los ataques)");

					} else {
						equipos.get(x).calcularDmg(equipos.get(y).cantidadAtk.get(z)); // Comprueba la cantidad del
																						// ataque y lo hace

					}

					noAtaque = false;

				}

			}
		}
		if (noAtaque) {
			System.out.println("Nadie le ha atacado... ");
		}
		System.out.println("  ------------------------  \n");
	}

	public void eliminarEquipos() { // EL ULTIMO EQUIPO SE ELIMINA Y EL PENULTIMO NO, AUNQUE ESTE MUERTO
		int x; // Recorre los equipos
		int y; // Recorre el array pElimin.
		int pElimin;
		// Guarda la posicion del equipo a eliminar desde el array equiposElimin.
		ArrayList<Integer> equiposElimin = new ArrayList<Integer>(); // Guarda la posición de los equipos eliminados.

		for (x = equipos.size() - 1; x >= 0; x--) {

			if (!equipos.get(x).isVivo()) {
				equiposElimin.add(x); // Guarda la posicion del equipo a eliminar en el
										// array equiposElimin.
				System.out.println("El equipo " + equipos.get(x).getNombreEquipo() + " ha sido eliminado.");
			}

		}

		for (y = 0; y < equiposElimin.size(); y++) {

			pElimin = equiposElimin.get(y);
			equipos.remove(pElimin);
			equiposMuertos++;
		}

	}

	public int cantMisilesError(int misilesEleccion, int x) {
		if (misilesEleccion <= 0) {
			System.out.println("¡No puedes atacar con 0 misiles o menos!");
		} else if (misilesEleccion > equipos.get(x).getMisilesRonda()) {
			System.out.println("Misiles insuficientes.");
		}
		return misilesEleccion;
	}

	public int pasivaOscuro(int x, int opcion, int misilesEleccion) {

		float calculoOscuridad;

		if (equipos.get(x).getTipoPlaneta() == 8) {

			calculoOscuridad = (float) equipos.get(opcion).getVidas() / (float) equipos.get(opcion).getVidasBase();
			System.out.println(calculoOscuridad);
			if (calculoOscuridad * 100 <= 20) {
				misilesEleccion = misilesEleccion * 2;
				System.out.println();
			}

		}

		return misilesEleccion;
	}

	public void mostrarGanador() {
//		int x;

//		for (x = 0; x < equipos.size(); x++) {
//			if (equipos.get(x).isVivo()) {
		System.out.println("¡El máximo campeón mundial súper guay de esta partida es... "
				+ equipos.get(0).getNombreEquipo() + "! Sois loh mehore.");
//			}
//		}
	}

	public void empate() {
		System.out.println("Todos los equipos han sido eliminados, menudo bochorno....");
	}

	public void finalizarPartida() {
		System.out.println("Partida terminada. Volviendo al menú principal...");
	}

	public int intScanner() {
		boolean esInt = false;
		Scanner teclado = new Scanner(System.in);
		int numero = 0;

		do {
			if (teclado.hasNextInt()) {
				numero = teclado.nextInt();
				esInt = true;
			} else if (numero >= 1000000000) {
				System.out.println("¡Ese numero es demasiado grande!");
				numero = teclado.nextInt();
			} else {
				System.out.println("No puedes insertar letras.");
				teclado.nextLine();
			}

		} while (!esInt);

		return numero;
	}

}