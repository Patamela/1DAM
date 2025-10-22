package actividadFinal;

public class Personaje {
	private int id;
	private static int contador = 0;
	private String nombre;
	private String poderes;
	private boolean mascara;
	private boolean capa;
	private Rol tipo;
	
	public Personaje(String nombre, String poderes,boolean mascara, boolean capa, Rol tipo) {
		this.id=contador++;
		this.nombre = nombre;
		this.poderes = poderes;
		this.mascara = mascara;
		this.capa = capa;
		this.tipo = tipo;
	}

	
	public Personaje() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoderes() {
		return poderes;
	}

	public void setPoderes(String poderes) {
		this.poderes = poderes;
	}

	public boolean isMascara() {
		return mascara;
	}

	public void setMascara(boolean mascara) {
		this.mascara = mascara;
	}

	public boolean isCapa() {
		return capa;
	}

	public void setCapa(boolean capa) {
		this.capa = capa;
	}

	public Rol getTipo() {
		return tipo;
	}

	public void setTipo(Rol tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
