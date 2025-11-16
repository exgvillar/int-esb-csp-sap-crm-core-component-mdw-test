package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class LoansModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2512050551162954711L;
	private Long accountId;	
	private String portfolioOwner;
	private Date formalizationDate;
	private String enterpriseOrigination;
	private int totalOfPayments;
	private int paymentNumber;
	private String frecuency;	
	private Double discountAmount;
	private Double liquidAmount;
	private Double interestRate;
	private Double cat;	
	private String pensionType;
	private String folioReleaseLetter;
	
	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the portfolioOwner
	 */
	public String getPortfolioOwner() {
		return portfolioOwner;
	}
	/**
	 * @param portfolioOwner the portfolioOwner to set
	 */
	public void setPortfolioOwner(String portfolioOwner) {
		this.portfolioOwner = portfolioOwner;
	}
	/**
	 * @return the formalizationDate
	 */
	public Date getFormalizationDate() {
		return formalizationDate;
	}
	/**
	 * @param formalizationDate the formalizationDate to set
	 */
	public void setFormalizationDate(Date formalizationDate) {
		this.formalizationDate = formalizationDate;
	}
	/**
	 * @return the enterpriseOrigination
	 */
	public String getEnterpriseOrigination() {
		return enterpriseOrigination;
	}
	/**
	 * @param enterpriseOrigination the enterpriseOrigination to set
	 */
	public void setEnterpriseOrigination(String enterpriseOrigination) {
		this.enterpriseOrigination = enterpriseOrigination;
	}
	/**
	 * @return the totalOfPayments
	 */
	public int getTotalOfPayments() {
		return totalOfPayments;
	}
	/**
	 * @param totalOfPayments the totalOfPayments to set
	 */
	public void setTotalOfPayments(int totalOfPayments) {
		this.totalOfPayments = totalOfPayments;
	}
	/**
	 * @return the paymentNumber
	 */
	public int getPaymentNumber() {
		return paymentNumber;
	}
	/**
	 * @param paymentNumber the paymentNumber to set
	 */
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	/**
	 * @return the frecuency
	 */
	public String getFrecuency() {
		return frecuency;
	}
	/**
	 * @param frecuency the frecuency to set
	 */
	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}
	/**
	 * @return the discountAmount
	 */
	public Double getDiscountAmount() {
		return discountAmount;
	}
	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	/**
	 * @return the liquidAmount
	 */
	public Double getLiquidAmount() {
		return liquidAmount;
	}
	/**
	 * @param liquidAmount the liquidAmount to set
	 */
	public void setLiquidAmount(Double liquidAmount) {
		this.liquidAmount = liquidAmount;
	}
	/**
	 * @return the interestRate
	 */
	public Double getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	/**
	 * @return the cat
	 */
	public Double getCat() {
		return cat;
	}
	/**
	 * @param cat the cat to set
	 */
	public void setCat(Double cat) {
		this.cat = cat;
	}
	/**
	 * @return the pensionType
	 */
	public String getPensionType() {
		return pensionType;
	}
	/**
	 * @param pensionType the pensionType to set
	 */
	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}
	/**
	 * @return the folioReleaseLetter
	 */
	public String getFolioReleaseLetter() {
		return folioReleaseLetter;
	}
	/**
	 * @param folioReleaseLetter the folioReleaseLetter to set
	 */
	public void setFolioReleaseLetter(String folioReleaseLetter) {
		this.folioReleaseLetter = folioReleaseLetter;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
