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
public class MensajeModel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4314994918225577004L;

	private String clave = null;
	
	private String descripcionExterna = null;
	
	private String descripcionInterna = null;
	
	private CausaModel causa = null;
	
	private MotivoModel motivo = null;
	
	private String clasificacion = null;
	
	private long contadorBPM = 0;
	
	private boolean reprocesable = false;
	
	private boolean resuelto = false;
	
	/**
	 * 
	 */
	public MensajeModel() {
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
	 * @return the descripcionExterna
	 */
	public String getDescripcionExterna() {
		return descripcionExterna;
	}




	/**
	 * @param descripcionExterna the descripcionExterna to set
	 */
	public void setDescripcionExterna(String descripcionExterna) {
		this.descripcionExterna = descripcionExterna;
	}




	/**
	 * @return the descripcionInterna
	 */
	public String getDescripcionInterna() {
		return descripcionInterna;
	}




	/**
	 * @param descripcionInterna the descripcionInterna to set
	 */
	public void setDescripcionInterna(String descripcionInterna) {
		this.descripcionInterna = descripcionInterna;
	}




	/**
	 * @return the causa
	 */
	public CausaModel getCausa() {
		return causa;
	}




	/**
	 * @param causa the causa to set
	 */
	public void setCausa(CausaModel causa) {
		this.causa = causa;
	}




	/**
	 * @return the motivo
	 */
	public MotivoModel getMotivo() {
		return motivo;
	}




	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(MotivoModel motivo) {
		this.motivo = motivo;
	}




	/**
	 * @return the clasificacion
	 */
	public String getClasificacion() {
		return clasificacion;
	}




	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}


	


	/**
	 * @return the contadorBPM
	 */
	public long getContadorBPM() {
		return contadorBPM;
	}




	/**
	 * @param contadorBPM the contadorBPM to set
	 */
	public void setContadorBPM(long contadorBPM) {
		this.contadorBPM = contadorBPM;
	}




	/**
	 * @return the reprocesable
	 */
	public boolean isReprocesable() {
		return reprocesable;
	}




	/**
	 * @param reprocesable the reprocesable to set
	 */
	public void setReprocesable(boolean reprocesable) {
		this.reprocesable = reprocesable;
	}




	/**
	 * @return the resuelto
	 */
	public boolean isResuelto() {
		return resuelto;
	}




	/**
	 * @param resuelto the resuelto to set
	 */
	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
