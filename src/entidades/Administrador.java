package entidades;

public class Administrador {
	String nombre_usuario;
	String contrase�a;
	
	
	public Administrador(String nombre_usuario, String contrase�a) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.contrase�a = contrase�a;
	}
	
	
	public Administrador() {

	}


	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	
	
}
