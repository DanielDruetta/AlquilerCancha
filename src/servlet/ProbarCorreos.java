package servlet;

import java.io.IOException;

public class ProbarCorreos {

	public static void main(String[] args)  {
		Correo correo = new Correo();
		try {
			correo.enviar_mail_confirmacion("danidruetta97@gmail.com", 4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
