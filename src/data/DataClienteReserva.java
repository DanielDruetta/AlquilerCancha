package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.ClienteReserva;
import entidades.Reserva;

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
	
	public ArrayList<Reserva> reservas(String dni) {

		ArrayList<Reserva> reservas = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select r.establecimiento, r.numero_cancha,r.fecha,r.hora_inicio,r.lugares_disponibles,cr.cantidad_jugadores from cliente_reserva cr inner join reserva r on cr.numero_reserva = r.numero_reserva where cr.dni = ? and r.fecha>=CAST(NOW() as date)");
			stmt.setString(1, dni);
			rs = stmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {

					Reserva o = new Reserva();
					o.setEstablecimiento(rs.getString("establecimiento"));
					o.setNumero_cancha(rs.getInt("numero_cancha"));
					o.setFecha(rs.getDate("fecha"));
					o.setHora_inicio(rs.getInt("hora_inicio"));
					o.setLugares_disponibles(rs.getInt("lugares_disponibles"));
					o.setNumero_reserva(rs.getInt("cantidad_jugadores")); // aca el numero de reserva del objeto reserva, representa a la cantidad de jugadores que aporto el cliente a la reserva
			
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


}
