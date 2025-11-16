/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.cancellations.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class EmployeeBOP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -28119538244329874L;
	
	private String businessPartner = null;
	
	private String userName = null;
	
	private String name1 = null;
	
	private String name2 = null;
	
	private String lastName1 = null;
	
	private String lastName2 = null;
		
	
	/**
	 * 
	 */
	public EmployeeBOP() {
		super();
	}

	
	/**
	 * @return the businessPartner
	 */
	public String getBusinessPartner() {
		return businessPartner;
	}


	/**
	 * @param businessPartner the businessPartner to set
	 */
	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
	}


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}


	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}


	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}


	/**
	 * @param name2 the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}


	/**
	 * @return the lastName1
	 */
	public String getLastName1() {
		return lastName1;
	}


	/**
	 * @param lastName1 the lastName1 to set
	 */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}


	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}


	/**
	 * @param lastName2 the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
