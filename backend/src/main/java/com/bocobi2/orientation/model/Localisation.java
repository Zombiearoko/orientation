/**
 * 
 */
package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author brandon kenedy
 *
 */

@Document(collection = "localisation")
public class Localisation {

	@Id
	private String localisationId;
	private String country;
	private String town;
	private String region;
	private String departement;
	private String district;
	private String quarter;
	
	public Localisation(){}

	public Localisation(String country, String town, String region, String departement, String district,
			String quarter) {
		super();
		this.country = country;
		this.town = town;
		this.region = region;
		this.departement = departement;
		this.district = district;
		this.quarter = quarter;
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
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the quarter
	 */
	public String getquarter() {
		return quarter;
	}

	/**
	 * @param quarter the quarter to set
	 */
	public void setquarter(String quarter) {
		this.quarter = quarter;
	}
	
	   @Override
	    public String toString() {
			return String.format(
	                "{\"localisationId\":%s, \"country\":'%s', \"town\":'%s',\"region\":'%s',"
	                + "\"departement\":'%s',\"quarter\":'%s'}",
	                localisationId, country, town,region,departement,quarter);
	    }

	
}
