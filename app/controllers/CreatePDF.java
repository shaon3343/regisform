package controllers;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import models.People;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF extends Controller {
	public static Form<People> peoples = Form.form(People.class);
	public static Result createPDFfromString(String name,String email,String  password,String  occupation,String  mobile, String address) throws FileNotFoundException, DocumentException
	{
	//	Form<People> filledForm = peoples.bindFromRequest();

		String peopleCred = "Name: "+name+"\n";
		peopleCred += "Email: "+email+"\n"+
				"Mobile: "+mobile+"\n"+
				"Occupation: "+occupation+"\n"+
				"Address: "+address+"\n";
		
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
	//	PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("userProfile.pdf"));
		document.open();
		
		Anchor anchorTarget = new Anchor("User Profile As PDF:");
	      anchorTarget.setName("BackToTop");
	      Paragraph paragraph1 = new Paragraph();

	      paragraph1.setSpacingBefore(50);

	      paragraph1.add(anchorTarget);
	      document.add(paragraph1);

	    /*  document.add(new Paragraph("Some more text on the first page with different color and font type.", 

	      FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0))));*/
	      
	      document.add(new Paragraph(peopleCred,FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(255, 255, 255, 255))));
	   //   Window.open("C:\\Users\\bits1286\\regisform\\ITextTest.pdf");
	      
	      document.close();
		
		return ok(new FileInputStream("userProfile.pdf")).as("application/pdf");
	   //   return ok("PDF created at C:\\Users\\bits1286\\regisform\\userProfile.pdf");
	}
	public static void main(String[] args) throws FileNotFoundException, DocumentException{
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\bits1286\\regisform\\ITextTest.pdf"));
		document.open();
		
		Anchor anchorTarget = new Anchor("First page of the document.");
	      anchorTarget.setName("BackToTop");
	      Paragraph paragraph1 = new Paragraph();

	      paragraph1.setSpacingBefore(50);

	      paragraph1.add(anchorTarget);
	      document.add(paragraph1);

	document.add(new Paragraph("Some more text on the first page with different color and font type.", 

	FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0))));
	document.close();
	System.out.println("Created that pdf Document");
	}
}
