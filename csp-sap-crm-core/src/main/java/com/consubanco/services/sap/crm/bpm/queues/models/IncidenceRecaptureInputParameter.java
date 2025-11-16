/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.queues.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class IncidenceRecaptureInputParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8035532743782885253L;

	private int id = 0;
	
	private String cause = null;
	
	private String motive = null;
	
	private String description = null;
	
	private boolean resolve = false;
	
	
	
	/**
	 * 
	 */
	public IncidenceRecaptureInputParameter() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cause
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * @param cause the cause to set
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}

	/**
	 * @return the motive
	 */
	public String getMotive() {
		return motive;
	}

	/**
	 * @param motive the motive to set
	 */
	public void setMotive(String motive) {
		this.motive = motive;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the resolve
	 */
	public boolean isResolve() {
		return resolve;
	}

	/**
	 * @param resolve the resolve to set
	 */
	public void setResolve(boolean resolve) {
		this.resolve = resolve;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
