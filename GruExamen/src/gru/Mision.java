package gru;

public class Mision {
	private String nombre;
	private String descripcion;
	private int puntuacionNecesaria;
	
	
	//CONSTRUCTORES
	public Mision() {
	}



	public Mision(String nombre, String descripcion, int puntuacionNecesaria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		setPuntuacionNecesaria(puntuacionNecesaria);
	}

	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getPuntuacionNecesaria() {
		return puntuacionNecesaria;
	}



	public void setPuntuacionNecesaria(int puntuacionNecesaria) {
		if(puntuacionNecesaria<10) {
			puntuacionNecesaria = 10;
		}else if(puntuacionNecesaria>400) {
			puntuacionNecesaria = 400;
		}
		
		this.puntuacionNecesaria = puntuacionNecesaria;
	}


	//TO STRING
	@Override
	public String toString() {
		return "Mision [nombre=" + nombre + ", descripcion=" + descripcion + ", puntuacionNecesaria="
				+ puntuacionNecesaria + "]";
	}
	
	
	
}
