import java.util.ArrayList;
import java.util.Scanner;

// comprobar int partida1/main
public class Partida2 {

	private int x;
	private int eleccion;

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
			System.out.println("Introduce el nombre del Equipo "+x+".");

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
		ataque();
	}

	public void ataque() {

		ArrayList<Integer> objetivos = new ArrayList<Integer>();

		ArrayList<Integer> cantidadAtk = new ArrayList<Integer>();

		Scanner teclado = new Scanner(System.in);

		int misiles;
		int cont = 0;
		int opcion = 0;

		for (x = 0; x < equipos.size(); x++) {
			System.out.println("(" + x + ") " + equipos.get(x).getNombreEquipo() + " " + "(" + equipos.get(x).getVidas()
					+ " vidas)");
			cont++;
		}
		for (x = 0; equipos.size() > x; x++) {
			System.out.println("(" + cont + ") Misiles Restantes a defensa.\n");

			while (equipos.get(x).getMisilesRonda() != 0) {
				System.out.println("Introduce el numero del objetivo que quieres atacar o (" + (cont)
						+ ") para poner los misiles restantes a defensa");
				opcion = intScanner();

				while (opcion > cont || opcion < 0) {
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
						misiles = intScanner();

						if (misiles <= 0) {
							System.out.println("¡No puedes atacar con 0 misiles o menos!");
						} else if (misiles > equipos.get(x).getMisilesRonda()) {
							System.out.println("Misiles insuficientes.");
						}
					} while (misiles <= 0 || misiles > equipos.get(x).getMisilesRonda());
					equipos.get(x).usarMisiles(misiles);
					System.out.println(equipos.get(x).getMisilesRonda());
					cantidadAtk.add(misiles);
				}

			}

		}

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
