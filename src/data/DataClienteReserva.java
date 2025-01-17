package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.ClienteReserva;
import entidades.Reserva;

public class DataClienteReserva {

	public void add(ClienteReserva cr) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("call futbol.agregar_jugadores(?, ?, ?);");
			stmt.setString(1, cr.getDni());
			stmt.setInt(2, cr.getNumero_reserva());
			stmt.setInt(3, cr.getCantidad_jugadores());
			stmt.executeQuery();

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

	public Cliente modificar(Cliente nuev, Cliente viej) {

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

	public ArrayList<Reserva> reservas(String dni) {

		ArrayList<Reserva> reservas = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select r.establecimiento, r.numero_cancha,r.fecha,r.hora_inicio,r.lugares_disponibles,r.numero_reserva,cr.cantidad_jugadores from cliente_reserva cr inner join reserva r on cr.numero_reserva = r.numero_reserva where cr.dni = ? and r.fecha>=CAST(NOW() as date)");
			stmt.setString(1, dni);
			rs = stmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Reserva o = new Reserva();
					int cantidad_jugadores = rs.getInt("cantidad_jugadores"); // ver este maneje!
					String establecimiento = rs.getString("establecimiento");
					o.setEstablecimiento(String.valueOf(establecimiento) + "xyz" + String.valueOf(cantidad_jugadores));
					o.setNumero_cancha(rs.getInt("numero_cancha"));
					o.setFecha(rs.getDate("fecha"));
					o.setHora_inicio(rs.getInt("hora_inicio"));
					o.setLugares_disponibles(rs.getInt("lugares_disponibles"));
					o.setNumero_reserva(rs.getInt("numero_reserva"));
					reservas.add(o);
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

		return reservas;
	}

	public ClienteReserva search(int numero_reserva, String dni) {

		ClienteReserva cr = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT dni, numero_reserva, cantidad_jugadores FROM cliente_reserva WHERE numero_reserva=? and dni =?");
			stmt.setInt(1, numero_reserva);
			stmt.setString(2, dni);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				cr = new ClienteReserva();
				cr.setDni(rs.getString("dni"));
				cr.setNumero_reserva(rs.getInt("numero_reserva"));
				cr.setCantidad_jugadores(rs.getInt("cantidad_jugadores"));
				;

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

		return cr;
	}

	public void modificar_jugadores_aportados(ClienteReserva cr) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"update cliente_reserva set cantidad_jugadores=? where numero_reserva=? and dni=?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, cr.getCantidad_jugadores());
			stmt.setInt(2, cr.getNumero_reserva());
			stmt.setString(3, cr.getDni());
			stmt.executeUpdate();
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

	public ArrayList<Integer> reservasYaCompletadas(Cliente c) {

		ArrayList<Integer> cr = new ArrayList<Integer>();
		;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select numero_reserva from cliente_reserva where dni=? and cantidad_jugadores>0");
			stmt.setString(1, c.getDni());
			rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					cr.add(rs.getInt("numero_reserva"));
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

		return cr;
	}

	public int cantidad_jugadores_unidos(int nro_reserva) {

		int nro = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select sum(cantidad_jugadores) as sumatoria from cliente_reserva where numero_reserva=?");

			stmt.setInt(1, nro_reserva);

			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {

				nro = rs.getInt("sumatoria");

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

		return nro;
	}

	public boolean tiene_jugadores_unidos(int numero_reserva) {

		boolean respuesta = true;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("SELECT * from cliente_reserva where numero_reserva = ? LIMIT 1");
			stmt.setInt(1, numero_reserva);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				respuesta = false;
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
		System.out.println(respuesta);
		return respuesta;
	}

}
