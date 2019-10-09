/**
 * 
 */
package com.sapient.income.model;

import java.io.Serializable;

/**
 * @author Admin
 *
 */
public class OutputModel implements Serializable, Comparable<OutputModel>{

	private static final long serialVersionUID = 1365587670013622839L;
	
	private String city;
	private Character gender;
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
	
	@Override
	public int compareTo(OutputModel o) {
		if(this.city.compareTo(o.city) != 0){
			return this.city.compareTo(o.city);
		}
		if(this.gender.compareTo(o.gender) != 0){
			return this.gender.compareTo(o.gender);
		}
		return 0;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutputModel other = (OutputModel) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}
}
 