/**
 * 
 */
package com.sapient.income.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 *
 */
public class CurrencyConversionMasterData {

	/**
	 * Conversion Map
	 */
	private static final Map<String, Float> CURRENCY_CONVERSION_MAP = new HashMap<>();

	/**
	 * static block
	 */
	static{
		CURRENCY_CONVERSION_MAP.put("USD|INR", 66.0f);
		CURRENCY_CONVERSION_MAP.put("USD|GBP", 0.67f);
		CURRENCY_CONVERSION_MAP.put("USD|SGP",1.5f );
		CURRENCY_CONVERSION_MAP.put("USD|HKD",8.0f );
		CURRENCY_CONVERSION_MAP.put("USD|USD",1.0f );
	}

	/**
	 * @return the currencyConversionMap
	 */
	public static Float getCurrencyConversionMap(String inputCurrency, String outputCurrency) {
		return CURRENCY_CONVERSION_MAP.get(inputCurrency+"|"+outputCurrency);
	}
}
