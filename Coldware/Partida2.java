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
					System.out.println("Nombre en uso. Introduce un nombre único.");
					nombre = teclado.next();
				}
			}
			guardarNombre = (new Planeta(x, nombre));
			equipos.add(guardarNombre);
		}
		equiposVivos = equipos.size();
		do {
			ronda();
			efectosRonda();
			checkVivos(equiposVivos);
		} while (equiposVivos != 1 || equiposVivos != 0);
		if (equiposVivos == 1) {
			mostrarGanador();
		} else {
			empate();
		}
		finalizarPartida();
	}

	public void ronda() {

		ArrayList<Integer> objetivos = new ArrayList<Integer>();

		ArrayList<Integer> cantidadAtk = new ArrayList<Integer>();

		Scanner teclado = new Scanner(System.in);

		int misilesEleccion;
		int x = 0, y = 0, cont = 0;
		int opcion = 0;

		for (x = 0; equipos.size() > x; x++) {
			equipos.get(x).resetMisiles();
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

				System.out.println("Introduce el numero del objetivo que quieres atacar o (" + (cont)
						+ ") para poner los misiles restantes a defensa");
				opcion = intScanner();

				while (opcion > cont || opcion < 0) { // Error opcion no valida
					System.out.println("¡Opcion no válida! Selecciona una opción de la lista.");
					opcion = intScanner();
				}

				if (opcion == cont) {// Defensa todo
					equipos.get(x).defender(equipos.get(x).getMisilesRonda());
					equipos.get(x).usarMisiles(equipos.get(x).getMisilesRonda());

					System.out.println(equipos.get(x).getMisilesDefensa());
					System.out.println(equipos.get(x).getMisilesRonda());

				} else {
					objetivos.add(opcion);

					do {
						System.out.println("¿Con cuantos misiles le vas a atacar?");
						misilesEleccion = intScanner();
						cantMisilesError(misilesEleccion, x);
					} while (misilesEleccion <= 0 || misilesEleccion > equipos.get(x).getMisilesRonda());

					equipos.get(x).usarMisiles(misilesEleccion);
					cantidadAtk.add(misilesEleccion);
				}
			}
		}
	}
	
	public void efectosRonda() {
		
	}

	public int cantMisilesError(int misilesEleccion, int x) {
		if (misilesEleccion <= 0) {
			System.out.println("¡No puedes atacar con 0 misiles o menos!");
		} else if (misilesEleccion > equipos.get(x).getMisilesRonda()) {
			System.out.println("Misiles insuficientes.");
		}
		return misilesEleccion;
	}

	public int checkVivos(int equiposVivos) {// Comprobarequiposvivos
		int x;

		for (x = 0; x < equipos.size(); x++) {
			if (equipos.get(x).getVidas() > 0) {
				equipos.get(x).setVivo(true);
				this.equiposVivos++;
			}
		}
		return this.equiposVivos;
	}

	public void mostrarGanador() {
		int x;

		for (x = 0; x < equipos.size(); x++) {
			if (equipos.get(x).isVivo()) {
				ganadorPartida = equipos.get(x).getNombreEquipo();
			}
		}
		System.out.println(
				"¡El máximo campeón mundial súper guay de esta partida es... " + ganadorPartida + "!Sois loh mehore!");
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
