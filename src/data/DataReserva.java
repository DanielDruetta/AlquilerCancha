package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.*;


public class DataReserva {
	
	public int ultimoid(){
		int max=0;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select max(numero_reserva) as maximo from reserva");
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

	public void add(Reserva r) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into reserva(numero_reserva, fecha, hora_inicio, establecimiento, numero_cancha, dni) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, r.getNumero_reserva());
			stmt.setDate(2, r.getFecha());
			stmt.setInt(3, r.getHora_inicio());
			stmt.setString(4, r.getEstablecimiento());
			stmt.setInt(5, r.getNumero_cancha());
			stmt.setString(6, r.getDni());
		
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
               
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                FactoryConexion.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }
	
	
}
