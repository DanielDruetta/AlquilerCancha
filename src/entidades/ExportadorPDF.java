package entidades;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import data.DataCliente;

public class ExportadorPDF 
{
	
	private ArrayList<Reserva> reservas;
	private String fecha;
	
	public ExportadorPDF() 
	{
		
	}
	
	public ExportadorPDF(ArrayList<Reserva> reservas, String fecha)
	{
		this.reservas = reservas;
		this.fecha = fecha;
	}
	
	
	public void writeHeader(PdfPTable pdfTable)
	{
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.white);
		cell.setPadding(5);
		Font font = FontFactory.getFont(FontFactory.COURIER);
		font.setColor(Color.black);
		cell.setPhrase(new Phrase("Numero de reserva", font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("Fecha", font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("Hora", font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("Nombre y apellido", font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("Celular", font));
		pdfTable.addCell(cell);
	}
	
	public void writeTableData(PdfPTable pdfTable)
	{
		DataCliente dc = new DataCliente();
		String strDateFormat = "dd-MM-yyyy";
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		for (Reserva res : reservas)
		{
			pdfTable.addCell(String.valueOf(res.getNumero_reserva()));
			pdfTable.addCell(String.valueOf(objSDF.format(res.getFecha())));
			pdfTable.addCell(String.valueOf(res.getHora_inicio()));
			pdfTable.addCell(String.valueOf(dc.buscarDNI(res.getDni()).getNombre() + " " + dc.buscarDNI(res.getDni()).getApellido()));
			pdfTable.addCell(String.valueOf(dc.buscarDNI(res.getDni()).getCelular()));
		}
	}
	
	public void export(HttpServletResponse response) throws Exception
	{
		try (Document doc = new Document(PageSize.A4))
		{
			PdfWriter.getInstance(doc, response.getOutputStream());
			doc.open();
			
			Font font = FontFactory.getFont(FontFactory.COURIER);
			font.setSize(20);
			font.setColor(Color.black);
			
			Paragraph paragraph = new Paragraph("Reservas del " + fecha, font);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			doc.add(paragraph);
			
			PdfPTable pdfPTable = new PdfPTable(5);
			pdfPTable.setWidthPercentage(100f);
			pdfPTable.setWidths(new float []{2f, 2f, 2f, 4f, 2.5f});
			pdfPTable.setSpacingBefore(10);
			
			writeHeader(pdfPTable);
			writeTableData(pdfPTable);
			
			doc.add(pdfPTable);
			doc.close();
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
}