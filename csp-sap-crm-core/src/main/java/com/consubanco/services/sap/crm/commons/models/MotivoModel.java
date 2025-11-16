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
public class MotivoModel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2945962338494178957L;

	private String clave = null;
	
	private String tipoMotivo = null;
	
	/**
	 * 
	 */
	public MotivoModel() {
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
	 * @return the tipoMotivo
	 */
	public String getTipoMotivo() {
		return tipoMotivo;
	}



	/**
	 * @param tipoMotivo the tipoMotivo to set
	 */
	public void setTipoMotivo(String tipoMotivo) {
		this.tipoMotivo = tipoMotivo;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
