/**
 * 
 */
package com.sapient.income.file.factory;

import com.sapient.income.file.impl.CsvFileReaderApplication;
import com.sapient.income.file.impl.ExcelFileReaderApplication;
import com.sapient.income.file.impl.XmlFileReaderApplication;
import com.sapient.income.file.inf.FileReaderApplication;

/**
 * @author indiahiring
 *
 */
public class FormatFactory {

	private static final String CSV = "CSV";
	private static final String EXCEL = "EXCEL";
	private static final String XML = "XML";

	/**
	 * Returns object of the Input File Format
	 * @param formatType
	 * @return
	 */
	public FileReaderApplication getFileReaderApplication(final String formatType){
		if(null == formatType){
			return null;
		}
		else if(CSV.equalsIgnoreCase(formatType)){
			return new CsvFileReaderApplication();
		}
		else if(EXCEL.equalsIgnoreCase(formatType)){
			return new ExcelFileReaderApplication();
		}
		else if(XML.equalsIgnoreCase(formatType)){
			return new XmlFileReaderApplication();
		}
		return null;
	}
}