package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Cancha;
import entidades.Cliente;
import entidades.Precio;

public class DataPrecio {

	public void add(Precio p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into precio(establecimiento, numero_cancha,fecha_desde, precio) values(?,?,current_date(),?)",
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
	
	
	
public int obtenerPrecio(String establecimiento, int numero) {
		
		int precio=0;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"DROP TEMPORARY TABLE IF EXISTS precios; CREATE TEMPORARY TABLE precios SELECT establecimiento, numero_cancha, MAX(fecha_desde) as Fechita FROM precio group by establecimiento, numero_cancha; SELECT p.establecimiento, p.numero_cancha, p.fecha_desde, p.precio FROM precio p  INNER JOIN precios pre ON p.establecimiento = pre.establecimiento and p.numero_cancha = pre.numero_cancha and p.fecha_desde = pre.Fechita where p.establecimiento=? and p.numero_cancha=? group by p.establecimiento, p.numero_cancha, p.fecha_desde;"
					);
			stmt.setString(1, establecimiento);
			stmt.setInt(2, numero);
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				
				precio= rs.getInt("precio");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return precio;
		
	}
	
}
