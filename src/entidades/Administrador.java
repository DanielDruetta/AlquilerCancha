package entidades;

public class Administrador {
	String nombre_usuario;
	String contraseña;
	
	
	public Administrador(String nombre_usuario, String contraseña) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.contraseña = contraseña;
	}
	
	
	public Administrador() {

	}


	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	
}
