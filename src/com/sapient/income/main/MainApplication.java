/**
 * 
 */
package com.sapient.income.main;

import java.io.IOException;

import com.sapient.income.file.factory.FormatFactory;
import com.sapient.income.file.inf.FileReaderApplication;

/**
 * @author Admin
 *
 */
public class MainApplication {

	/**
	 * Application Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		FormatFactory formatFactory = new FormatFactory();
		FileReaderApplication fileReaderApplication = formatFactory.getFileReaderApplication("CSV");
		
		//TODO for other formats
		//FileReaderApplication fileReaderApplication = formatFactory.getFileReaderApplication("EXCEL");
		//FileReaderApplication fileReaderApplication = formatFactory.getFileReaderApplication("XML");
		
		try{
			fileReaderApplication.processFile();
		}
		catch (IOException e) {
			System.out.println("IO Exception in processing"+ e);
		}
		catch (Exception e) {
			System.out.println("Exception in processing"+ e);
		}
		finally{
			System.out.println("Parsing of input file 'src/com/sapient/income/resource/Sample_Input.xml' is completed");
			System.out.println("You can check the output file at 'src/com/sapient/income/resource/Sample_Ouput.xml'");
		}
	}
}