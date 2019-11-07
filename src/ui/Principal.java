package ui;

import entidades.*;


import java.sql.SQLException;
import java.util.ArrayList;

import data.*;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException{
		 
	DataPrecio dp=new DataPrecio();
	int precio;
	precio= dp.obtenerPrecio("Bombonera", 2);
	System.out.println(precio);
		
	}

}
