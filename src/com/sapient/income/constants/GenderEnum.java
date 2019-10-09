/**
 * 
 */
package com.sapient.income.constants;

/**
 * @author Admin
 *
 */
public enum GenderEnum {
	
	M('M'),
	F('F');
	
	private Character genderName;

	/**
	 * @return the genderName
	 */
	public Character getGenderName() {
		return genderName;
	}

	/**
	 * @param genderName
	 */
	private GenderEnum(Character genderName) {
		this.genderName = genderName;
	}
}
