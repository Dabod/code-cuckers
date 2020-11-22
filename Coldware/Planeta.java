import java.util.ArrayList;

public class Planeta {
	// Atributs
	ArrayList<Integer> objetivos = new ArrayList<Integer>();
	ArrayList<Integer> cantidadAtk = new ArrayList<Integer>();
	private int numEquipos;
	private int vidas;
	private int vidasBase;
	private int misilesRonda;
	private int misilesBase;
	private int misilesDefensa;
	private int posicionEquipo;
	private int tipoPlaneta;

	private boolean vivo;
	private String nombreEquipo;
	private String nombreTipo;
	private String nombreMasTipo;

	public Planeta(int x, String nombre, int tipoPlaneta) {

		this.nombreEquipo = nombre;
		this.tipoPlaneta = tipoPlaneta;
		this.numEquipos++;
		this.vivo = true;

		switch (tipoPlaneta) {
		case 1: // Planeta Normal
			this.nombreTipo = "(Normal)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.vidasBase = this.vidas;
			this.misilesRonda = 50;
			this.misilesBase = this.misilesRonda;

			break;
		case 2: // Planeta Rojo
			this.nombreTipo = "(Rojo)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.vidasBase = this.vidas;
			this.misilesRonda = 50;
			this.misilesBase = this.misilesRonda;

			break;
		case 3: // Planeta Azul
			this.nombreTipo = "(Azul)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.vidasBase = this.vidas;
			this.misilesRonda = 50;
			this.misilesBase = this.misilesRonda;

			break;
		case 4: // Planeta Verde
			this.nombreTipo = "(Verde)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.vidasBase = this.vidas;
			this.misilesRonda = 50;
			this.misilesBase = this.misilesRonda;

			break;
		case 5: // Planeta Gigante Gaseoso
			this.nombreTipo = "(Gaseoso)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 400;
			this.vidasBase = this.vidas;
			this.misilesRonda = 0;
			this.misilesBase = this.misilesRonda;
			break;
		case 6: // Planeta Enano
			this.nombreTipo = "(Enano)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 100;
			this.vidasBase = this.vidas;
			this.misilesRonda = 50;
			this.misilesBase = this.misilesRonda;
			break;
		case 7: // Planeta berserk
			this.nombreTipo = "(Berserk)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 100;
			this.vidasBase = this.vidas;
			this.misilesRonda = 150;
			this.misilesBase = this.misilesRonda;
			break;
		case 8: // Planeta Oscuro
			this.nombreTipo = "(Oscuro)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.vidasBase = this.vidas;
			this.misilesRonda = 50;
			this.misilesBase = this.misilesRonda;
			break;

		case 9: // Planeta Vegeta Super Saiyan 2
			this.nombreTipo = "(Vegeta Super Saiyan 2)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 100;
			this.misilesRonda = 30;
			this.misilesBase = this.misilesRonda;
			break;
		case 10: // Planeta Nigromante
			this.nombreTipo = "(Nigromante)";
			this.nombreMasTipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 175;
			this.vidasBase = this.vidas;
			this.misilesRonda = 40;
			this.misilesBase = this.misilesRonda;
			break;

		}

	}

	public int ventajasColores(int tipoObjetivo, int misilesEleccion) {
		if (this.tipoPlaneta == 2) { // Condiciones equipo rojo
			if (tipoObjetivo == 4) { // Equipo verde, atk*2
				misilesEleccion = misilesEleccion * 2;
			} else if (tipoObjetivo == 3) { // Equipo azul, atk/2
				misilesEleccion = misilesEleccion / 2;
			}
		}

		if (this.tipoPlaneta == 3) { // Condiciones equipo azul
			if (tipoObjetivo == 2) { // Equipo rojo, atk*2
				misilesEleccion = misilesEleccion * 2;
			} else if (tipoObjetivo == 4) { // Equipo verde, atk/2
				misilesEleccion = misilesEleccion / 2;
			}
		}

		if (this.tipoPlaneta == 4) { // Condiciones equipo verde
			if (tipoObjetivo == 3) { // Equipo azul, atk*2
				misilesEleccion = misilesEleccion * 2;
			} else if (tipoObjetivo == 2) { // Equipo rojo, atk/2
				misilesEleccion = misilesEleccion / 2;
			}
		}

		return misilesEleccion;
	}

