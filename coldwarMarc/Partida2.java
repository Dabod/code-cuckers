import java.util.ArrayList;
import java.util.Scanner;

// comprobar int partida1/main
public class Partida2 {
	private int x;
	private int eleccion;
	private int equiposVivos;
	private String ganadorPartida;

	private ArrayList<Planeta> equipos = new ArrayList<Planeta>();

	public void iniciarpartida2() {

		int x;
		boolean pocosEquipos;
		String nombre = null;

		Planeta guardarNombre;

		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("Cuantos equipos van a jugar?");

			eleccion = intScanner();
			if (eleccion < 3) {

				System.out.println("Se necesita un minimo de 3 equipos.");
				pocosEquipos = true;

			} else {
				pocosEquipos = false;
			}

		} while (pocosEquipos);

		for (x = 0; x < eleccion; x++) {
			System.out.println("Introduce el nombre del Equipo " + x + ".");

			nombre = teclado.next();

			for (x = 0; x < equipos.size(); x++) {
				while (equipos.get(x).getNombreEquipo().equals(nombre)) {
					System.out.println("Nombre en uso. Introduce un nombre �nico.");
					nombre = teclado.next();
				}
			}
			guardarNombre = (new Planeta(x, nombre));
			equipos.add(guardarNombre);

			equipos.get(x).setPosicionEquipo(x);

		}

		partida();

	}

	public void partida() {

		do {
			checkVivos(equiposVivos);
			ronda();
			efectosRonda();
			checkVivos(equiposVivos);
		} while (equiposVivos != 1 && equiposVivos != 0);
		if (equiposVivos == 1) {
			mostrarGanador();
		} else {
			empate();
		}
		finalizarPartida();

	}

	public void ronda() {
		int misilesEleccion;
		int x = 0, y = 0, cont = 0;
		int opcion = 0;
		boolean errorFastigos = false;

		for (x = 0; equipos.size() > x; x++) {

			equipos.get(x).resetMisiles();
			equipos.get(x).resetArrays();

			if (equipos.get(x).isVivo() == true) {

				System.out.println("-->TURNO DE " + equipos.get(x).getNombreEquipo() + "<--");
				while (equipos.get(x).getMisilesRonda() != 0) {

					System.out.println("Misiles disponibles: " + equipos.get(x).getMisilesRonda() + ".\n");
					cont = 0;
					for (y = 0; y < equipos.size(); y++) {
						System.out.println("(" + y + ") " + equipos.get(y).getNombreEquipo() + " " + "("
								+ equipos.get(y).getVidas() + " vidas)");
						cont++;
					}
					System.out.println("(" + cont + ") Misiles Restantes a defensa.\n");

					System.out.println("Introduce el numero del objetivo que quieres atacar o (" + (equipos.get(x).getPosicionEquipo())
							+ ") para poner los misiles restantes a defensa");

					opcion = intScanner();
					System.out.println(+ equipos.get(opcion).getVidas());
					
					if (opcion < cont) {
						
						while (equipos.get(opcion).getVidas() == 0) {
								
								
								System.out.println(+ equipos.get(opcion).getVidas());
								System.out.println("Esta muerto");;
								System.out.println("introduce otro ");
								
								opcion = intScanner();
							
						}
						
					}

//					// Comprobacion que no puedes atacarte a ti mismo
//					while (opcion == equipos.get(x).getPosicionEquipo()) {
//						System.out.println("No puedes atacarte a ti mismo ");
//						opcion = intScanner();
//					}

					while (opcion > cont || opcion < 0) { // Error opcion no valida
						System.out.println("�Opcion no v�lida! Selecciona una opci�n de la lista.");
						opcion = intScanner();
					}

					if (opcion == equipos.get(x).getPosicionEquipo()) {// Defensa todo
						equipos.get(x).defender(equipos.get(x).getMisilesRonda());
						equipos.get(x).usarMisiles(equipos.get(x).getMisilesRonda());
						
					} else {

						equipos.get(x).introducirObjetivo(opcion);

						do {
							System.out.println("�Con cuantos misiles le vas a atacar?");
							misilesEleccion = intScanner();
							cantMisilesError(misilesEleccion, x);

						} while (misilesEleccion <= 0 || misilesEleccion > equipos.get(x).getMisilesRonda());

						equipos.get(x).usarMisiles(misilesEleccion);
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
			System.out.println("  ----------------------  ");
			if (equipos.get(x).getMisilesDefensa() != 0) {
				System.out.println(equipos.get(x).getNombreEquipo() + " se defiende con "
						+ equipos.get(x).getMisilesDefensa() + " misiles.");

			} else {
				System.out.println(equipos.get(x).getNombreEquipo() + " no se ha defendido.");
			}
			hacerAtaques(x);

		}

	}

	public void hacerAtaques(int x) {

		int y; // Equipo atacante
		int z; // Posicion de los arrays
		boolean noAtaque = true;

		for (y = 0; y < equipos.size(); y++) { // Recorre los posibles equipos atacantes

			for (z = 0; z < equipos.get(y).objetivos.size(); z++) { // Recorre los arrays objetivos

				if (equipos.get(y).objetivos.get(z) == x) { // Comprobamos si el equipo atacante esta atacando al equipo
															// con posicion x

					equipos.get(x).calcularDmg(equipos.get(y).cantidadAtk.get(z)); // Comprueba la cantidad del ataque y
																					// lo hace
					System.out.println("El equipo " + equipos.get(y).getNombreEquipo() + " a atacado a "
							+ equipos.get(x).getNombreEquipo() + " con " + equipos.get(y).cantidadAtk.get(z)
							+ " missiles");

					noAtaque = false;

				}

			}
		}
		if (noAtaque) {
			System.out.println("Nadie le ha atacado... ");
		}

	}

	public int cantMisilesError(int misilesEleccion, int x) {
		if (misilesEleccion <= 0) {
			System.out.println("�No puedes atacar con 0 misiles o menos!");
		} else if (misilesEleccion > equipos.get(x).getMisilesRonda()) {
			System.out.println("Misiles insuficientes.");
		}
		return misilesEleccion;
	}

	public int checkVivos(int equiposVivos) {// Comprobarequiposvivos
		int x;
		int contVivos = 0;

		for (x = 0; x < equipos.size(); x++) {
			if (equipos.get(x).getVidas() > 0) {
				equipos.get(x).setVivo(true);
				contVivos++;
			} else {
				equipos.get(x).setVivo(false);

			}
		}
		return this.equiposVivos = contVivos;
	}

	public void mostrarGanador() {
		int x;

		for (x = 0; x < equipos.size(); x++) {
			if (equipos.get(x).isVivo()) {
				ganadorPartida = equipos.get(x).getNombreEquipo();
			}
		}
		System.out.println(
				"�El m�ximo campe�n mundial s�per guay de esta partida es... " + ganadorPartida + "!Sois loh mehore!");
	}

	public void empate() {
		System.out.println("Todos los equipos han sido eliminados, menudo bochorno....");
	}

	public void finalizarPartida() {
		System.out.println("Partida terminada. Volviendo al men� principal...");
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
				System.out.println("�Ese numero es demasiado grande!");
				numero = teclado.nextInt();
			} else {
				System.out.println("No puedes insertar letras.");
				teclado.nextLine();
			}

		} while (!esInt);

		return numero;
	}

}