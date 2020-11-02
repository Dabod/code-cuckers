import java.util.Scanner;

public class Partida {

	// Atributos
	private String ganadorPartida;
	private int opcionMenu;
	private String nombreEquipo;
	private int ronda;
	private int equiposVivos = 5;

	private int[][] matDefAtk = new int[6][6]; // MATRIZ QUE GUARDA LA DEFENSA Y ATAQUES DE LOS EQUIPOS

	// Objetos
	Scanner teclado = new Scanner(System.in);

	Planeta equipo1 = new Planeta();
	Planeta equipo2 = new Planeta();
	Planeta equipo3 = new Planeta();
	Planeta equipo4 = new Planeta();
	Planeta equipo5 = new Planeta();
	Planeta equipos[] = { null, equipo1, equipo2, equipo3, equipo4, equipo5 }; // ARRAY DE OBJETOS

	// Constructor Partida

	// Metodos

	public void iniciarPartida() {
		// Opción "jugar" del menú.
		System.out.println("Iniciando partida en...");
		parar(1000);
		System.out.println("3...");
		parar(1000);
		System.out.println("2...");
		parar(1000);
		System.out.println("1...\n");
		parar(1000);
		System.out.println("Introduce el nombre de los equipos: ");

		for (int x = 1; x <= 5; x++) {
			System.out.println("Equipo " + x + ": ");

			nombreEquipo = teclado.nextLine();

			while (nombreEquipo.equals(equipos[1].getNombreEquipo())
					|| nombreEquipo.equals(equipos[2].getNombreEquipo())
					|| nombreEquipo.equals(equipos[3].getNombreEquipo())
					|| nombreEquipo.equals(equipos[4].getNombreEquipo())
					|| nombreEquipo.equals(equipos[5].getNombreEquipo())) {
				System.err.println(
						"¡El nombre del equipo debe ser único! Los nombres no pueden repetirse, introduce otro nombre.");
				System.out.println("Equipo " + x + ": ");
				nombreEquipo = teclado.nextLine();
			}

			equipos[x].setNombreEquipo(nombreEquipo);

		}
		System.out.println("\n\n¡Inicio de partida!\n\n");
		parar(2000);
		partida();

	}

	public void partida() {
		ronda = 1;
		while (equiposVivos > 1 && equiposVivos != 0) {
			equiposVivos = 0;
			// nice.
			ronda(matDefAtk);
			efectosRonda(matDefAtk);

			checkVivos(equiposVivos);
			System.out.println("Equipos vivos: "+equiposVivos);
			ronda++;
		}
		if (equiposVivos == 1) {
			parar(3000);
			mostrarGanador();
		} else {
			parar(3000);
			empate();
		}

	}

