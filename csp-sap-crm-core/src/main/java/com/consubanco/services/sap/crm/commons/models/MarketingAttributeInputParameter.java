/**
 * 
 */
package com.consubanco.services.sap.crm.commons.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class MarketingAttributeInputParameter implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4781108809801500064L;

	private String attributeGroupId = null;
	
	private String attributeGroupDesc = null;
	
	private String attributeId = null;
	
	private String attributeDesc = null;
	
	private String attributeValue = null;
		
	
	
	
	/**
	 * 
	 */
	public MarketingAttributeInputParameter() {
		super();
	}

	
	


	/**
	 * @return the attributeGroupId
	 */
	public String getAttributeGroupId() {
		return attributeGroupId;
	}





	/**
	 * @param attributeGroupId the attributeGroupId to set
	 */
	public void setAttributeGroupId(String attributeGroupId) {
		this.attributeGroupId = attributeGroupId;
	}





	/**
	 * @return the attributeGroupDesc
	 */
	public String getAttributeGroupDesc() {
		return attributeGroupDesc;
	}





	/**
	 * @param attributeGroupDesc the attributeGroupDesc to set
	 */
	public void setAttributeGroupDesc(String attributeGroupDesc) {
		this.attributeGroupDesc = attributeGroupDesc;
	}





	/**
	 * @return the attributeId
	 */
	public String getAttributeId() {
		return attributeId;
	}





	/**
	 * @param attributeId the attributeId to set
	 */
	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}





	/**
	 * @return the attributeDesc
	 */
	public String getAttributeDesc() {
		return attributeDesc;
	}





	/**
	 * @param attributeDesc the attributeDesc to set
	 */
	public void setAttributeDesc(String attributeDesc) {
		this.attributeDesc = attributeDesc;
	}





	/**
	 * @return the attributeValue
	 */
	public String getAttributeValue() {
		return attributeValue;
	}





	/**
	 * @param attributeValue the attributeValue to set
	 */
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
