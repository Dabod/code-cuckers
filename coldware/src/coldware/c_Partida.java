package coldware;
import java.util.Scanner;

public class c_Partida {
	
	
	//Atributos
	String ganadorPartida;
	int opcionMenu;
	
	
	
	//Objetos
	Scanner teclado = new Scanner(System.in);
	
	c_Planeta planeta1 = new c_Planeta();
	c_Planeta planeta2 = new c_Planeta();
	c_Planeta planeta3 = new c_Planeta();
	c_Planeta planeta4 = new c_Planeta();
	c_Planeta planeta5 = new c_Planeta();
	
	
	//Constructor
	public void ConstructorPartida() {
		
		//this.vidas = 200;
		//this.misilesRonda = 50;
		//this.misilesDefensa = misilesRonda / 2;
         //**AÑADIR GETTERS Y SETTERS
	}
	
	//Metodos
	public void menu() {
		System.out.println("\n1 - Jugar\n");
		System.out.println("2 - Reglas del Juego\n");
		System.out.println("3 - Información\n");
		System.out.println("4 - Opciones Musica\n");
		System.out.println("0 - Salir");

		opcionMenu = teclado.nextInt();
	}
	
	public void iniciarPartida(int opcionMenu) {
		// jugar menu.
			
	}

	public int checkVivos() {// Comprobarequiposvivos

		return 0;
	}

	public void mostrarGanador() {

	}

	public void finalizarPartida() {

	}

}