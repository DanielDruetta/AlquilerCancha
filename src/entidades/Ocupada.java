package entidades;

public class Ocupada {
int numero;
int hora_inicio;
String estado;
String descripcion;
int tipo;

public Ocupada() {
	super();
}



public Ocupada(int numero, int hora_inicio, String estado, String descripcion, int tipo) {
	super();
	this.numero = numero;
	this.hora_inicio = hora_inicio;
	this.estado = estado;
	this.descripcion = descripcion;
	this.tipo = tipo;
}



public int getTipo() {
	return tipo;
}



public void setTipo(int tipo) {
	this.tipo = tipo;
}



public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


public String getEstado() {
	return estado;
}


public void setEstado(String estado) {
	this.estado = estado;
}


public int getNumero() {
	return numero;
}
public int getHora_inicio() {
	return hora_inicio;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public void setHora_inicio(int hora_inicio) {
	this.hora_inicio = hora_inicio;
}


@Override
public String toString() {
	return "Ocupada [numero=" + numero + ", hora_inicio=" + hora_inicio + ", estado=" + estado + ", descripcion="
			+ descripcion + "]";
}





}
