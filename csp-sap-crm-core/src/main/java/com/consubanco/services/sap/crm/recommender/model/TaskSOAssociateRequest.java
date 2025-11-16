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
public class TaskSOAssociateRequest implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private String applicationId;
	private String processId;
	private String enrollmentTaskId;
	private String serviceOrderId;
	private String recommenderBp;

	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * @param applicationId
	 *            the applicationId to set
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
	 * @param processId
	 *            the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	/**
	 * @return the enrollmentTaskId
	 */
	public String getEnrollmentTaskId() {
		return enrollmentTaskId;
	}

	/**
	 * @param enrollmentTaskId
	 *            the enrollmentTaskId to set
	 */
	public void setEnrollmentTaskId(String enrollmentTaskId) {
		this.enrollmentTaskId = enrollmentTaskId;
	}

	/**
	 * @return the serviceOrderId
	 */
	public String getServiceOrderId() {
		return serviceOrderId;
	}

	/**
	 * @param serviceOrderId
	 *            the serviceOrderId to set
	 */
	public void setServiceOrderId(String serviceOrderId) {
		this.serviceOrderId = serviceOrderId;
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
