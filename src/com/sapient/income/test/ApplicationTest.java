/**
 * 
 */
package com.sapient.income.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sapient.income.file.factory.FormatFactory;
import com.sapient.income.file.inf.FileReaderApplication;

/**
 * @author Admin
 *
 */
public class ApplicationTest {

	private static final String OUTPUT_FILE = "src/com/sapient/income/resource/Sample_Output.csv";
	private static final String SEPARATOR = ",";
	
	FileReaderApplication fileReaderApplication;
	
	/**
	 * 
	 * @throws IOException
	 */
	@Before
	public void setUp() throws IOException{
		FormatFactory formatFactory = new FormatFactory();
		fileReaderApplication = formatFactory.getFileReaderApplication("CSV");
		fileReaderApplication.processFile();
	}
	
	/**
	 * Read output file Header
	 * @throws IOException 
	 */
	@Test
	public void testHeader() throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream(OUTPUT_FILE)));
		String line = stdin.readLine();
		String [] fields = line.split(SEPARATOR);
		Assert.assertTrue("City/Country".equalsIgnoreCase(fields[0]));
		Assert.assertTrue("Gender".equalsIgnoreCase(fields[1]));
		Assert.assertTrue("Average Income(in USD)".equalsIgnoreCase(fields[2]));
		stdin.close();
	}
	
	/**
	 * Read output file Row size
	 * @throws IOException 
	 */
	@Test
	public void testRowSize() throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream(OUTPUT_FILE)));
		@SuppressWarnings("unused")
		String line = null;
		int size = 0;
		while((line = stdin.readLine()) != null) size++;
		Assert.assertTrue(size == 13);
		stdin.close();
	}
	
	/**
	 * Read output file First Row
	 * @throws IOException 
	 */
	@Test
	public void testDataLine1() throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream(OUTPUT_FILE)));
		String line = stdin.readLine();
		line = stdin.readLine();
		String [] fields = line.split(SEPARATOR);
		Assert.assertTrue("HONG KONG".equalsIgnoreCase(fields[0]));
		Assert.assertTrue("F".equalsIgnoreCase(fields[1]));
		Assert.assertTrue("22744.13".equalsIgnoreCase(fields[2]));
		stdin.close();
	}
	
	/**
	 * Read output file Second Row
	 * @throws IOException 
	 */
	@Test
	public void testDataLine2() throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream(OUTPUT_FILE)));
		String line = stdin.readLine();
		line = stdin.readLine();
		line = stdin.readLine();
		String [] fields = line.split(SEPARATOR);
		Assert.assertTrue("HONG KONG".equalsIgnoreCase(fields[0]));
		Assert.assertTrue("M".equalsIgnoreCase(fields[1]));
		Assert.assertTrue("32118.75".equalsIgnoreCase(fields[2]));
		stdin.close();
	}
}
