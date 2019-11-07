package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Cancha;
import entidades.Precio;

public class DataPrecio {

	public void add(Precio p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into precio(establecimiento, numero_cancha, precio) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getEstablecimiento());
			stmt.setInt(2, p.getNumero_cancha());
			stmt.setDouble(3, p.getPrecio());
			stmt.executeUpdate();

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