	public int planetaEnano() {

		int chanceEsquivar;
		int min = 0;
		int max = 1;

		chanceEsquivar = (int) (Math.random() * (max - min + 1)) + min;

		return chanceEsquivar;
	}

	public int calcularDmg(int misiles) {
		if (misiles >= misilesDefensa) {
			this.vidas = this.vidas - misiles + this.misilesDefensa;
		} else {
			return this.vidas;
		}
		if (this.vidas < 0) {
			this.vidas = 0;
		}
		misilesDefensa = 0;

		return this.vidas;
	}

	public int defender(int misiles) {
		misiles = misiles / 2;
		this.misilesDefensa = misiles;

		return this.misilesDefensa;
	}

	public int usarMisiles(int misiles) {
		this.misilesRonda = this.misilesRonda - misiles;

		return this.misilesRonda;
	}

	public void resetMisiles(int tipoPlaneta) { // Resetea los misiles para una nueva ronda y le otorga misiles extras a
												// los planetas que lo necesiten.
		if (tipoPlaneta == 5) {
			this.misilesBase = this.misilesBase + 10;
			this.misilesRonda = this.misilesBase;

		} else {
			this.misilesRonda = this.misilesBase;

		}
	}

	public void pasivaNigromante(int equiposMuertos) { // Activa la pasiva de los planetas tipo Nigromante.
		int x;

		if (equiposMuertos > 0) {
			for (x = 0; x < equiposMuertos; x++) {
				this.misilesBase = this.misilesBase + 20;
				this.vidas = this.vidas + 40;
				System.out.println("El nigromante recibe 20 misiles y se cura 40 de vida por cada equipo muerto.");
			}
			if (this.vidas > this.vidasBase) { // No permitimos que se cure más de sus vidas base.
				this.vidas = this.vidasBase;
			}
		}
	}

	public void pasivaVegeta(int cantidadEquipos, int tipoEquipo) { // Activa la pasiva del Planeta Vegeta
		int x;
		
		if(tipoEquipo == 9) {
			for(x = 0; x < (cantidadEquipos - 1); x++) {
				this.vidas = this.vidas + 100;
				this.misilesBase = this.misilesBase + 20;
			}
		}
	}

	public int resetDefensa() {
		this.misilesDefensa = 0;
		return misilesDefensa;
	}

	// FUNCIONES ARRAYLIST

	public void introducirObjetivo(int objetivo) {

		this.objetivos.add(objetivo);

	}

	public void introducirAtaque(int cantidadAtaque) {

		this.cantidadAtk.add(cantidadAtaque);
	}

	public void resetArrays() {

		this.objetivos.clear();
		this.cantidadAtk.clear();

	}

	// GETTERS Y SETTERS

	// VIDAS
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	// PROPIEDAD VIVO
	public boolean isVivo() {
		return vidas > 0;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	// NOMBRE EQUIPO
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	// NUMERO DE EQUIPOS
	public int getNumEquipos() {
		return numEquipos;
	}

	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}

	// MISILES DISPONIBLESd
	public int getMisilesRonda() {
		return misilesRonda;
	}

	public void setMisilesRonda(int misilesRonda) {
		this.misilesRonda = misilesRonda;
	}

	// MISILES DE DEFENSA DE LA RONDA
	public int getMisilesDefensa() {
		return misilesDefensa;
	}

	public void setMisilesDefensa(int misilesDefensa) {
		this.misilesDefensa = misilesDefensa;
	}

	// POSICION DEL EQUIPO
	public int getPosicionEquipo() {
		return posicionEquipo;
	}

	public void setPosicionEquipo(int posicionEquipos) {
		this.posicionEquipo = posicionEquipos;
	}

	// TIPO DEL EQUIPO
	public int getTipoPlaneta() {
		return tipoPlaneta;
	}

	// NOMBRE DEL EQUIPO + TIPO
	public String getNombreMasTipo() {
		return nombreMasTipo;
	}

	// NOMBRE DEL TIPO
	public String getNombreTipo() {
		return nombreTipo;
	}

	public int getVidasBase() {
		return this.vidasBase;
	}

	// Arraylist

	public ArrayList<Integer> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(ArrayList<Integer> objetivos) {
		this.objetivos = objetivos;
	}

	public ArrayList<Integer> getCantidadAtk() {
		return cantidadAtk;
	}

	public void setCantidadAtk(ArrayList<Integer> cantidadAtk) {
		this.cantidadAtk = cantidadAtk;
	}

	
}