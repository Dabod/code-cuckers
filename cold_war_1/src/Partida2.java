import java.util.ArrayList;
import java.util.Scanner;

public class Partida2 {
	
	private int x,i;
	private int eleccion;
	
	private ArrayList <Planeta> equipos = new ArrayList<Planeta>();
	
	
	public void iniciarpartida2(){
		
		int x;
		int elecion;
		
		String nombre = null;
		
		Planeta guardarNombre;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Cuantos equipos van a jugar");

		eleccion = teclado.nextInt();
		
		/*try {
			if (eleccion >= 3) {
				partida();
			}
			
		}catch(Exception e) {
			eleccion = teclado.nextInt();
			System.out.println("Puto gilipollas pon mas de 3 equipos");
			
		}*/
		
		
		for(x = 0; x < eleccion; x++) {
			System.out.println("Introduce el nombre de usuario");
			
			nombre= teclado.next();
			
			guardarNombre = (new Planeta(x,nombre));
			equipos.add(guardarNombre);
			
			
		}
		ataque();
	}
	
	
	public void ataque() {
		
		ArrayList <String> movimientos = new ArrayList<String>();
		
		Scanner ataque = new Scanner(System.in);

		int missiles;
		
		for (x=0; x < equipos.size(); x++) {
			
			System.out.println("Turno del equipo: " + equipos.get(x).getNombreEquipo());
			
			
			while (equipos.get(x).getMisilesRonda() > 0 ) {
				
				System.out.println("A quien quieres atacar? ");
				
				System.out.println(equipos.get(x).getNombreEquipo()+" "+equipos.get(x).getVidas());
				
				System.out.println("Con cuantos misiles quieres atacar");
				
				missiles = ataque.nextInt();
				
				equipos.get(x).setMisilesRonda(missiles);
				
				
							
			}
			
		}
		
			
		
		
		
			
	}
	
	public void trycatch() {
		
		try {
			
			
		}catch(Exception e){
			
		}
		
	}

	
}



