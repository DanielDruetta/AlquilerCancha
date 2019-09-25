package ui;

import entidades.*;


import java.sql.SQLException;
import java.util.ArrayList;

import data.*;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException{
		DataCancha de = new DataCancha();
		ArrayList<Cancha> establecimientos = de.getAll();
		String luz;
		luz= "N";
		int i=5;
		System.out.println(Integer.toString(i));
		System.out.println(luz);
		System.out.println(!(luz.equals("N")));
		for(Cancha es:establecimientos)
		{
			System.out.println(es.toString());
		}


		
	}

}
