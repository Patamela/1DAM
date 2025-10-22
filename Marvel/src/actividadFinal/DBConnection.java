package actividadFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class DBConnection {
	private Connection conn = null;
	
	public DBConnection() {
		conectar();
	}
	
	public void conectar() {
		if(conn==null) {
			String url = "jdbc:mysql://localhost:3306/marvel";
			String root = "root";
			String password="";
			
			try {
				conn = DriverManager.getConnection(url,root,password);
				if(conn!=null) {
					System.out.println("Conexión a base de datos tema9 lista.");
				}
			} catch (SQLException e) {
				System.out.println("Error al conectar o ejecutar la consulta.");
			}
			
			
		}
	}
	
	public void desconectar() {
		conn=null;
	}
	
	//*******************************Metodos de Personajes*****************************
	public boolean ingresarPersonaje(Personaje p) {
		int resultado = 0;
		boolean flag = false;
		try {
			Statement stat = conn.createStatement();
			String sql = "INSERT INTO personaje(nombre,poderes,mascara,capa,rol) VALUE("
					+ "'"+p.getNombre()+"',"
					+ "'"+p.getPoderes()+"',"
					+ ""+p.isMascara()+","
					+ ""+p.isCapa()+","
					+ "'"+p.getTipo()+"');";
			resultado = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultado>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public boolean eliminarPersonaje(int id) {
		int resultado = 0;
		boolean flag = false;
		try {
			Statement stat = conn.createStatement();
			String sql = "DELETE FROM personaje WHERE id="+id+";";
			resultado = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultado>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public boolean modificaPersonaje(int id, Personaje p) {
		int resultado = 0;
		boolean flag = false;
		try {
			Statement stat = conn.createStatement();
			String sql="UPDATE personaje SET nombre='"+p.getNombre()
			+ "',poderes='"+p.getPoderes()
			+ "',mascara="+p.isMascara()
			+ ",capa="+p.isCapa()
			+",rol='"+p.getTipo()
			+ "' WHERE id="+id+";";
			resultado = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultado>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public ArrayList<String> listarTodosPersonajes() {
		ArrayList<String> personajes = new ArrayList<>();
		String masc="";
		String cap ="";
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT id,nombre,poderes,mascara,capa,rol FROM personaje;";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String poderes = rs.getString("poderes");
				boolean mascara = rs.getBoolean("mascara");
				boolean capa = rs.getBoolean("capa");
				String rol = rs.getString("rol");
				if(mascara) {
					 masc = "si";
				}else {
					masc = "no";
				}
				
				if(capa) {
					 cap = "si";
				}else {
					cap = "no";
				}
				
				String p = "Id: "+id+"\nNombre: "+nombre+"\nPoderes: "+poderes+"\nMascara: "+masc+"\nCapa: "+cap+"\nRol: "+rol+"\n________________________";
				personajes.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personajes;
	}
	
	//****************************Metodos de batallas**********************
	
	public boolean ingresarBatallas(Batalla b) {
		int resultado = 0;
		boolean flag = false;
		try {
			Statement stat = conn.createStatement();
			String sql = "INSERT INTO batalla(fecha,lugar,id_ganador,id_perdedor) VALUE("
					+ "'"+b.getFecha()+"',"
					+ "'"+b.getLugar()+"',"
					+ "'"+b.getGanador()+"',"
					+ "'"+b.getPerdedor()+"');";
			resultado = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultado>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public ArrayList<String> listarTodasBatallas() {
		ArrayList<String> batallas = new ArrayList<>();
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT id,fecha,lugar,id_ganador,id_perdedor FROM batalla;";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fecha = rs.getString("fecha");
				String lugar = rs.getString("lugar");
				int id_ganador = rs.getInt("id_ganador");
				int id_perdedor = rs.getInt("id_perdedor");
				
				String b = "Id: "+id+"\nNombre: "+fecha+"\nPoderes: "+lugar+"\nMascara: "+id_ganador+"\nCapa: "+id_perdedor+"\n________________________";
				batallas.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return batallas;
	}
	
	public ArrayList<String> listarTodasBatallasGanador(int p_id) {
		ArrayList<String> batallasG = new ArrayList<>();
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT id,fecha,lugar,id_perdedor FROM batalla WHERE id_ganador="+p_id+";";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fecha = rs.getString("fecha");
				String lugar = rs.getString("lugar");
				int id_perdedor = rs.getInt("id_perdedor");
				
				String b = "Id: "+id+"\nNombre: "+fecha+"\nPoderes: "+lugar+"\nCapa: "+id_perdedor+"\n________________________";
				batallasG.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return batallasG;
	}
	
	public ArrayList<String> listarTodasBatallasPerdedor(int p_id) {
		ArrayList<String> batallasP = new ArrayList<>();
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT id,fecha,lugar,id_ganador FROM batalla WHERE id_perdedor="+p_id+";";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fecha = rs.getString("fecha");
				String lugar = rs.getString("lugar");
				int id_ganador = rs.getInt("id_ganador");
				
				String b = "Id: "+id+"\nNombre: "+fecha+"\nPoderes: "+lugar+"\nCapa: "+id_ganador+"\n________________________";
				batallasP.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return batallasP;
		
	}
	
	public String verficarPersonaje(int id) {
		String rol="";
		conectar();
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT rol FROM personaje WHERE id="+id+";";
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				rol = rs.getString("rol");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rol;
	}
	
	

}
