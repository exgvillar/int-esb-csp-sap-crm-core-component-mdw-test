/**
 * 
 */
package com.consubanco.services.sap.crm.commons.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class AddressInputParameter implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4781108809801500064L;

	private String addressId = null;
	
	private String addressTypeId = null;
	
	private String addressTypeDesc = null;
	
	private String addressTypeViaId = null;
	
	private String addressTypeViaDesc = null;
	
	private String street = null;
	
	private String internalNumber = null;
	
	private String externalNumber = null;
	
	private String zipCode = null;
	
	private String suburb = null;
	
	private String settlementTypeId = null;
	
	private String settlementTypeDesc = null;
	
	private String town = null;
	
	private String township = null;
	
	private String city = null;
	
	private String state = null;
	
	private String country = null;
	
	private String betweenStreet = null;
	
	private String andStreet = null;
	
	private ArrayList<PhoneInputParameter> phones = null;
	
	 
	
		
	
	
	
	/**
	 * 
	 */
	public AddressInputParameter() {
		super();
	}

	
	



	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}






	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}






	/**
	 * @return the addressTypeId
	 */
	public String getAddressTypeId() {
		return addressTypeId;
	}






	/**
	 * @param addressTypeId the addressTypeId to set
	 */
	public void setAddressTypeId(String addressTypeId) {
		this.addressTypeId = addressTypeId;
	}






	/**
	 * @return the addressTypeDesc
	 */
	public String getAddressTypeDesc() {
		return addressTypeDesc;
	}






	/**
	 * @param addressTypeDesc the addressTypeDesc to set
	 */
	public void setAddressTypeDesc(String addressTypeDesc) {
		this.addressTypeDesc = addressTypeDesc;
	}






	/**
	 * @return the addressTypeViaId
	 */
	public String getAddressTypeViaId() {
		return addressTypeViaId;
	}






	/**
	 * @param addressTypeViaId the addressTypeViaId to set
	 */
	public void setAddressTypeViaId(String addressTypeViaId) {
		this.addressTypeViaId = addressTypeViaId;
	}






	/**
	 * @return the addressTypeViaDesc
	 */
	public String getAddressTypeViaDesc() {
		return addressTypeViaDesc;
	}






	/**
	 * @param addressTypeViaDesc the addressTypeViaDesc to set
	 */
	public void setAddressTypeViaDesc(String addressTypeViaDesc) {
		this.addressTypeViaDesc = addressTypeViaDesc;
	}






	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}






	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}






	/**
	 * @return the internalNumber
	 */
	public String getInternalNumber() {
		return internalNumber;
	}






	/**
	 * @param internalNumber the internalNumber to set
	 */
	public void setInternalNumber(String internalNumber) {
		this.internalNumber = internalNumber;
	}






	/**
	 * @return the externalNumber
	 */
	public String getExternalNumber() {
		return externalNumber;
	}






	/**
	 * @param externalNumber the externalNumber to set
	 */
	public void setExternalNumber(String externalNumber) {
		this.externalNumber = externalNumber;
	}






	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}






	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}






	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
	}






	/**
	 * @param suburb the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}






	/**
	 * @return the settlementTypeId
	 */
	public String getSettlementTypeId() {
		return settlementTypeId;
	}






	/**
	 * @param settlementTypeId the settlementTypeId to set
	 */
	public void setSettlementTypeId(String settlementTypeId) {
		this.settlementTypeId = settlementTypeId;
	}






	/**
	 * @return the settlementTypeDesc
	 */
	public String getSettlementTypeDesc() {
		return settlementTypeDesc;
	}






	/**
	 * @param settlementTypeDesc the settlementTypeDesc to set
	 */
	public void setSettlementTypeDesc(String settlementTypeDesc) {
		this.settlementTypeDesc = settlementTypeDesc;
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
	 * @return the township
	 */
	public String getTownship() {
		return township;
	}






	/**
	 * @param township the township to set
	 */
	public void setTownship(String township) {
		this.township = township;
	}






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
	 * @return the state
	 */
	public String getState() {
		return state;
	}






	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
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
	 * @return the betweenStreet
	 */
	public String getBetweenStreet() {
		return betweenStreet;
	}






	/**
	 * @param betweenStreet the betweenStreet to set
	 */
	public void setBetweenStreet(String betweenStreet) {
		this.betweenStreet = betweenStreet;
	}






	/**
	 * @return the andStreet
	 */
	public String getAndStreet() {
		return andStreet;
	}






	/**
	 * @param andStreet the andStreet to set
	 */
	public void setAndStreet(String andStreet) {
		this.andStreet = andStreet;
	}






	/**
	 * @return the phones
	 */
	public ArrayList<PhoneInputParameter> getPhones() {
		return phones;
	}






	/**
	 * @param phones the phones to set
	 */
	public void setPhones(ArrayList<PhoneInputParameter> phones) {
		this.phones = phones;
	}


	/**
	 * 
	 * @param number
	 * @param extension
	 * @param phoneTypeId
	 * @param phoneTypeDesc
	 */
	public void addPhone(String number, String extension, String phoneType){
		if( this.phones == null )
			this.phones = new ArrayList<PhoneInputParameter>();
		PhoneInputParameter phone = new PhoneInputParameter();
		phone.setNumber( number );
		phone.setExtension( extension );
		phone.setPhoneType( phoneType );
		this.phones.add( phone );
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
