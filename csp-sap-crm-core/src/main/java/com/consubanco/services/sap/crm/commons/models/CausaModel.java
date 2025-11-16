/**
 * 
 */
package com.consubanco.services.sap.crm.commons.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author ramon.becerra
 *
 */
public class CausaModel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2945962338494178957L;

	private String clave = null;
	
	private String tipoCausa = null;
	
	/**
	 * 
	 */
	public CausaModel() {
		super();
	}

	

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}



	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}



	/**
	 * @return the tipoCausa
	 */
	public String getTipoCausa() {
		return tipoCausa;
	}



	/**
	 * @param tipoCausa the tipoCausa to set
	 */
	public void setTipoCausa(String tipoCausa) {
		this.tipoCausa = tipoCausa;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
