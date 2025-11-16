/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.externalPortal.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author consubanco
 *
 */
public class SaveResultPortalRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String solicitud;
	private String idPortal;
	private String reserva;
	private String contrato;
	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}
	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	/**
	 * @return the idPortal
	 */
	public String getIdPortal() {
		return idPortal;
	}
	/**
	 * @param idPortal the idPortal to set
	 */
	public void setIdPortal(String idPortal) {
		this.idPortal = idPortal;
	}
	/**
	 * @return the reserva
	 */
	public String getReserva() {
		return reserva;
	}
	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(String reserva) {
		this.reserva = reserva;
	}
	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
