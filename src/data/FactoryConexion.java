package data;

import java.sql.*;

public class FactoryConexion {

	private static FactoryConexion instancia;
	
	private String driver = "com.mysql.jdbc.Driver";
	private String host = "node68248-alquilazo.jelastic.saveincloud.net";
	private String port = "3306";
	private String user = "root";
	private String password = "MGXZHG1Wy0";
	private String db = "futbol";
	private int conectados = 0;
	private Connection conn = null;
/*
	private String driver = "com.mysql.jdbc.Driver";
	private String host = "localhost";
	private String port = "3306";
	private String user = "root";
	//private String password = "admin";
	private String password = "password";
	private String db = "futbol";
	private int conectados = 0;
	private Connection conn = null;
*/
	private FactoryConexion() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static FactoryConexion getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConexion();
		}
		return instancia;
	}

	public Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, password);
				conectados = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}

	public void releaseConn() {
		conectados--;
		try {
			if (conectados <= 0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}