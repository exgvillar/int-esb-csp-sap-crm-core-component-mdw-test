/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.externalPortal.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author consubanco
 *
 */
public class AccountModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accountId;
	
	private double discountAmount;
	
	
	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}


	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	/**
	 * @return the discountAmount
	 */
	public double getDiscountAmount() {
		return discountAmount;
	}


	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
