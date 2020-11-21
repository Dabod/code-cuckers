import java.util.ArrayList;

public class Planeta {
	// Atributs
	ArrayList<Integer> objetivos = new ArrayList<Integer>();
	ArrayList<Integer> cantidadAtk = new ArrayList<Integer>();
	private int numEquipos;
	private int vidas;
	private int misilesRonda;
	private int misilesBase;
	private int misilesDefensa;
	private int posicionEquipo;
	private int tipoPlaneta;
	private boolean vivo;
	private String nombreEquipo;
	private String nombreTipo;

	public Planeta(int x, String nombre, int tipoPlaneta) {

		this.nombreEquipo = nombre;

		switch (tipoPlaneta) {
		case 1: // Planeta Normal
			this.nombreTipo = "(Planeta Normal,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.misilesRonda = 50;
			this.numEquipos = x + 1;
			this.misilesBase = this.misilesRonda;
			this.vivo = true;

			break;
		case 2: // Planeta Rojo
			this.nombreTipo = "(Planeta Rojo,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.misilesRonda = 50;
			this.numEquipos = x + 1;
			this.misilesBase = this.misilesRonda;
			this.vivo = true;

			break;
		case 3: // Planeta Azul
			this.nombreTipo = "(Planeta Azul,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.misilesRonda = 50;
			this.numEquipos = x + 1;
			this.misilesBase = this.misilesRonda;
			this.vivo = true;

			break;
		case 4: // Planeta Verde
			this.nombreTipo = "(Planeta Verde,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.misilesRonda = 50;
			this.numEquipos = x + 1;
			this.misilesBase = this.misilesRonda;
			this.vivo = true;

			break;
		case 5: // Planeta Gigante Gaseoso
			this.nombreTipo = "(Planeta Gaseoso,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 400;
			this.misilesRonda = 10;
			this.numEquipos = x + 1;
			this.vivo = true;
			this.misilesBase = this.misilesRonda;
			break;
		case 6: // Planeta Enano
			this.nombreTipo = "(Planeta Enano,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 100;
			this.misilesRonda = 50;
			this.numEquipos = x + 1;
			this.vivo = true;
			this.misilesBase = this.misilesRonda;
			break;
		case 7: // Planeta berserk
			this.nombreTipo = "(Planeta Berserk,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 100;
			this.misilesRonda = 150;
			this.numEquipos = x + 1;
			this.vivo = true;
			this.misilesBase = this.misilesRonda;
			break;
		case 8: // Planeta Oscuro
			this.nombreTipo = "(Planeta Oscuro,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 200;
			this.misilesRonda = 70;
			this.numEquipos = x + 1;
			this.vivo = true;
			this.misilesBase = this.misilesRonda;
			break;

		case 9: // Planeta Vegeta Super Saiyan 2
			this.nombreTipo = "(Planeta Vegeta Super Saiyan 21,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 100;
			this.misilesRonda = 50;
			this.numEquipos = x + 1;
			this.vivo = true;
			this.misilesBase = this.misilesRonda;
			break;
		case 10: // Planeta Nigromante
			this.nombreTipo = "(Planeta Nigromante,";
			this.nombreEquipo = this.nombreEquipo + " " + nombreTipo;
			this.vidas = 175;
			this.misilesRonda = 40;
			this.numEquipos = x + 1;
			this.vivo = true;
			this.misilesBase = this.misilesRonda;
			break;

		}

	}

	public void condicionesTipos(int tipoPlaneta, int numRonda,int misilesEleccion, int vidas) {
		
		

	}
	

	public int calcularDmg(int misiles) {
		if (misiles >= misilesDefensa) {
			this.vidas = this.vidas - misiles + this.misilesDefensa;
			misilesDefensa = 0;

		} else {
			return this.vidas;
		}
		if (this.vidas < 0) {
			this.vidas = 0;
		}
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

	public int resetMisiles() {
		this.misilesRonda = this.misilesBase;
		return misilesRonda;
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
		this.misilesDefensa = 0;

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
		return vivo;
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

	public int getPosicionEquipo() {
		return posicionEquipo;
	}

	public void setPosicionEquipo(int posicionEquipos) {
		this.posicionEquipo = posicionEquipos;
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