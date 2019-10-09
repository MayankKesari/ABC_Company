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
public class CsvFileReaderApplication implements FileReaderApplication{

	private static final String SEPARATOR = ",";

	private static final String INPUT_FILE = "src/com/sapient/income/resource/Sample_Input.csv";
	private static final String OUTPUT_FILE = "src/com/sapient/income/resource/Sample_Output.csv";
	
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
			//Reading Csv File
			String [] fields = line.split(SEPARATOR);
			InputModel inputModel = new InputModel();
			inputModel.setCity(fields[0]);
			inputModel.setCountry(fields[1]);
			inputModel.setGender(fields[2].charAt(0));
			inputModel.setCurrency(fields[3]);
			inputModel.setAverageIncome(Float.parseFloat(fields[4]));
			inputModelList.add(inputModel);
		}
		stdin.close();
		ProcessFile processFile = new ProcessFile();
		processFile.processFile(inputModelList, OUTPUT_FILE);
	}
}
