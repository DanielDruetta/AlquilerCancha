package data;

//orig
import entidades.*;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class DataCliente {

	public int ultimoid() {
		int max = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select max(id) as maximo from cliente");
			rs = stmt.executeQuery();
			rs.beforeFirst();
			rs.next();
			max = rs.getInt("maximo");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return max;
	}

	public Cliente getByUser(Cliente per) {

		Cliente c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,dni,email,celular,usuario,contraseņa from cliente where usuario=? and contraseņa=?");
			stmt.setString(1, per.getUsuario());
			stmt.setString(2, per.getPassword());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				c = new Cliente();
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setEmail(rs.getString("email"));
				c.setDni(rs.getString("dni"));
				c.setCelular(rs.getString("celular"));
				c.setUsuario(rs.getString("usuario"));
				c.setPassword(rs.getString("contraseņa"));
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

		return c;
	}

	public Cliente search(Cliente per) {

		Cliente c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre,apellido,dni,email,celular,usuario from cliente where nombre=? and apellido=?");
			stmt.setString(1, per.getNombre());
			stmt.setString(2, per.getApellido());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				c = new Cliente();
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setEmail(rs.getString("email"));
				c.setDni(rs.getString("dni"));
				c.setCelular(rs.getString("celular"));
				c.setUsuario(rs.getString("usuario"));

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

		return c;
	}

	public void add(Cliente c) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into cliente(id, nombre, apellido, celular, email, usuario, contraseņa, dni) values(?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getNombre());
			stmt.setString(3, c.getApellido());
			stmt.setString(4, c.getCelular());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getUsuario());
			stmt.setString(7, c.getPassword());
			stmt.setString(8, c.getDni());
			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				c.setId(keyResultSet.getInt(1));
			}

		} catch (SQLException e) {
			throw e;
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

	public void delete(Cliente c) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from cliente where dni=?",
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, c.getDni());
			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				c.setId(keyResultSet.getInt(1));
			}

		} catch (SQLException e) {
			throw e;
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

	public Cliente modificarCliente(Cliente nuev, Cliente viej) {

		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"update cliente set nombre=?,apellido=?,dni=?,email=?,celular=?,usuario=?,contraseņa=? where dni=?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nuev.getNombre());
			stmt.setString(2, nuev.getApellido());
			stmt.setString(3, nuev.getDni());
			stmt.setString(4, nuev.getEmail());
			stmt.setString(5, nuev.getCelular());
			stmt.setString(6, nuev.getUsuario());
			stmt.setString(7, nuev.getPassword());
			stmt.setString(8, viej.getDni());

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

		return nuev;
	}

	public Cliente buscarDNI(String dni) {

		Cliente c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select nombre,apellido,celular,email,dni,usuario from cliente where dni=?");
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				c = new Cliente();
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setEmail(rs.getString("email"));
				c.setDni(rs.getString("dni"));
				c.setCelular(rs.getString("celular"));
				c.setUsuario(rs.getString("usuario"));

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

		return c;
	}
	
	
	public ArrayList<Cliente> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			stmt = (Statement) FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select nombre,direccion,hora_inicio,hora_fin,url_mapa from establecimiento");
			
			rs = stmt.executeQuery("select dni, nombre, apellido, celular, email, usuario from cliente");
			if (rs != null) {
				while (rs.next()) {
					Cliente c = new Cliente();
					c.setDni(rs.getString("dni"));
					c.setNombre(rs.getString("nombre"));
					c.setApellido(rs.getString("apellido"));
					c.setCelular(rs.getString("celular"));
					c.setEmail(rs.getString("email"));
					c.setUsuario(rs.getString("usuario"));
					clientes.add(c);
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

		return clientes;
	}

}
