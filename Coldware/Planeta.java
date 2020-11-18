
public class Planeta {

	// Atributs
	private int numEquipos; //No se usa de momento
	private String nombreEquipo;
	private int vidas;
	private int misilesRonda;
	private int misilesDefensa;
	private boolean vivo;

	public Planeta(int x, String nombre) {

		this.nombreEquipo = nombre;
		this.vidas = 200;
		this.misilesRonda = 50;
		this.numEquipos++;
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
	

}