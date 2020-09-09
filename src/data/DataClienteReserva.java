package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.ClienteReserva;

public class DataClienteReserva {
	
	
	public void add(ClienteReserva cr) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("call futbol.agregar_jugadores(?, ?, ?);");
			stmt.setString(1, cr.getDni());
			stmt.setInt(2, cr.getNumero_reserva());
			stmt.setInt(3, cr.getCantidad_jugadores());
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (keyResultSet != null)
					keyResultSet.close();
				if (stmt != null)
					stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
