/**
 * 
 */
package com.sapient.income.model;

/**
 * @author Admin
 *
 */
public class InputModel {

	private String city;
	private String country;
	private Character gender;
	private String currency;
	private Float averageIncome;
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the gender
	 */
	public Character getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Character gender) {
		this.gender = gender;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the averageIncome
	 */
	public Float getAverageIncome() {
		return averageIncome;
	}
	/**
	 * @param averageIncome the averageIncome to set
	 */
	public void setAverageIncome(Float averageIncome) {
		this.averageIncome = averageIncome;
	}
}
