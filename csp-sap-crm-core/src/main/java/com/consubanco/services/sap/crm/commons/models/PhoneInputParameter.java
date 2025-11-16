/**
 * 
 */
package com.consubanco.services.sap.crm.commons.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class PhoneInputParameter implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7666895722076799778L;

	private String number = null;
	
	private String extension = null;
	
	private String phoneType = null;
	
	/**
	 * 
	 */
	public PhoneInputParameter() {
		super();
	}

	
	


	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}





	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}





	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}





	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}







	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}





	/**
	 * @param phoneType the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
