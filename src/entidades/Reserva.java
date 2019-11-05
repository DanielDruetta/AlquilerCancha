package entidades;

import java.sql.Date;

public class Reserva {
int numero_reserva;
Date fecha;
int hora_inicio;
String establecimiento;
int numero_cancha;
String dni;




public Reserva() {
	super();
}


public Reserva(int numero_reserva, Date fecha, int hora_inicio, String establecimiento, int numero_cancha, String dni) {
	super();
	this.numero_reserva = numero_reserva;
	this.fecha = fecha;
	this.hora_inicio = hora_inicio;
	this.establecimiento = establecimiento;
	this.numero_cancha = numero_cancha;
	this.dni = dni;
}


public int getNumero_reserva() {
	return numero_reserva;
}


public void setNumero_reserva(int numero_reserva) {
	this.numero_reserva = numero_reserva;
}


public Date getFecha() {
	return fecha;
}


public void setFecha(Date fecha) {
	this.fecha = fecha;
}


public int getHora_inicio() {
	return hora_inicio;
}


public void setHora_inicio(int hora_inicio) {
	this.hora_inicio = hora_inicio;
}


public String getEstablecimiento() {
	return establecimiento;
}


public void setEstablecimiento(String establecimiento) {
	this.establecimiento = establecimiento;
}


public int getNumero_cancha() {
	return numero_cancha;
}


public void setNumero_cancha(int numero_cancha) {
	this.numero_cancha = numero_cancha;
}


public String getDni() {
	return dni;
}


public void setDni(String dni) {
	this.dni = dni;
}


@Override
public String toString() {
	return "Reserva [numero_reserva=" + numero_reserva + ", fecha=" + fecha + ", hora_inicio=" + hora_inicio
			+ ", establecimiento=" + establecimiento + ", numero_cancha=" + numero_cancha + ", dni=" + dni + "]";
}





}
