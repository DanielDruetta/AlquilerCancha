package entidades;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

public class Establecimiento {
String nombre;
String direccion;
int hora_inicio;
int hora_fin;
String usuario;
String contrase�a;



public Establecimiento() {
	super();
}


public Establecimiento(String nombre, String direccion, int hora_inicio, int hora_fin, String usuario,
		String contrase�a) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.hora_inicio = hora_inicio;
	this.hora_fin = hora_fin;
	this.usuario = usuario;
	this.contrase�a = contrase�a;
}



public String getUsuario() {
	return usuario;
}


public String getContrase�a() {
	return contrase�a;
}


public void setUsuario(String usuario) {
	this.usuario = usuario;
}


public void setContrase�a(String contrase�a) {
	this.contrase�a = contrase�a;
}


public String getNombre() {
	return nombre;
}
public String getDireccion() {
	return direccion;
}
public int getHora_inicio() {
	return hora_inicio;
}
public int getHora_fin() {
	return hora_fin;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public void setHora_inicio(int hora_inicio) {
	this.hora_inicio = hora_inicio;
}
public void setHora_fin(int hora_fin) {
	this.hora_fin = hora_fin;
}


@Override
public String toString() {
	return "Establecimiento [nombre=" + nombre + ", direccion=" + direccion + ", hora_inicio=" + hora_inicio
			+ ", hora_fin=" + hora_fin + ", usuario=" + usuario + ", contrase�a=" + contrase�a + "]";
}


}

