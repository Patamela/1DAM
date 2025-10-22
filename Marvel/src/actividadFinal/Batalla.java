package actividadFinal;

import java.time.LocalDate;

public class Batalla {
	private LocalDate fecha;
	private String lugar;
	private int ganador;
	private int perdedor;
	
	public Batalla(LocalDate fecha, String lugar) {
		this.fecha = fecha;
		this.lugar = lugar;
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public int getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(int perdedor) {
		this.perdedor = perdedor;
	}
	
	
	
	
	
	
}
