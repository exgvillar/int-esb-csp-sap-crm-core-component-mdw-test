package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SaveCncaTaskModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5798448108340871995L;
	private String taskId;
	private String customerBp;
	private String promotorBp;	
	private GenericCatalogModel enterprise;	
	private GenericCatalogModel distributor;
	private GenericCatalogModel branch;
	private GenericCatalogModel product;
	private Double requestAmount = 0.0;
	private int term = 0;
	private String solicitudId;
	private List<LoansModel> loans = new ArrayList<LoansModel>();
	private List<FileModel> files = new ArrayList<FileModel>();
	
	
	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
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
	 * @return the promotorBp
	 */
	public String getPromotorBp() {
		return promotorBp;
	}
	/**
	 * @param promotorBp the promotorBp to set
	 */
	public void setPromotorBp(String promotorBp) {
		this.promotorBp = promotorBp;
	}
	/**
	 * @return the enterprise
	 */
	public GenericCatalogModel getEnterprise() {
		return enterprise;
	}
	/**
	 * @param enterprise the enterprise to set
	 */
	public void setEnterprise(GenericCatalogModel enterprise) {
		this.enterprise = enterprise;
	}
	/**
	 * @return the distributor
	 */
	public GenericCatalogModel getDistributor() {
		return distributor;
	}
	/**
	 * @param distributor the distributor to set
	 */
	public void setDistributor(GenericCatalogModel distributor) {
		this.distributor = distributor;
	}
	/**
	 * @return the branch
	 */
	public GenericCatalogModel getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(GenericCatalogModel branch) {
		this.branch = branch;
	}
	/**
	 * @return the product
	 */
	public GenericCatalogModel getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(GenericCatalogModel product) {
		this.product = product;
	}
	/**
	 * @return the requestAmount
	 */
	public Double getRequestAmount() {
		return requestAmount;
	}
	/**
	 * @param requestAmount the requestAmount to set
	 */
	public void setRequestAmount(Double requestAmount) {
		this.requestAmount = requestAmount;
	}
	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}
	/**
	 * @return the loans
	 */
	public List<LoansModel> getLoans() {
		return loans;
	}
	/**
	 * @param loans the loans to set
	 */
	public void setLoans(List<LoansModel> loans) {
		this.loans = loans;
	}
	/**
	 * @return the files
	 */
	public List<FileModel> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(List<FileModel> files) {
		this.files = files;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	/**
	 * @return the solicitudId
	 */
	public String getSolicitudId() {
		return solicitudId;
	}
	/**
	 * @param solicitudId the solicitudId to set
	 */
	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}
	
}
