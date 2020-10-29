package coldware;

public class Planeta {

	// Atributs
	private int numEquipos;
	private String nombreEquipo;
	private int vidas;
	private int misilesRonda;
	private int misilesDefensa;

	public Planeta() {

		this.vidas = 200;
		this.misilesRonda = 50;
		this.misilesDefensa = misilesRonda / 2;

		this.numEquipos++;
	}

	private String iniciVariablesStr() {

		return null;
	}

	private String combate(int misilesRonda, int misilesDefensa) {

		return nombreEquipo;

	}

	private int calcularDano(int[] vEquipos, int[] ataqueEquipos, int vidas, String[] equipos, int numEquipos) {

		for (int x = 0; x != numEquipos; x++) {// Recorremos los equipos

		}

		return 0;

	}

	// GETTERS Y SETTERS
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
}
