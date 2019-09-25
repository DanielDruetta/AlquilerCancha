package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import entidades.Cancha;
import entidades.Cliente;
import entidades.Establecimiento;
import entidades.Ocupada;
public class DataCancha {


	public ArrayList<Cancha> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Cancha> canchas= new ArrayList<>();
		
		try {
			stmt=(Statement) FactoryConexion.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery(
					"select cancha.establecimiento,numero,descripcion,tipo,luz,direccion from cancha inner join establecimiento on establecimiento.nombre=cancha.establecimiento");
			if(rs!=null) {
				while(rs.next()) {
					Cancha c=new Cancha();
					c.setEstablecimiento(rs.getString("establecimiento"));
					c.setNumero(rs.getInt("numero"));
					c.setDescripcion(rs.getString("descripcion"));
					c.setTipo(rs.getInt("tipo"));
					c.setDireccion(rs.getString("direccion"));
					canchas.add(c);
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
		
		
		return canchas;
	}
	
	public void add(Cancha c) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().
					prepareStatement(
							"insert into cancha(establecimiento, numero, descripcion, tipo, luz) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, c.getEstablecimiento());
			stmt.setInt(2, c.getNumero());
			stmt.setString(3, c.getDescripcion());
			stmt.setInt(4, c.getTipo());
			stmt.setString(5, c.isLuz());
			
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
	
	public ArrayList<Ocupada> buscarFechaEstablecimiento(String establecimiento, String fecha, int tipo) {
		
		ArrayList<Ocupada> ocupadas= new ArrayList<>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT c.numero, c.descripcion, c.luz, c.tipo, res.fecha, res.hora_inicio FROM cancha c inner join establecimiento es on c.establecimiento = es.nombre inner join reserva res on res.establecimiento = es.nombre and res.numero_cancha=c.numero where es.nombre=? and c.tipo=? and res.fecha=?"
					);
			
			stmt.setString(1, establecimiento);
			stmt.setInt(2, tipo);
			stmt.setString(3, fecha);
			rs=stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					
					Ocupada o=new Ocupada();
					o.setNumero(rs.getInt("numero"));
					o.setHora_inicio(rs.getInt("hora_inicio"));
					o.setEstado("O");
					o.setDescripcion(rs.getString("descripcion"));
					o.setTipo(rs.getInt("tipo"));
					ocupadas.add(o);
				
				}
			
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
		
		return ocupadas;
	}
	
	public String descripcion(String establecimiento,int numero) {
		
		String descripcion=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT c.descripcion from cancha c inner join establecimiento es on c.establecimiento = es.nombre where es.nombre=? and c.numero=?"
					);
			
			stmt.setString(1, establecimiento);
			stmt.setInt(2, numero);
		
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				
			descripcion=rs.getString("descripcion");
			
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
		
		return descripcion;
	}

public int tipoSegunNroCancha(int numero, String establecimiento) {
		
		int tipo=0;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT tipo from cancha where establecimiento=? and numero=?"
					);
			
			stmt.setString(1, establecimiento);
			stmt.setInt(2, numero);
		
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				
			tipo=rs.getInt("tipo");
			
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
		
		return tipo;
	}
}
