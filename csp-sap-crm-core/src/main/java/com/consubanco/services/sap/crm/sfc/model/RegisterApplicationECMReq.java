package com.consubanco.services.sap.crm.sfc.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class RegisterApplicationECMReq implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1782933381524731233L;
	private String applicationId;
	private String applicationCRM;
	private String apportunitySFC;
	private String filenetId;
	
	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * @return the applicationCRM
	 */
	public String getApplicationCRM() {
		return applicationCRM;
	}
	/**
	 * @param applicationCRM the applicationCRM to set
	 */
	public void setApplicationCRM(String applicationCRM) {
		this.applicationCRM = applicationCRM;
	}
	/**
	 * @return the apportunitySFC
	 */
	public String getApportunitySFC() {
		return apportunitySFC;
	}
	/**
	 * @param apportunitySFC the apportunitySFC to set
	 */
	public void setApportunitySFC(String apportunitySFC) {
		this.apportunitySFC = apportunitySFC;
	}
	/**
	 * @return the filenetId
	 */
	public String getFilenetId() {
		return filenetId;
	}
	/**
	 * @param filenetId the filenetId to set
	 */
	public void setFilenetId(String filenetId) {
		this.filenetId = filenetId;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
