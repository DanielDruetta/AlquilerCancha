package entidades;

public class ClienteReserva {
	
	String dni;
	int numero_reserva;
	int cantidad_jugadores;
	
	
	
	public ClienteReserva() {
		super();
	}
	
	
	public ClienteReserva(String dni, int numero_reserva, int cantidad_jugadores) {
		super();
		this.dni = dni;
		this.numero_reserva = numero_reserva;
		this.cantidad_jugadores = cantidad_jugadores;
	}


	public String getDni() {
		return dni;
	}
	public int getNumero_reserva() {
		return numero_reserva;
	}
	public int getCantidad_jugadores() {
		return cantidad_jugadores;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNumero_reserva(int numero_reserva) {
		this.numero_reserva = numero_reserva;
	}
	public void setCantidad_jugadores(int cantidad_jugadores) {
		this.cantidad_jugadores = cantidad_jugadores;
	}
	
	

}
