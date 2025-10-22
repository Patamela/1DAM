package listas;

public class Productos {
	private String nombre;
	private String categoria;
	private double precio;
	
	//CONSTRUCTOR
	public Productos(String nombre, String categoria, double precio) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + "]";
	}
	
	
	
}
