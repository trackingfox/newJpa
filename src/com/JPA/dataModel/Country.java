package com.JPA.dataModel;


public class Country {

	private String SubnetMask, IPaddress, CountryCode, country;

	public String getSubnetMask() {
		return SubnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		SubnetMask = subnetMask;
	}

	public String getIPaddress() {
		return IPaddress;
	}

	public void setIPaddress(String iPaddress) {
		IPaddress = iPaddress;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Country [SubnetMask=" + SubnetMask + ", IPaddress=" + IPaddress + ", CountryCode=" + CountryCode
				+ ", country=" + country + "]";
	}

}