	public int[][] ronda(int[][] matDefAtk) { // IMPORTANT: S'ha de separar en dos parts; presa de decisions i efecte de
												// les mateixes al ACABAR-SE LA RONDA.
		int equipoAtacante = 0, equipoObjetivo = 0;
		int costeMisilesDefensa, misilesRestantes;

		System.out.println("RONDA " + ronda + "\n");
		for (equipoAtacante = 1; equipoAtacante < equipos.length; equipoAtacante++) {

			if (equipos[equipoAtacante].getVidas() != 0) {
				// INICIO DE TURNO
				equipos[equipoAtacante].setMisilesRonda(50);
				System.out.println("\nTurno de " + equipos[equipoAtacante].getNombreEquipo() + ":");
				System.out.println("Misiles disponibles: " + equipos[equipoAtacante].getMisilesRonda() + ".\n");
				System.out.println("¿Con cuantos misiles quieres defenderte?");
				System.out.println("Ten en cuenta que esta decisión es definitiva (para esta ronda).");

				matDefAtk[0][equipoAtacante] = teclado.nextInt();
				equipos[equipoAtacante].setMisilesDefensa(matDefAtk[0][equipoAtacante]);

				while (matDefAtk[0][equipoAtacante] > 25 || matDefAtk[0][equipoAtacante] < 0) {
					System.err.println(
							"No puedes usar más de 25 misiles de defensa ni tener defensa negativa (¡Los misiles de defensa cuestan x2!).");
					System.out.println("Misiles disponibles: " + equipos[equipoAtacante].getMisilesRonda() + ".\n");
					System.out.println("¿Con cuantos misiles quieres defenderte?");
					System.out.println("Ten en cuenta que esta decisión es definitiva (para esta ronda).");
					matDefAtk[0][equipoAtacante] = teclado.nextInt();
				}
				costeMisilesDefensa = matDefAtk[0][equipoAtacante] * 2;
				misilesRestantes = equipos[equipoAtacante].getMisilesRonda() - costeMisilesDefensa;
				equipos[equipoAtacante].setMisilesRonda(misilesRestantes);
				do {

					if (equipos[equipoAtacante].getMisilesRonda() != 0) {

						do {
							System.out.println("\n¿A quien quieres atacar? (Selecciona un número de la lista)");

							if (equipos[1].getVidas() == 0) {
								System.out.println("(1) " + equipos[1].getNombreEquipo() + " (" + equipos[1].getVidas()
										+ " vidas, muerto)");
							} else {
								System.out.println("(1) " + equipos[1].getNombreEquipo() + " (" + equipos[1].getVidas()
										+ " vidas)");
							}

							if (equipos[2].getVidas() == 0) {
								System.out.println("(2) " + equipos[2].getNombreEquipo() + " (" + equipos[2].getVidas()
										+ " vidas, muerto)");
							} else {
								System.out.println("(2) " + equipos[2].getNombreEquipo() + " (" + equipos[2].getVidas()
										+ " vidas)");
							}

							if (equipos[3].getVidas() == 0) {
								System.out.println("(3) " + equipos[3].getNombreEquipo() + " (" + equipos[3].getVidas()
										+ " vidas, muerto)");
							} else {
								System.out.println("(3) " + equipos[3].getNombreEquipo() + " (" + equipos[3].getVidas()
										+ " vidas)");
							}

							if (equipos[4].getVidas() == 0) {
								System.out.println("(4) " + equipos[4].getNombreEquipo() + " (" + equipos[4].getVidas()
										+ " vidas, muerto)");
							} else {
								System.out.println("(4) " + equipos[4].getNombreEquipo() + " (" + equipos[4].getVidas()
										+ " vidas)");
							}

							if (equipos[5].getVidas() == 0) {
								System.out.println("(5) " + equipos[5].getNombreEquipo() + " (" + equipos[5].getVidas()
										+ " vidas, muerto)");
							} else {
								System.out.println("(5) " + equipos[5].getNombreEquipo() + " (" + equipos[5].getVidas()
										+ " vidas)");
							}
							equipoObjetivo = teclado.nextInt();

							if (equipoObjetivo < 1 || equipoObjetivo > 5) {
								System.err.println("¡Debes seleccionar un número correspondiente a algún equipo!");
							} else if (equipoObjetivo == equipoAtacante) {
								System.err.println("¡No puedes atacarte a ti mismo!\n");
								equipoObjetivo = 0;
							} else if (equipos[equipoObjetivo].getVidas() == 0) {
								System.err.println("Ese equipo ya está muerto. Selecciona otro objetivo.");
								equipoObjetivo = 0;
							}

						} while (equipoObjetivo < 1 || equipoObjetivo > 5);

						System.out.println("¿Con cuantos misiles vas a atacar a "
								+ equipos[equipoObjetivo].getNombreEquipo() + "?");
						System.out.println("Misiles disponibles: " + equipos[equipoAtacante].getMisilesRonda() + ".\n");
						matDefAtk[equipoObjetivo][equipoAtacante] = teclado.nextInt();

						while (matDefAtk[equipoObjetivo][equipoAtacante] > equipos[equipoAtacante].getMisilesRonda()
								|| matDefAtk[equipoObjetivo][equipoAtacante] < 0) {

							if (matDefAtk[equipoObjetivo][equipoAtacante] < 0) {
								System.err.println("No puedes atacar con un valor negativo, ¿estás troleando o que?");
								System.out.println("¿Con cuantos misiles vas a atacar a "
										+ equipos[equipoObjetivo].getNombreEquipo() + "?");
								System.out.println(
										"Misiles disponibles: " + equipos[equipoAtacante].getMisilesRonda() + ".\n");
								matDefAtk[equipoObjetivo][equipoAtacante] = teclado.nextInt();
							} else {
								System.err.println("¡No te quedan suficientes misiles para hacer ese ataque!");
								System.out.println("¿Con cuantos misiles vas a atacar a "
										+ equipos[equipoObjetivo].getNombreEquipo() + "?");
								System.out.println(
										"Misiles disponibles: " + equipos[equipoAtacante].getMisilesRonda() + ".\n");
								matDefAtk[equipoObjetivo][equipoAtacante] = teclado.nextInt();
							}
						}
						misilesRestantes = misilesRestantes - matDefAtk[equipoObjetivo][equipoAtacante];
						equipos[equipoAtacante].setMisilesRonda(misilesRestantes);

					}

				} while (equipos[equipoAtacante].getMisilesRonda() != 0);
			} else {
				equipos[equipoAtacante].setVivo(false);
			}
		}
		return matDefAtk;
	}

