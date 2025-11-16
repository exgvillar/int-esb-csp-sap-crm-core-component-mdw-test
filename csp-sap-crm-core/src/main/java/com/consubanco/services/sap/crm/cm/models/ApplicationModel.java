/**
 * 
 */
package com.consubanco.services.sap.crm.cm.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class ApplicationModel implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6312476868705290245L;

	private String folioApplication = null;
	
	private String branchId = null;
	
	private double requestAmount = 0;
	
	private double cncaAmount = 0;
	
	private double intercompanyAmount = 0;
	
	/**
	 * 
	 */
	public ApplicationModel() {
		super();
	}

	/**
	 * @return the folioApplication
	 */
	public String getFolioApplication() {
		return folioApplication;
	}

	/**
	 * @param folioApplication the folioApplication to set
	 */
	public void setFolioApplication(String folioApplication) {
		this.folioApplication = folioApplication;
	}

	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the requestAmount
	 */
	public double getRequestAmount() {
		return requestAmount;
	}

	/**
	 * @param requestAmount the requestAmount to set
	 */
	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}

	/**
	 * @return the cncaAmount
	 */
	public double getCncaAmount() {
		return cncaAmount;
	}

	/**
	 * @param cncaAmount the cncaAmount to set
	 */
	public void setCncaAmount(double cncaAmount) {
		this.cncaAmount = cncaAmount;
	}

	/**
	 * @return the intercompanyAmount
	 */
	public double getIntercompanyAmount() {
		return intercompanyAmount;
	}

	/**
	 * @param intercompanyAmount the intercompanyAmount to set
	 */
	public void setIntercompanyAmount(double intercompanyAmount) {
		this.intercompanyAmount = intercompanyAmount;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
