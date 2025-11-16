package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GetInfoAppByCncaLoanModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8911311151033247221L;
	private String customerBp;
	private List<LoanModel> loans = new ArrayList<LoanModel>();
	
	/**
	 * @return the customerBp
	 */
	public String getCustomerBp() {
		return customerBp;
	}

	/**
	 * @param customerBp the customerBp to set
	 */
	public void setCustomerBp(String customerBp) {
		this.customerBp = customerBp;
	}

	/**
	 * @return the loans
	 */
	public List<LoanModel> getLoans() {
		return loans;
	}

	/**
	 * @param loans the loans to set
	 */
	public void setLoans(List<LoanModel> loans) {
		this.loans = loans;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
