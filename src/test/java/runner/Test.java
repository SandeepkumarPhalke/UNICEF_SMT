package runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.File;
import java.io.FileInputStream;

public class Test extends PageObject{

//	private static EnvironmentVariables environmentVariables;
	public static void main(String[] args) throws IOException {
//
//		File directory = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads");
//		File[] files = directory.listFiles(File::isFile);
//		long lastModifiedTime = Long.MIN_VALUE;
//		File chosenFile = null;
//
//		if (files != null) {
//			for (File file : files) {
//				if (file.lastModified() > lastModifiedTime) {
//					chosenFile = file;
//					lastModifiedTime = file.lastModified();
//				}
//			}
//		}
//		
//		
//	      PDDocument document = PDDocument.load(chosenFile);
//	      //Instantiate PDFTextStripper class
//	      PDFTextStripper pdfStripper = new PDFTextStripper();
//	      //Retrieving text from PDF document
//	      String text = pdfStripper.getText(document);
//	      System.out.println(text);
//	      //Closing the document
//	      
//	      System.out.println(text.contains("AutoTest281222041039"));
//	      document.close();
		
	
	String a = "1-31 of 31";
	
	String k = a.substring(8).trim();
	System.out.println(k.length());
	System.out.println(k);
	
	
	if(k.length()==4) {
		
		System.out.println(a.substring(2,6).trim());
	}else if (k.length()==2){
		
		System.out.println(a.substring(2,4).trim());
	}
	else {
		
		System.out.println(a.substring(2,5).trim());
	}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