	public int[][] efectosRonda(int[][] matDefAtk) {
		int cColumna; // Equipo atacante
		int x; // Equipo Objetivo del ataque
		int ataqueTotal = 0; // La suma de todos los ataques a un mismo objetivo
		
		System.out.println("\n\n<-- RESULTADOS DE LA RONDA -->");

		for (x = 1; x < 6; x++) {
			System.out.println("  ----------------------  ");
			if (equipos[x].getMisilesDefensa() != 0) {
				System.out.println(equipos[x].getNombreEquipo() + " se defiende con " + equipos[x].getMisilesDefensa()
						+ " misiles.");
			} else {
				System.out.println(equipos[x].getNombreEquipo() + " no se ha defendido.");
			}
			for (cColumna = 1; cColumna < 6; cColumna++) {

				if (matDefAtk[x][cColumna] > 0) {
					System.out.println("¡" + equipos[cColumna].getNombreEquipo() + " le ataca con "
							+ matDefAtk[x][cColumna] + " misiles!");
					ataqueTotal = ataqueTotal + matDefAtk[x][cColumna];
					matDefAtk[x][cColumna] = 0;
				}
			}
			equipos[x].calcularDmg(ataqueTotal);
			if (ataqueTotal == 0) {
				System.out.println("Nadie le ha atacado.");
			}
			ataqueTotal = 0;
			System.out.println("A " + equipos[x].getNombreEquipo() + " le quedan " + equipos[x].getVidas() + " vidas.");

			if (equipos[x].getVidas() == 0) {
				System.out.println("El equipo " + equipos[x].getNombreEquipo() + " ha sido eliminado.");
			}
			System.out.println("  ----------------------  \n\n");
			parar(3000);
		}
		return matDefAtk;
	}

	public void reglasJuego() {
		System.out.println("<-- REGLAS DEL JUEGO -->");
		
		System.out.println("1 - Hay 5 equipos con 200 de vida al principio de la partida.");
		System.out.println("2 - Cada equipo tiene disponibles 50 misiles por ronda.");
		System.out.println("3 - Se puede atacar a diferentes equipos en una misma ronda.");
		System.out.println("4 - Cuando las vidas de un equipo llegan a 0 queda eliminado.");
		System.out.println("5 - Los misiles de defensa cuestan el doble.");
		System.out.println("Ejemplo defensa--> Si tenemos 50 misiles y ");
		System.out.println("usamos 40 para atacar solo podremos usar 5 para defendernos (nos costarian 10 misiles).");
		parar(2000);
		
		System.out.println("\nIntroduce el numero 1 para volver al menú principal.");
		opcionMenu = teclado.nextInt();
		
		while(opcionMenu != 1) {
			System.err.println("\nDebes introducir el numero 1 para volver al menú principal");
			opcionMenu = teclado.nextInt();
		}

	}

	public void infoJuego() {
		System.out.println("<-- INFORMACIÓN -->");
		
		System.out.println("Acerca de este programa:\n");
		System.out.println("Versión 1.0");
		System.out.println("Contacto: marcvaldiviaprim99@gmail.com, guepardar@gmail.com");
		System.out.println("Autores: David Alba, Marc Valdivia\n");
		parar(2000);
		
		System.out.println("\nIntroduce el numero 1 para volver al menú principal.");
		opcionMenu = teclado.nextInt();
		
		while(opcionMenu != 1) {
			System.err.println("\nDebes introducir el numero 1 para volver al menú principal");
			opcionMenu = teclado.nextInt();
		}

	}

	public void opcionesReproductor() {
		System.out.println("<-- OPCIONES DEL REPRODUCTOR -->");
		
		System.out.println("Desde aqui se podrá configurar el reproductor (Cuando haya uno).");
		parar(2000);
		
		System.out.println("\nIntroduce el numero 1 para volver al menú principal.");
		opcionMenu = teclado.nextInt();
		
		while(opcionMenu != 1) {
			System.err.println("\nDebes introducir el numero 1 para volver al menú principal");
			opcionMenu = teclado.nextInt();
		}
	}

	public int checkVivos(int equiposVivos) {// Comprobarequiposvivos
		for (int x = 1; x < equipos.length; x++) {
			if (equipos[x].getVidas() > 0) {
				equipos[x].setVivo(true);
				this.equiposVivos++;
			}
		}
		return this.equiposVivos;
	}

	public void mostrarGanador() {
		for (int x = 1; x < equipos.length; x++) {
			if (equipos[x].isVivo()) {
				ganadorPartida = equipos[x].getNombreEquipo();
			}
		}
		System.out.println("¡El máximo campeón mundial súper guay de esta partida es... " + ganadorPartida
				+ "! ¡Sois loh mehore!");
	}

	public void empate() {
		System.out.println("Todos los equipos han sido eliminados, menudo bochorno....");
	}

	public void finalizarPartida() {
		System.out.println("Partida terminada. Volviendo al menú principal...");
	}

	public void parar(int milisegons) {
		try {
			Thread.sleep(milisegons);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// GETTERS Y SETTERS
	public int getOpcionMenu() {
		return opcionMenu;
	}

	public void setOpcionMenu(int nuevaOpMenu) {
		System.out.println(nuevaOpMenu);
		this.opcionMenu = nuevaOpMenu;
	}

	public String getGanadorPartida() {
		return ganadorPartida;
	}

	public void setGanadorPartida(String ganadorPartida) {
		this.ganadorPartida = ganadorPartida;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
}