package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CncaSipreResultsModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2034052281954910356L;
	private String taskId;
	private String accountId;
	private GenericCatalogModel statusSipre;
	private List<FileModel> fileEvidences = new ArrayList<FileModel>();	
	
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
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the statusSipre
	 */
	public GenericCatalogModel getStatusSipre() {
		return statusSipre;
	}
	/**
	 * @param statusSipre the statusSipre to set
	 */
	public void setStatusSipre(GenericCatalogModel statusSipre) {
		this.statusSipre = statusSipre;
	}
	/**
	 * @return the fileEvidences
	 */
	public List<FileModel> getFileEvidences() {
		return fileEvidences;
	}
	/**
	 * @param fileEvidences the fileEvidences to set
	 */
	public void setFileEvidences(List<FileModel> fileEvidences) {
		this.fileEvidences = fileEvidences;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
