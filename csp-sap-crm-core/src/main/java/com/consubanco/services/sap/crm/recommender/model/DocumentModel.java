/**
 * 
 */
package com.consubanco.services.sap.crm.recommender.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author ramon.becerra
 *
 */
public class DocumentModel implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6312476868705290245L;

	private String filename = null;
	
	private String url = null;
	
	private String base64Content = null;
	
	
	
	/**
	 * 
	 */
	public DocumentModel() {
		super();
	}

	
	

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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}




	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}




	/**
	 * @return the base64Content
	 */
	public String getBase64Content() {
		return base64Content;
	}




	/**
	 * @param base64Content the base64Content to set
	 */
	public void setBase64Content(String base64Content) {
		this.base64Content = base64Content;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
