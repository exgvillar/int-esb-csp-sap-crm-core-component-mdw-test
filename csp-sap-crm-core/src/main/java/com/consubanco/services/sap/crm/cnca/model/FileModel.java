package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class FileModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5099869026397758216L;
	private String fileName;
	private String base64;

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the base64
	 */
	public String getBase64() {
		return base64;
	}
	/**
	 * @param base64 the base64 to set
	 */
	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
