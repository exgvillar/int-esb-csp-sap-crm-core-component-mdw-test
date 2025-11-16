/**
 * 
 */
package com.consubanco.services.sap.crm.puc.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author estefania.montoya
 *
 */
public class CreditBalancesPDF implements Serializable {
	private static final long serialVersionUID = 7038321727373668699L;

	private String outsBalance = "";

	private int pendPay = 0;

	private String totalPaid = "";

	private String interestPay = "";

	private String totalInterestAmt = "";

	private String totalInterestPay = "";

	private String totalCapitalAmt = "";

	private String totalCapitalPay = "";

	private String totalVatAmt = "";
	
	private String  tasaMora = "";

	/**
	 * @return the outsBalance
	 */
	public String getOutsBalance() {
		return outsBalance;
	}

	/**
	 * @param outsBalance the outsBalance to set
	 */
	public void setOutsBalance(String outsBalance) {
		this.outsBalance = outsBalance;
	}

	/**
	 * @return the pendPay
	 */
	public int getPendPay() {
		return pendPay;
	}

	/**
	 * @param pendPay the pendPay to set
	 */
	public void setPendPay(int pendPay) {
		this.pendPay = pendPay;
	}

	/**
	 * @return the totalPaid
	 */
	public String getTotalPaid() {
		return totalPaid;
	}

	/**
	 * @param totalPaid the totalPaid to set
	 */
	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	/**
	 * @return the interestPay
	 */
	public String getInterestPay() {
		return interestPay;
	}

	/**
	 * @param interestPay the interestPay to set
	 */
	public void setInterestPay(String interestPay) {
		this.interestPay = interestPay;
	}

	/**
	 * @return the totalInterestAmt
	 */
	public String getTotalInterestAmt() {
		return totalInterestAmt;
	}

	/**
	 * @param totalInterestAmt the totalInterestAmt to set
	 */
	public void setTotalInterestAmt(String totalInterestAmt) {
		this.totalInterestAmt = totalInterestAmt;
	}

	/**
	 * @return the totalInterestPay
	 */
	public String getTotalInterestPay() {
		return totalInterestPay;
	}

	/**
	 * @param totalInterestPay the totalInterestPay to set
	 */
	public void setTotalInterestPay(String totalInterestPay) {
		this.totalInterestPay = totalInterestPay;
	}

	/**
	 * @return the totalCapitalAmt
	 */
	public String getTotalCapitalAmt() {
		return totalCapitalAmt;
	}

	/**
	 * @param totalCapitalAmt the totalCapitalAmt to set
	 */
	public void setTotalCapitalAmt(String totalCapitalAmt) {
		this.totalCapitalAmt = totalCapitalAmt;
	}

	/**
	 * @return the totalCapitalPay
	 */
	public String getTotalCapitalPay() {
		return totalCapitalPay;
	}

	/**
	 * @param totalCapitalPay the totalCapitalPay to set
	 */
	public void setTotalCapitalPay(String totalCapitalPay) {
		this.totalCapitalPay = totalCapitalPay;
	}

	/**
	 * @return the totalVatAmt
	 */
	public String getTotalVatAmt() {
		return totalVatAmt;
	}

	/**
	 * @param totalVatAmt the totalVatAmt to set
	 */
	public void setTotalVatAmt(String totalVatAmt) {
		this.totalVatAmt = totalVatAmt;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * @return the tasaMora
	 */
	public String getTasaMora() {
		return tasaMora;
	}

	/**
	 * @param tasaMora the tasaMora to set
	 */
	public void setTasaMora(String tasaMora) {
		this.tasaMora = tasaMora;
	}
}
