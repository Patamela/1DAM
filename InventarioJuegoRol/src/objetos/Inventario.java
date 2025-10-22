package objetos;

import java.util.Arrays;

public class Inventario {
	
	private Objeto[] objetos;
	
	//CONSTRUCTOR
	public Inventario() {
		this.objetos = new Objeto[50];
	}

	//GETTERS Y SETTERS
	public Objeto[] getObjetos() {
		return objetos;
	}

	public void setObjetos(Objeto[] objetos) {
		this.objetos = objetos;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Inventario [objetos=" + Arrays.toString(objetos) + "]";
	}

	//METODOS
	public boolean agregarObjeto(Objeto objeto) {
		boolean flag = false;
		for(int i=0; i<objetos.length; i++) {
			if(objetos[i]==null) {
				objetos[i]=objeto.mostrarDetalles();
				flag=true;
				i=objetos.length;
			}
		}
		return flag;
	}
	
	public boolean eliminarObjeto(String nombre) {
		boolean flag = false;
		for(int i=0; i<objetos.length; i++) {
			if(objetos[i]!=null && objetos[i].getNombre().equals(nombre)) {
				objetos[i]=null;
				flag=true;
				i=objetos.length;
			}
		}
		return flag;
	}
	
	public void listaObjetos() {
		for(int i=0; i<objetos.length; i++) {
			if(objetos[i]!=null) {
				System.out.println(objetos[i].mostrarDetalles());
			}
		}
	}
	
	public void filtroObjetosCategoria(String eleccionCategoria) {
		for(int i=0; i<objetos.length; i++) {
			if(objetos[i]!=null && eleccionCategoria.equalsIgnoreCase(objetos[i].getCategoria())) {
				System.out.println(objetos[i].mostrarDetalles());
			}
		}
	}
	
	public float calculoPesoTotal() {
		float pesoTotal = 0;
		for(int i=0; i<objetos.length; i++) {
			if(objetos[i]!=null) {
				pesoTotal+=objetos[i].getPeso();
			}
			
		}
		return pesoTotal;
	}
	
	
}
