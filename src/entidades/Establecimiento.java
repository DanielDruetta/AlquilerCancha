package entidades;

public class Establecimiento {
String nombre;
String direccion;
int hora_inicio;
int hora_fin;
String usuario;
String contraseña;
String url_mapa;



public Establecimiento() {
	super();
}


public Establecimiento(String nombre, String direccion, int hora_inicio, int hora_fin, String usuario,
		String contraseña, String url_mapa) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.hora_inicio = hora_inicio;
	this.hora_fin = hora_fin;
	this.usuario = usuario;
	this.contraseña = contraseña;
	this.url_mapa = url_mapa;
}

public Establecimiento(String nombre, String direccion, int hora_inicio, int hora_fin, String usuario,
		String contraseña) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.hora_inicio = hora_inicio;
	this.hora_fin = hora_fin;
	this.usuario = usuario;
	this.contraseña = contraseña;
	
}



public String getUrl_mapa() {
	return url_mapa;
}


public void setUrl_mapa(String url_mapa) {
	this.url_mapa = url_mapa;
}


public Establecimiento(String nombre) {
	super();
	this.nombre = nombre;
}


public String getUsuario() {
	return usuario;
}


public String getContraseña() {
	return contraseña;
}


public void setUsuario(String usuario) {
	this.usuario = usuario;
}


public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
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
			+ ", hora_fin=" + hora_fin + ", usuario=" + usuario + ", contraseña=" + contraseña + "]";
}


}

