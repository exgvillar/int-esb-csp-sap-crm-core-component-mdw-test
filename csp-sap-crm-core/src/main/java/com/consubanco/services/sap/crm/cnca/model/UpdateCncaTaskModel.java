package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UpdateCncaTaskModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8457167403722074275L;
	private String taskId;
	private GenericCatalogModel status;	
	private String comments;
	
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
	 * @return the status
	 */
	public GenericCatalogModel getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(GenericCatalogModel status) {
		this.status = status;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
