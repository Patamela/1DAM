package juegoAhorcado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBConnection {
	Connection conn = null;
	
	public DBConnection() {
		conectar();
	}
	
	public void conectar() {
		if(conn==null) {
			String url = "jdbc:mysql://localhost:3306/ahorcado";
			String user = "root";
			String passw = "";
			
			try {
				conn = DriverManager.getConnection(url,user,passw);
			} catch (SQLException e) {
				System.out.println("Fallo al conectar con la base de datos");
			}
		}
	}
	
	public void desconectar() {
		conn=null;
	}
	
	public boolean registrarJugador(Jugador j) {
		conectar();
		int resultado = -1;
		boolean correcto = false;
		try {
			Statement stat = conn.createStatement();
			String sql="INSERT INTO jugador(nombre,contraseña) VALUES ('"+j.getNombre()+"','"+j.getContrasenia()+"');";
			resultado = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			desconectar();
		}
		if(resultado>0) {
			correcto=true;
		}
		return correcto;
	}
	
	public boolean iniciarSesionJugador(Jugador j) {
		conectar();
		boolean correcto = false;
		String contrasenia = "";
		String nombre = "";
		try {
			Statement stat = conn.createStatement();
			String sql="SELECT nombre, contraseña FROM jugador WHERE nombre='"+j.getNombre()+"' AND contraseña='"+j.getContrasenia()+"';";
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				nombre = rs.getString("nombre");
				contrasenia = rs.getString("contraseña");
				correcto = true;
			}
		} catch (SQLException e) {
			return correcto;
		}finally {
			desconectar();
		}
		return correcto;
	}
	
	//agregar palabra
	public boolean agregarPalabra(String palabra, String tematica, String dificultad) {
		conectar();
		boolean flag = false;
		int resultado = 0;
		try {
			Statement stat = conn.createStatement();
			String sql = "INSERT INTO palabras(palabra, tematica, dificultad) VALUES("
					+ "'"+palabra+"',"
					+ "'"+tematica+"',"
					+ "'"+dificultad+"');";
			resultado = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error al introducir la palabra");
		}finally {
			desconectar();
		}
		if(resultado>0) {
			flag = true;
		}
		return flag;
	}
	//jugar que implica que me de una palabra al azar
	public String jugar(String tematica, String dificultad) {
		conectar();
		String palabra = "";
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT palabra FROM palabras WHERE tematica='"+tematica+"' AND dificultad='"+dificultad+"';";
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				palabra = rs.getString("palabra");
			}
		} catch (SQLException e) {
			System.out.println("No se ha encontrado la palabra o todavia no existe, con esas características.");
		}finally {
			desconectar();
		}
		return palabra;
	}
	//guardado de partida de cada usuario
	public boolean guardarPartida(int id_persona, int id_palabra, int intentos, boolean estado) {
		conectar();
		boolean flag = false;
		int resultado = 0;
		try {
			Statement stat = conn.createStatement();
			String sql = "INSERT INTO partida(id_jugador,id_palabra,intentos,victoria,fecha) VALUES("
					+ ""+id_persona+","+id_palabra+","
					+ ""+intentos+","+estado+",'"+LocalDate.now()+"');";
			resultado = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			desconectar();
		}
		if(resultado>0) {
			flag = true;
		}
		return flag;
	}
	
	//obtener la id del jugador
	public int obtencionIdJugador(String nombre, String contrasenia) {
		conectar();
		int id = 0;
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT id FROM jugador WHERE nombre='"+nombre+"' AND contraseña='"+contrasenia+"';";
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			//System.out.println("No se ha encontrado el jugador con ese nombre y contraseña.");
			e.printStackTrace();
		}finally {
			desconectar();
		}
		return id;
	}
	
	//mostrar las partidas hechas por un jugador ArrayList<String>
	public ArrayList<Partida> mostrarPartidas(int id_jugador){
		conectar();
		ArrayList<Partida> partidas = new ArrayList<>();
		String palabra = "";
		String fecha = "";
		int intentos = 0;
		boolean victoria = false;
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT a.palabra, b.fecha, b.intentos, b.victoria "
					+ "FROM partida b INNER JOIN palabras a "
					+ "ON b.id_palabra = a.id "
					+ "WHERE id_jugador="+id_jugador+";";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				palabra = rs.getString("a.palabra");
				fecha = rs.getString("b.fecha");
				LocalDate date = fechaTransformada(fecha);
				intentos = rs.getInt("b.intentos");
				victoria = rs.getBoolean("b.victoria");
				Partida p = new Partida(palabra,date,intentos,victoria);
				partidas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			desconectar();
		}
		
		return partidas;
	}

	private LocalDate fechaTransformada(String fecha) {
		int anio = Integer.parseInt(fecha.substring(0, fecha.indexOf("-")));
		int mes = Integer.parseInt(fecha.substring(fecha.indexOf("-")+1,fecha.lastIndexOf("-")));
		int dia = Integer.parseInt(fecha.substring(fecha.lastIndexOf("-")+1));
		return LocalDate.of(anio, mes, dia);
	}
	
	public int obtenerPalabraId(String palabra) {
		conectar();
		int id = 0;
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT id FROM palabras WHERE palabra='"+palabra+"';";
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar la id de la palabra.");
		}finally {
			desconectar();
		}
		return id;
	}
	
}
