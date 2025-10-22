package juegoAhorcado;

public class Jugador {
	private String nombre;
	private String contrasenia;
	private int id;
	private static int contador=0;
	
	public Jugador(String nombre, String contrasenia) {
		this.id = contador++;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
