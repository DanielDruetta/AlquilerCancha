package entidades;

import java.sql.Date;

public class Precio {

	String establecimiento;
	int numero_cancha;
	Date fecha_desde;
	double precio;
	
	
	public Precio() {
		super();
	}
	
	
	
	public Precio(String establecimiento, int numero_cancha, double precio) {
		super();
		this.establecimiento = establecimiento;
		this.numero_cancha = numero_cancha;
		this.precio = precio;
	}

	


	public Precio(String establecimiento, int numero_cancha, Date fecha_desde, double precio) {
		super();
		this.establecimiento = establecimiento;
		this.numero_cancha = numero_cancha;
		this.fecha_desde = fecha_desde;
		this.precio = precio;
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
	public Date getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
