package entidades;

public class Cliente {
	int id;
String dni;
String nombre;
String apellido;
String celular;
String email;
String usuario;
String password;


public Cliente() {
	super();
}


public Cliente(int id, String dni, String nombre, String apellido, String celular, String email, String usuario,
		String password) {
	super();
	this.id = id;
	this.dni = dni;
	this.nombre = nombre;
	this.apellido = apellido;
	this.celular = celular;
	this.email = email;
	this.usuario = usuario;
	this.password = password;
}





public Cliente(String dni, String nombre, String apellido, String celular, String email, String usuario,
		String password) {
	super();
	this.dni = dni;
	this.nombre = nombre;
	this.apellido = apellido;
	this.celular = celular;
	this.email = email;
	this.usuario = usuario;
	this.password = password;
}


public Cliente(String dni, String nombre, String apellido, String celular, String email, String usuario) {
	super();
	this.dni = dni;
	this.nombre = nombre;
	this.apellido = apellido;
	this.celular = celular;
	this.email = email;
	this.usuario = usuario;
}


public Cliente(String nombre, String apellido) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getUsuario() {
	return usuario;
}

public String getPassword() {
	return password;
}


public String getDni() {
	return dni;
}
public String getNombre() {
	return nombre;
}
public String getApellido() {
	return apellido;
}
public String getCelular() {
	return celular;
}
public String getEmail() {
	return email;
}
public void setDni(String dni) {
	this.dni = dni;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public void setCelular(String celular) {
	this.celular = celular;
}
public void setEmail(String email) {
	this.email = email;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", celular=" + celular + ", email="
			+ email + ", usuario=" + usuario + ", password=" + password + "]";
}


}


