/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.cancellations.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class CancelApplicationRequestBOP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -28119538244329874L;
	
	private String applicationId = null;
	
	private String processId = null;
	
	private EmployeeBOP user = null;
	
	private ArrayList<CancelApplicationBOP> applications = null;
	
	
	/**
	 * 
	 */
	public CancelApplicationRequestBOP() {
		super();
	}

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
	 * @return the processId
	 */
	public String getProcessId() {
		return processId;
	}

	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	/**
	 * @return the user
	 */
	public EmployeeBOP getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(EmployeeBOP user) {
		this.user = user;
	}

	/**
	 * @return the applications
	 */
	public ArrayList<CancelApplicationBOP> getApplications() {
		return applications;
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(ArrayList<CancelApplicationBOP> applications) {
		this.applications = applications;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
