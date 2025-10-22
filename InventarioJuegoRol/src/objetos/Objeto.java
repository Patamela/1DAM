package objetos;

public class Objeto {
	
	private String nombre;
	private String categoria;
	private float peso;
	private String descripcion;
	
	//CONSTRUCTOR
	public Objeto(String nombre, String categoria, float peso, String descripcion) {
		this.nombre = nombre;
		setCategoria(categoria);
		this.peso = peso;
		this.descripcion = descripcion;
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
		if(categoria.equalsIgnoreCase("Arma") || categoria.equalsIgnoreCase("Pocion") || categoria.equalsIgnoreCase("Material")) {
			this.categoria = categoria;
		}else {
			this.categoria = "Material";
		}
		
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	//TO STRING
	@Override
	public String toString() {
		return "nombre=" + nombre + ", categoria=" + categoria + ", peso=" + peso + ", descripcion="
				+ descripcion + "]";
	}
	
	//METODOS
	public Objeto mostrarDetalles() {
		Objeto obj1 = new Objeto(nombre, categoria, peso, descripcion);
		return obj1;
		/*Hacerlo mejor con sysout, sin return, siendo el metodo void*/
	}
	
	
	
	
}
