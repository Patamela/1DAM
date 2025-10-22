package caja;

public class Mision implements Comparable<Mision> {
	private String nombre;
	private Prioridades prioridad;
	
	
	public Mision(String nombre, String prioridad) {
		this.nombre = nombre;
		prioridad = prioridad.toUpperCase();
		if(prioridad.equals("ALTA") || prioridad.equals("MEDIA") || prioridad.equals("BAJA")){
			this.prioridad =  Prioridades.valueOf(prioridad);
		}else {
			this.prioridad = Prioridades.MEDIO;
		}
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Prioridades getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(Prioridades prioridad) {
		this.prioridad = prioridad;
	}
	
	
	@Override
	public String toString() {
		return "Mision [nombre=" + nombre + ", prioridad=" + prioridad + "]";
	}


	@Override
	public int compareTo(Mision m) {
		int orden = this.prioridad.compareTo(m.prioridad);
		
		if(orden==0) {
			return this.nombre.compareTo(m.nombre);
		}
		
		return orden;
	}
	
	
	
}
