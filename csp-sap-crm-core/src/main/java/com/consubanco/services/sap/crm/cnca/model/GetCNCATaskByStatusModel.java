package com.consubanco.services.sap.crm.cnca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GetCNCATaskByStatusModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9072865426090297003L;
	private List<GenericCatalogModel> status = new ArrayList<GenericCatalogModel>();
	private String promotorBp;
	
	/**
	 * @return the status
	 */
	public List<GenericCatalogModel> getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(List<GenericCatalogModel> status) {
		this.status = status;
	}	
	/**
	 * @return the promotorBp
	 */
	public String getPromotorBp() {
		return promotorBp;
	}
	/**
	 * @param promotorBp the promotorBp to set
	 */
	public void setPromotorBp(String promotorBp) {
		this.promotorBp = promotorBp;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
