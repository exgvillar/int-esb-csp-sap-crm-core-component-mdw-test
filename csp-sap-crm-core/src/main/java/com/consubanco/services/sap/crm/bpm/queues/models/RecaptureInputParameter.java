/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.queues.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class RecaptureInputParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3957790540933767771L;

	private String folioApplication = null;
	
	private int totalRecapture = 0;
	
	private String userCaptureError = null;
	
	private String userReport = null;
	
	private String roleReport = null;
	
	private String userCaptureResolve = null;
	
	private ArrayList<IncidenceRecaptureInputParameter> incidencesRecapture = null;
	
	private boolean saveIncidence = false;
	
	/**
	 * 
	 */
	public RecaptureInputParameter() {
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
	 * @return the totalRecapture
	 */
	public int getTotalRecapture() {
		return totalRecapture;
	}

	/**
	 * @param totalRecapture the totalRecapture to set
	 */
	public void setTotalRecapture(int totalRecapture) {
		this.totalRecapture = totalRecapture;
	}

	/**
	 * @return the userCaptureError
	 */
	public String getUserCaptureError() {
		return userCaptureError;
	}

	/**
	 * @param userCaptureError the userCaptureError to set
	 */
	public void setUserCaptureError(String userCaptureError) {
		this.userCaptureError = userCaptureError;
	}

	/**
	 * @return the userReport
	 */
	public String getUserReport() {
		return userReport;
	}

	/**
	 * @param userReport the userReport to set
	 */
	public void setUserReport(String userReport) {
		this.userReport = userReport;
	}

	/**
	 * @return the roleReport
	 */
	public String getRoleReport() {
		return roleReport;
	}

	/**
	 * @param roleReport the roleReport to set
	 */
	public void setRoleReport(String roleReport) {
		this.roleReport = roleReport;
	}

	/**
	 * @return the userCaptureResolve
	 */
	public String getUserCaptureResolve() {
		return userCaptureResolve;
	}

	/**
	 * @param userCaptureResolve the userCaptureResolve to set
	 */
	public void setUserCaptureResolve(String userCaptureResolve) {
		this.userCaptureResolve = userCaptureResolve;
	}

	/**
	 * @return the incidencesRecapture
	 */
	public ArrayList<IncidenceRecaptureInputParameter> getIncidencesRecapture() {
		return incidencesRecapture;
	}

	/**
	 * @param incidencesRecapture the incidencesRecapture to set
	 */
	public void setIncidencesRecapture(
			ArrayList<IncidenceRecaptureInputParameter> incidencesRecapture) {
		this.incidencesRecapture = incidencesRecapture;
	}

	/**
	 * @return the saveIncidence
	 */
	public boolean isSaveIncidence() {
		return saveIncidence;
	}

	/**
	 * @param saveIncidence the saveIncidence to set
	 */
	public void setSaveIncidence(boolean saveIncidence) {
		this.saveIncidence = saveIncidence;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
