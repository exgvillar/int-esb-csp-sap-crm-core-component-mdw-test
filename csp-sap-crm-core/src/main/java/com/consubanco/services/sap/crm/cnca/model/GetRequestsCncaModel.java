package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GetRequestsCncaModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7078970225616556962L;
	private Date initialDate;
	private Date finalDate;
	
	
	
	/**
	 * @return the initialDate
	 */
	public Date getInitialDate() {
		return initialDate;
	}



	/**
	 * @param initialDate the initialDate to set
	 */
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}



	/**
	 * @return the finalDate
	 */
	public Date getFinalDate() {
		return finalDate;
	}



	/**
	 * @param finalDate the finalDate to set
	 */
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
