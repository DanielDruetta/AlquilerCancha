package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Precio;

public class DataPrecio {

	public void add(Precio p) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into precio(establecimiento, numero_cancha,fecha_desde, precio) values(?,?,current_date(),?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getEstablecimiento());
			stmt.setInt(2, p.getNumero_cancha());
			stmt.setDouble(3, p.getPrecio());
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

	public Precio obtenerPrecio(String establecimiento, int numero) {
		Precio pr = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("call futbol.devolver_precio(?, ?);");
			stmt.setString(1, establecimiento);
			stmt.setInt(2, numero);
			rs = stmt.executeQuery();

			if (rs != null && rs.next()) {
				pr = new Precio();
				pr.setEstablecimiento(rs.getString("p.establecimiento"));
				pr.setNumero_cancha(rs.getInt("p.numero_cancha"));
				pr.setFecha_desde(rs.getDate("p.fecha_desde"));
				pr.setPrecio(rs.getDouble("p.precio"));

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

		return pr;

	}

}
