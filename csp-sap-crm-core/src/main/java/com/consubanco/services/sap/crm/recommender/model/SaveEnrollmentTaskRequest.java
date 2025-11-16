/**
 * 
 */
package com.consubanco.services.sap.crm.recommender.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Ing. Adrian Alejo
 * 
 */
public class SaveEnrollmentTaskRequest implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private String taskId;
	private String recommenderBp;
	private String employeeBP;
	private String contactMedium;
	private String contactSource;
	private String observations;
	private String processBPMid;

	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the recommenderBp
	 */
	public String getRecommenderBp() {
		return recommenderBp;
	}

	/**
	 * @param recommenderBp
	 *            the recommenderBp to set
	 */
	public void setRecommenderBp(String recommenderBp) {
		this.recommenderBp = recommenderBp;
	}

	/**
	 * @return the employeeBP
	 */
	public String getEmployeeBP() {
		return employeeBP;
	}

	/**
	 * @param employeeBP
	 *            the employeeBP to set
	 */
	public void setEmployeeBP(String employeeBP) {
		this.employeeBP = employeeBP;
	}

	/**
	 * @return the contactMedium
	 */
	public String getContactMedium() {
		return contactMedium;
	}

	/**
	 * @param contactMedium
	 *            the contactMedium to set
	 */
	public void setContactMedium(String contactMedium) {
		this.contactMedium = contactMedium;
	}

	/**
	 * @return the contactSource
	 */
	public String getContactSource() {
		return contactSource;
	}

	/**
	 * @param contactSource
	 *            the contactSource to set
	 */
	public void setContactSource(String contactSource) {
		this.contactSource = contactSource;
	}

	/**
	 * @return the observations
	 */
	public String getObservations() {
		return observations;
	}

	/**
	 * @param observations
	 *            the observations to set
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}

	/**
	 * @return the processBPMid
	 */
	public String getProcessBPMid() {
		return processBPMid;
	}

	/**
	 * @param processBPMid
	 *            the processBPMid to set
	 */
	public void setProcessBPMid(String processBPMid) {
		this.processBPMid = processBPMid;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
