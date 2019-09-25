package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entidades.Establecimiento;

public class DataEstablecimiento {

	
	
	public ArrayList<Establecimiento> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Establecimiento> establecimientos= new ArrayList<>();
		
		try {
			stmt=(Statement) FactoryConexion.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery(
					"select nombre,direccion,hora_inicio,hora_fin from establecimiento");
			if(rs!=null) {
				while(rs.next()) {
					Establecimiento c=new Establecimiento();
					c.setNombre(rs.getString("nombre"));
					c.setDireccion(rs.getString("direccion"));
					c.setHora_inicio(rs.getInt("hora_inicio"));
					c.setHora_fin(rs.getInt("hora_fin"));
					establecimientos.add(c);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return establecimientos;
	}
	
	
	public void add(Establecimiento c) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into establecimiento(nombre, direccion, hora_inicio, hora_fin, usuario, contraseña) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			stmt.setString(1, c.getNombre());
			stmt.setString(2, c.getDireccion());
			stmt.setInt(3, c.getHora_inicio());
			stmt.setInt(4, c.getHora_fin());
			stmt.setString(5, c.getUsuario());
			stmt.setString(6, c.getContraseña());
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
	
	
public Establecimiento getByUser(Establecimiento per) {
		
		Establecimiento c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre,direccion,hora_inicio,hora_fin,usuario,contraseña from establecimiento where usuario=? and contraseña=?"
					);
			stmt.setString(1, per.getUsuario());
			stmt.setString(2, per.getContraseña());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				c=new Establecimiento();
				c.setNombre(rs.getString("nombre"));
				c.setDireccion(rs.getString("direccion"));
				
				c.setHora_inicio(rs.getInt("hora_inicio"));
				c.setHora_fin(rs.getInt("hora_fin"));
				
				c.setUsuario(rs.getString("usuario"));
				c.setContraseña(rs.getString("contraseña"));
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
		
		return c;
	}
	
public Establecimiento buscarEst(String establecimiento) {
	
	Establecimiento c=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"select nombre,direccion,hora_inicio,hora_fin from establecimiento where nombre=?"
				);
		stmt.setString(1, establecimiento);
	
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			
			c=new Establecimiento();
			c.setNombre(rs.getString("nombre"));
			c.setDireccion(rs.getString("direccion"));
			
			c.setHora_inicio(rs.getInt("hora_inicio"));
			c.setHora_fin(rs.getInt("hora_fin"));
			
			
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
	
	return c;
}

public int cantidadCanchas(String establecimiento) {
	
	int cantidad=0;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"SELECT max(c.numero) from cancha c inner join establecimiento es on c.establecimiento = es.nombre where es.nombre=?"
				);
		
		stmt.setString(1, establecimiento);
	
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			
		cantidad=rs.getInt("max(c.numero)");
		
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
	
	return cantidad;
}

}
