package ui;

import data.DataPrecio;
import entidades.Precio;


public class Principal {

	public static void main(String[] args) {
		 
	DataPrecio dp=new DataPrecio();
	Precio p = new Precio();
	p= dp.obtenerPrecio("Bombonera", 2);
	System.out.println(dp.obtenerPrecio("Bombonera",2).getPrecio());
	System.out.println(p.getEstablecimiento());
	System.out.println(p.getNumero_cancha());
	System.out.println(p.getFecha_desde());
	System.out.println(p.getPrecio());
		
	}

}
