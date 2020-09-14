package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import entidades.Establecimiento;
import entidades.Reserva;

public class Correo {

	public void enviar_mail_confirmacion(String destinatario, Reserva reserva, Establecimiento es) throws IOException {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		String resourceName = "config.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties config = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			config.load(resourceStream);
		}

		final String gmailAccount = config.getProperty("gmail.account");
		final String gmailPassword = config.getProperty("gmail.password");
		final String emailDestination = destinatario;

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmailAccount, gmailPassword);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(gmailAccount));

			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestination));

			message.setSubject("Reserva registrada. Establecimiento: " + reserva.getEstablecimiento());
			
			DateFormat df = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
			String fecha = df.format(reserva.getFecha());
            

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Reserva registrada. \n\nEstablecimiento: " + reserva.getEstablecimiento()
					+ "\nDirección: " + es.getDireccion() + "\nNumero de cancha: " + reserva.getNumero_cancha()
					+ "\nFecha del partido: " + fecha+ "\nHora del partido: " + reserva.getHora_inicio() + "\n\nNo faltes!!");

			Multipart multipart = new MimeMultipart();

			// Setting email text message
			multipart.addBodyPart(messageBodyPart);

			// set the attachments to the email
			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Correo enviado");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void enviar_mail_cancelacion(String destinatario) throws IOException {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		String resourceName = "config.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties config = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			config.load(resourceStream);
		}

		final String gmailAccount = config.getProperty("gmail.account");
		final String gmailPassword = config.getProperty("gmail.password");
		final String emailDestination = destinatario;

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmailAccount, gmailPassword);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(gmailAccount));

			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestination));

			message.setSubject("Confirmación de cancelación");

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Su pedido ha sido cancelado exitosamente");

			Multipart multipart = new MimeMultipart();

			// Setting email text message
			multipart.addBodyPart(messageBodyPart);

			// set the attachments to the email
			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Correo enviado");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
