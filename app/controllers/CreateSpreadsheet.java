package controllers;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import models.People;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import play.mvc.Controller;
import play.mvc.Result;


public class CreateSpreadsheet extends Controller {
	   
	public static Result doSpreadsheet(Long id) throws IOException{
		
		String ids=id.toString();
		
		People p = People.find.byId(ids);
		
		String name = p.name;
		String occupation= p.occupation;
		String email= p.email;
		String address= p.address;
		String mobile = p.mobile;
	
		
		Workbook wb = new HSSFWorkbook();
	    //Workbook wb = new XSSFWorkbook();
	    CreationHelper createHelper = wb.getCreationHelper();
	    Sheet sheet = wb.createSheet("User Profile");

	    // Create a row and put some cells in it. Rows are 0 based.
	    Row row = sheet.createRow((short)0);
	    // Create a cell and put a value in it.
	    
	   // Cell cell = row.createCell(0);
	    //cell.setCellValue(1);

	    // Or do it on one line.
	    /*row.createCell(1).setCellValue(1.2);*/
	    row.createCell(0).setCellValue(
	         createHelper.createRichTextString("NAME"));
	    /*row.createCell(3).setCellValue(true);*/
	    row.createCell(1).setCellValue(
		         createHelper.createRichTextString("OCCUPATION"));

	    row.createCell(2).setCellValue(
		         createHelper.createRichTextString("ADDRESS"));
	                      
	    row.createCell(3).setCellValue(
		         createHelper.createRichTextString("MOBILE"));
	    
	    row.createCell(4).setCellValue(
		         createHelper.createRichTextString("EMAIL"));
	    
	    /* END HEADER */
	    row = sheet.createRow((short)1);
	
	    row.createCell(0).setCellValue(
		         createHelper.createRichTextString(name));
	    
		    /*row.createCell(3).setCellValue(true);*/
	    
		    row.createCell(1).setCellValue(
			         createHelper.createRichTextString(occupation));

		    row.createCell(2).setCellValue(
			         createHelper.createRichTextString(address));
		                      
		    row.createCell(3).setCellValue(
			         createHelper.createRichTextString(mobile));
		    
		    row.createCell(4).setCellValue(
			         createHelper.createRichTextString(email));
		    
	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("user_profile.xls");
	    wb.write(fileOut);
	    fileOut.close();
	    
	    
	    return ok(new FileInputStream("user_profile.xls")).as("application/xls");
		
	}
	  
	public static void main(String[] args) throws IOException{
		
		/*Workbook wb = new HSSFWorkbook();
	    //Workbook wb = new XSSFWorkbook();
	    CreationHelper createHelper = wb.getCreationHelper();
	    Sheet sheet = wb.createSheet("User Profile");

	    // Create a row and put some cells in it. Rows are 0 based.
	    Row row = sheet.createRow((short)0);
	    // Create a cell and put a value in it.
	    
	   // Cell cell = row.createCell(0);
	    //cell.setCellValue(1);

	    // Or do it on one line.
	    row.createCell(1).setCellValue(1.2);
	    row.createCell(0).setCellValue(
	         createHelper.createRichTextString("Name"));
	    row.createCell(3).setCellValue(true);
	    row.createCell(1).setCellValue(
		         createHelper.createRichTextString("occupation"));

	    row.createCell(2).setCellValue(
		         createHelper.createRichTextString("address"));
	                      
	    row.createCell(3).setCellValue(
		         createHelper.createRichTextString("mobile"));
	    
	    row.createCell(4).setCellValue(
		         createHelper.createRichTextString("email"));
	    
	     END HEADER 
	    row = sheet.createRow((short)1);
	
	    row.createCell(0).setCellValue(
		         createHelper.createRichTextString("ASHFAK CHOWDHURY"));
		    row.createCell(3).setCellValue(true);
		    row.createCell(1).setCellValue(
			         createHelper.createRichTextString("STUDENT"));

		    row.createCell(2).setCellValue(
			         createHelper.createRichTextString("HATHAZARI , CHITTAGONG"));
		                      
		    row.createCell(3).setCellValue(
			         createHelper.createRichTextString("010938049898"));
		    
		    row.createCell(4).setCellValue(
			         createHelper.createRichTextString("shaon.ashfak@gmail.com"));
		    
	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
	    wb.write(fileOut);
	    fileOut.close();
*/	    
	   
		
	}
}
