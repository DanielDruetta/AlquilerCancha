package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import entidades.Mantenimiento;

public class DataMantenimiento {
	
	public void add(Mantenimiento m) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into mantenimiento(establecimiento, numero_cancha, fecha_desde, fecha_hasta, descripcion, observaciones) values(?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, m.getEstablecimiento());
			stmt.setInt(2, m.getNumeroCancha());
			stmt.setDate(3, m.getFechaInicio());
			stmt.setDate(4, m.getFechaFin());
			stmt.setString(5, m.getDescripcion());
			stmt.setString(6, m.getObservaciones());
		
			stmt.executeUpdate();


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
