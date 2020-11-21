import java.util.ArrayList;

public class Planeta {
	// Atributs
	ArrayList<Integer> objetivos = new ArrayList<Integer>();
	ArrayList<Integer> cantidadAtk = new ArrayList<Integer>();
	private int numEquipos;
	private String nombreEquipo;
	private int vidas;
	private int misilesRonda;
	private int misilesBase;
	private int misilesDefensa;
	private int posicionEquipo;
	private boolean vivo;


	public Planeta(int x, String nombre) {

		this.nombreEquipo = nombre;
		this.vidas = 200;
		this.misilesRonda = 50;
		this.numEquipos = x + 1;
		this.misilesBase = this.misilesRonda;
		this.vivo = true;
	}

	public int calcularDmg(int misiles) {
		if (misiles >= misilesDefensa) {
			this.vidas = this.vidas + misilesDefensa - misiles;
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
	
	//FUNCIONES ARRAYLIST
	
	public void introducirObjetivo(int objetivo){
		
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