package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public ArrayList<Mantenimiento> mantenimientos(String establecimiento) {

		ArrayList<Mantenimiento> mantenimientos = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT establecimiento,numero_cancha,fecha_desde,fecha_hasta,descripcion,observaciones FROM mantenimiento m WHERE m.fecha_hasta>=NOW() and establecimiento=? order by m.fecha_desde ");

			stmt.setString(1, establecimiento);
			rs = stmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					Mantenimiento m = new Mantenimiento();
					m.setEstablecimiento(rs.getString("establecimiento"));
					m.setNumeroCancha(rs.getInt("numero_cancha"));
					m.setFechaInicio(rs.getDate("fecha_desde"));
					m.setFechaFin(rs.getDate("fecha_hasta"));
					m.setDescripcion(rs.getString("descripcion"));
					m.setObservaciones(rs.getString("observaciones"));
					mantenimientos.add(m);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mantenimientos;
	}

	public void delete(Mantenimiento man) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from mantenimiento where establecimiento=? and numero_cancha=? and fecha_desde=?",
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, man.getEstablecimiento());
			stmt.setInt(2, man.getNumeroCancha());
			stmt.setDate(3, man.getFechaInicio());
			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {

			}

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
