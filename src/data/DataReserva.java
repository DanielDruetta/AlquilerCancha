package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.*;

public class DataReserva {

	public int ultimoid() {
		int max = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select max(numero_reserva) as maximo from reserva");
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

	public void add(Reserva r) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into reserva(numero_reserva, fecha, hora_inicio, establecimiento, numero_cancha, dni, lugares_disponibles) values(?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, r.getNumero_reserva());
			stmt.setDate(2, r.getFecha());
			stmt.setInt(3, r.getHora_inicio());
			stmt.setString(4, r.getEstablecimiento());
			stmt.setInt(5, r.getNumero_cancha());
			stmt.setString(6, r.getDni());
			stmt.setInt(7, r.getLugares_disponibles());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {

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

	public ArrayList<Reserva> reservasDia(String establecimiento) {

		ArrayList<Reserva> reservas = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT numero_reserva, r.hora_inicio, numero_cancha, r.dni FROM reserva r inner join establecimiento es on r.establecimiento = es.nombre where r.fecha=CAST(NOW() as date) and es.nombre=? order by r.hora_inicio");

			stmt.setString(1, establecimiento);
			rs = stmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					Reserva o = new Reserva();
					o.setNumero_reserva(rs.getInt("numero_reserva"));
					o.setHora_inicio(rs.getInt("hora_inicio"));
					o.setNumero_cancha(rs.getInt("numero_cancha"));
					o.setDni(rs.getString("r.dni"));
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

	public ArrayList<Reserva> reservasMes(String establecimiento) {

		ArrayList<Reserva> reservas = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT numero_reserva, r.hora_inicio, numero_cancha, r.dni,r.fecha FROM reserva r inner join establecimiento es on r.establecimiento = es.nombre where month(r.fecha)=month(NOW()) and year(r.fecha)=year(NOW()) and es.nombre=? order by r.fecha,r.hora_inicio");

			stmt.setString(1, establecimiento);
			rs = stmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					Reserva o = new Reserva();
					o.setNumero_reserva(rs.getInt("numero_reserva"));
					o.setHora_inicio(rs.getInt("hora_inicio"));
					o.setNumero_cancha(rs.getInt("numero_cancha"));
					o.setDni(rs.getString("r.dni"));
					o.setFecha(rs.getDate("r.fecha"));
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

	public ArrayList<Reserva> reservasCliente(String dni) {

		ArrayList<Reserva> reservas = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT r.numero_reserva,r.fecha, r.hora_inicio, r.numero_cancha, r.establecimiento,r.dni FROM reserva r inner join cliente cli on r.dni = cli.dni where r.dni=? and r.fecha>=CAST(NOW() as date) order by r.fecha,r.hora_inicio");

			stmt.setString(1, dni);
			rs = stmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					Reserva o = new Reserva();
					o.setNumero_reserva(rs.getInt("numero_reserva"));
					o.setHora_inicio(rs.getInt("hora_inicio"));
					o.setNumero_cancha(rs.getInt("numero_cancha"));
					o.setDni(rs.getString("r.dni"));
					o.setEstablecimiento(rs.getString("r.establecimiento"));
					o.setFecha(rs.getDate("r.fecha"));
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

	public void eliminarReserva(String numero_reserva) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from reserva where numero_reserva=?", PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, numero_reserva);
			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
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

	public ArrayList<Reserva> reservasAcompletar() {

		ArrayList<Reserva> reservas = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT numero_reserva,fecha,hora_inicio, numero_cancha, establecimiento, lugares_disponibles FROM reserva WHERE fecha>=CAST(NOW() as date) and lugares_disponibles!=0 order by fecha,hora_inicio");

			rs = stmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					Reserva o = new Reserva();
					o.setNumero_reserva(rs.getInt("numero_reserva"));
					o.setHora_inicio(rs.getInt("hora_inicio"));
					o.setNumero_cancha(rs.getInt("numero_cancha"));
					o.setEstablecimiento(rs.getString("establecimiento"));
					o.setFecha(rs.getDate("fecha"));
					o.setLugares_disponibles(rs.getInt("lugares_disponibles"));
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

	public Reserva search(int numero_reserva) {

		Reserva r = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select numero_reserva,establecimiento,fecha,hora_inicio,numero_cancha,dni,lugares_disponibles from reserva where numero_reserva=?");
			stmt.setInt(1, numero_reserva);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				r = new Reserva();
				r.setNumero_reserva(rs.getInt("numero_reserva"));
				r.setEstablecimiento(rs.getString("establecimiento"));
				r.setFecha(rs.getDate("fecha"));
				r.setHora_inicio(rs.getInt("hora_inicio"));
				r.setNumero_cancha(rs.getInt("numero_cancha"));
				r.setDni(rs.getString("dni"));
				r.setLugares_disponibles(rs.getInt("lugares_disponibles"));

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

		return r;
	}

	public void modificar_cantidad_jugadores(Reserva r) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"update reserva set lugares_disponibles=? where numero_reserva=?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, r.getLugares_disponibles());
			stmt.setInt(2, r.getNumero_reserva());
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
