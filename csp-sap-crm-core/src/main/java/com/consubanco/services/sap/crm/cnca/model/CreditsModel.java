package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CreditsModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9140693615772169353L;
	private String creditId;
		
	/**
	 * @return the creditId
	 */
	public String getcreditId() {
		return creditId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setcreditId(String creditId) {
		this.creditId = creditId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
