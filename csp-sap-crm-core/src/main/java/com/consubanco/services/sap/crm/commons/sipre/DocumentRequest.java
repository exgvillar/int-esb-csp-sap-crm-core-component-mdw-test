package com.consubanco.services.sap.crm.commons.sipre;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class DocumentRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4305838237199255421L;
	private String filename;
	private String base64;
	
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
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
