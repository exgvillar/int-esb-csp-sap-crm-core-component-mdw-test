/**
 * 
 */
package com.consubanco.services.sap.crm.recommender.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class UpdateServiceOrderStatusAndLoteRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 479251358950697746L;

	private String idOrdenServicio;
	private String idEstatus;
	private String idLote;
	private String concepto;
	private String codigo;
	private String atmRetiro;

	/**
	 * @return the idOrdenServicio
	 */
	public String getIdOrdenServicio() {
		return idOrdenServicio;
	}

	/**
	 * @param idOrdenServicio
	 *            the idOrdenServicio to set
	 */
	public void setIdOrdenServicio(String idOrdenServicio) {
		this.idOrdenServicio = idOrdenServicio;
	}

	/**
	 * @return the idEstatus
	 */
	public String getIdEstatus() {
		return idEstatus;
	}

	/**
	 * @param idEstatus
	 *            the idEstatus to set
	 */
	public void setIdEstatus(String idEstatus) {
		this.idEstatus = idEstatus;
	}

	/**
	 * @return the idLote
	 */
	public String getIdLote() {
		return idLote;
	}

	/**
	 * @param idLote
	 *            the idLote to set
	 */
	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}

	/**
	 * @return the concepto
	 */
	public String getConcepto() {
		return concepto;
	}

	/**
	 * @param concepto
	 *            the concepto to set
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the atmRetiro
	 */
	public String getAtmRetiro() {
		return atmRetiro;
	}

	/**
	 * @param atmRetiro
	 *            the atmRetiro to set
	 */
	public void setAtmRetiro(String atmRetiro) {
		this.atmRetiro = atmRetiro;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
