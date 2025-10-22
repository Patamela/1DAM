package juegoAhorcado;

import java.time.LocalDate;

public class Partida {
	private String palabra;
	private LocalDate fecha;
	private int intentos;
	private boolean superado;
	
	public Partida(String palabra, LocalDate fecha, int intentos,boolean superado) {
		this.palabra = palabra;
		this.fecha = fecha;
		this.intentos = intentos;
		this.superado=superado;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	public boolean isSuperado() {
		return superado;
	}
	public void setSuperado(boolean superado) {
		this.superado = superado;
	}
	
	
	
}