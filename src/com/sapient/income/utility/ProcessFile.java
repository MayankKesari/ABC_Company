/**
 * 
 */
package com.sapient.income.utility;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sapient.income.constants.CurrencyConversionMasterData;
import com.sapient.income.model.AverageModel;
import com.sapient.income.model.InputModel;
import com.sapient.income.model.OutputModel;

/**
 * @author indiahiring
 *
 */



public class ProcessFile {
	
	/**
	 * Process the Input file to Output File
	 * @param inputModelList
	 * @param outputFile
	 * @throws IOException
	 */
	public void processFile(List<InputModel> inputModelList, final String outputFile) throws IOException {
		this.convertToUSD(inputModelList);
		Map<OutputModel, AverageModel> outputMap = this.groupData(inputModelList);
		OutputStream out = new FileOutputStream(outputFile);
		BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(out));
		stdout.write("City/Country,Gender,Average Income(in USD)\n");
		for(Map.Entry<OutputModel, AverageModel> entry: outputMap.entrySet()){
			stdout.write(entry.getKey().getCity() +","+ entry.getKey().getGender() 
					+","+ String.format("%.2f", entry.getValue().getAverageAmount()) + "\n");
		}
		stdout.close();
	}
	
	/**
	 * Convert to USD
	 * @param inputModelList
	 */
	private void convertToUSD(List<InputModel> inputModelList) {
		for(InputModel inputModel: inputModelList){
			Float conversionValue = CurrencyConversionMasterData.getCurrencyConversionMap("USD", inputModel.getCurrency());
			inputModel.setAverageIncome(inputModel.getAverageIncome()/conversionValue);
			inputModel.setCurrency("USD");
		}
	}
	
	/**
	 * Grouping data based on City and Gender
	 * @param inputModelList
	 * @return
	 */
	private Map<OutputModel, AverageModel> groupData(List<InputModel> inputModelList) {
		OutputModel outputModel = null;
		Map<OutputModel, AverageModel> outputMap = new TreeMap<OutputModel, AverageModel>();
		for(InputModel inputModel: inputModelList){
			outputModel = new OutputModel();
			outputModel.setCity(!inputModel.getCountry().equals("") ? inputModel.getCountry() : inputModel.getCity());
			outputModel.setGender(inputModel.getGender());
			AverageModel  averageModel;
			if(outputMap.get(outputModel) != null){
				averageModel = outputMap.get(outputModel);
				averageModel.setAverageAmount(averageModel.getAverageAmount()+inputModel.getAverageIncome());
				averageModel.setCount(averageModel.getCount()+1);
			}
			else{
				averageModel = new AverageModel();
				averageModel.setAverageAmount(inputModel.getAverageIncome());
				averageModel.setCount(1);
			}
			outputMap.put(outputModel, averageModel);
		}
		for(Map.Entry<OutputModel, AverageModel> entry: outputMap.entrySet()){
			Float average = entry.getValue().getAverageAmount()/ entry.getValue().getCount();
			entry.getValue().setAverageAmount(average);
			entry.getValue().setCount(entry.getValue().getCount());
		}
		return outputMap;
	}
}