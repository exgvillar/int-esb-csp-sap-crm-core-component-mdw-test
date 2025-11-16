package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GetAccounstByFolioSipreModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3534097217381432437L;
	private String account;
	private String folioReleaseLetter;
	private String taskId;
	private boolean findFiles;

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the folioReleaseLetter
	 */
	public String getFolioReleaseLetter() {
		return folioReleaseLetter;
	}

	/**
	 * @param folioReleaseLetter the folioReleaseLetter to set
	 */
	public void setFolioReleaseLetter(String folioReleaseLetter) {
		this.folioReleaseLetter = folioReleaseLetter;
	}

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
	 * @return the findFiles
	 */
	public boolean isFindFiles() {
		return findFiles;
	}

	/**
	 * @param findFiles the findFiles to set
	 */
	public void setFindFiles(boolean findFiles) {
		this.findFiles = findFiles;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
