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
public class CancelApplicationResponseBOP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -28119538244329874L;
	
	private String status = null;
	
	private String code = null;
	
	private String response = null;
	
	private ArrayList<CancelApplicationBOP> applications = null;
	
	
	/**
	 * 
	 */
	public CancelApplicationResponseBOP() {
		super();
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
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
