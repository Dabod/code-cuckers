import java.util.ArrayList;
import java.util.Scanner;

// comprobar int partida1/main
public class Partida2 {

	private int x, i;
	private int eleccion;

	private ArrayList<Planeta> equipos = new ArrayList<Planeta>();

	public void iniciarpartida2() {

		int x;
		int elecion = 0;
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
			System.out.println("Introduce el nombre de usuario");

			nombre = teclado.next();

			guardarNombre = (new Planeta(x, nombre));
			equipos.add(guardarNombre);

		}
		ataque();
	}

	public void ataque() {

		ArrayList<String> objetivo = new ArrayList<String>();

		Scanner teclado = new Scanner(System.in);

		int missiles;
		int cont = 0;

		for (x = 0; x < equipos.size(); x++) {
			System.out.println(
					"(" + cont++ + ") " + equipos.get(x).getNombreEquipo() + " " + "(" + equipos.get(x).getVidas()+" vidas)");

		}
		for (x = 0; equipos.size() > x; x++) {

			while (equipos.get(x).getMisilesRonda() != 0) {
				System.out.println("Introduce el numero del objetivo que quieres atacar o (" + (cont + 1)+ ") para poner los misiles restantes a defensa");
				
				
				
				System.out.println("¿Con cuantos misiles le vas a atacar?");

				missiles = teclado.nextInt();
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
			} else {
				System.out.println("No puedes insertar letras.");
				teclado.nextLine();

			}

		} while (!esInt);
		return numero;

	}

}
