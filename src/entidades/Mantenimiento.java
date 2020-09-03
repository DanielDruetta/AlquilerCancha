package entidades;

import java.sql.Date;


public class Mantenimiento {

	String establecimiento;
	int numeroCancha;
	Date fechaInicio;
	Date fechaFin;
	String descripcion;
	String observaciones;
	
	
	
	public Mantenimiento() {
		super();
	}
	public Mantenimiento(String establecimiento, int numeroCancha, Date fechaInicio, Date fechaFin, String descripcion,
			String observaciones) {
		super();
		this.establecimiento = establecimiento;
		this.numeroCancha = numeroCancha;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		this.observaciones = observaciones;
	}
	public String getEstablecimiento() {
		return establecimiento;
	}
	public int getNumeroCancha() {
		return numeroCancha;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}
	public void setNumeroCancha(int numeroCancha) {
		this.numeroCancha = numeroCancha;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
