/**
 * 
 */
package com.sapient.income.file.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.sapient.income.file.inf.FileReaderApplication;
import com.sapient.income.model.InputModel;
import com.sapient.income.utility.ProcessFile;

/**
 * @author Admin
 *
 */
public class ExcelFileReaderApplication implements FileReaderApplication{

	private static final String INPUT_FILE = "src/com/sapient/income/resource/Sample_Input.xlsx";
	private static final String OUTPUT_FILE = "src/com/sapient/income/resource/Sample_Output.xlsx";
	
	/**
	 * Process File
	 */
	@Override
	public void processFile() throws IOException {
		List<InputModel> inputModelList = new ArrayList<>();
		InputStream in = new FileInputStream(INPUT_FILE);
		BufferedReader stdin = new BufferedReader(new InputStreamReader(in));
		String line = stdin.readLine();
		while((line = stdin.readLine()) != null){
			
			
			//TODO
			//READ Excel File
			
			
		}
		stdin.close();
		ProcessFile processFile = new ProcessFile();
		processFile.processFile(inputModelList, OUTPUT_FILE);
	}
}
