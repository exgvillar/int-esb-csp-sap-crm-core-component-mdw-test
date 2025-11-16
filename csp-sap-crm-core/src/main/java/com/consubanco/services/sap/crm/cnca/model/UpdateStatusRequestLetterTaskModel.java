package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UpdateStatusRequestLetterTaskModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4572629999809929479L;
	private String taskId;
	private GenericCatalogModel status;	
	
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
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
