package entidades;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
public class Fecha {

	 public static Date ParseFecha(String fecha)
	    {
	        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	        Date fechaDate = null;
	        try {
	            fechaDate = (Date) formato.parse(fecha);
	        } 
	        catch (ParseException ex) 
	        {
	            System.out.println(ex);
	        }
	        return fechaDate;
	    }
	
}
