package data;

import entidades.*;

import java.sql.*;

public class DataAdministrador {

	public Administrador getByUser(Administrador adm) {

		Administrador a = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre_usuario,contraseña from administrador where nombre_usuario=? and contraseña=?");
			stmt.setString(1, adm.getNombre_usuario());
			stmt.setString(2, adm.getContraseña());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				a = new Administrador();
				a.setNombre_usuario(rs.getString("nombre_usuario"));
				a.setContraseña(rs.getString("contraseña"));


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

		return a;
	}

}
