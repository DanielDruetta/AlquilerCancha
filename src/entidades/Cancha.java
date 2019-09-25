package entidades;

public class Cancha {
int numero;
String descripcion;
int tipo;
String luz;
String establecimiento;
String direccion;


public Cancha() {
	super();
}

public Cancha(int numero, String descripcion, int tipo, String luz, String establecimiento) {
	super();
	this.numero = numero;
	this.descripcion = descripcion;
	this.tipo = tipo;
	this.luz = luz;
	this.establecimiento = establecimiento;
}

public String getDireccion() {
	return direccion;
}



public int getNumero() {
	return numero;
}
public String getDescripcion() {
	return descripcion;
}
public int getTipo() {
	return tipo;
}
public String isLuz() {
	return luz;
}
public String getEstablecimiento() {
	return establecimiento;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public void setTipo(int tipo) {
	this.tipo = tipo;
}
public void setLuz(String luz) {
	this.luz = luz;
}
public void setEstablecimiento(String establecimiento) {
	this.establecimiento = establecimiento;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}

@Override
public String toString() {
	return "Cancha [numero=" + numero + ", descripcion=" + descripcion + ", tipo=" + tipo + ", luz=" + luz
			+ ", establecimiento=" + establecimiento + ", direccion=" + direccion + "]";
}




}
