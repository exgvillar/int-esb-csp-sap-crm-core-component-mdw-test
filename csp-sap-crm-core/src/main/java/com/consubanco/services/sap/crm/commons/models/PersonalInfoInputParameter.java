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
public class PersonalInfoInputParameter implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7666895722076799778L;

private String peopleHomeNumber = null;
	
	private String dependentsEconomicsNumber = null;
	
	private String ageDependentsEconomics = null;
		
	
	
	/**
	 * 
	 */
	public PersonalInfoInputParameter() {
		super();
	}

	
	

	/**
	 * @return the peopleHomeNumber
	 */
	public String getPeopleHomeNumber() {
		return peopleHomeNumber;
	}




	/**
	 * @param peopleHomeNumber the peopleHomeNumber to set
	 */
	public void setPeopleHomeNumber(String peopleHomeNumber) {
		this.peopleHomeNumber = peopleHomeNumber;
	}




	/**
	 * @return the dependentsEconomicsNumber
	 */
	public String getDependentsEconomicsNumber() {
		return dependentsEconomicsNumber;
	}




	/**
	 * @param dependentsEconomicsNumber the dependentsEconomicsNumber to set
	 */
	public void setDependentsEconomicsNumber(String dependentsEconomicsNumber) {
		this.dependentsEconomicsNumber = dependentsEconomicsNumber;
	}




	/**
	 * @return the ageDependentsEconomics
	 */
	public String getAgeDependentsEconomics() {
		return ageDependentsEconomics;
	}




	/**
	 * @param ageDependentsEconomics the ageDependentsEconomics to set
	 */
	public void setAgeDependentsEconomics(String ageDependentsEconomics) {
		this.ageDependentsEconomics = ageDependentsEconomics;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
