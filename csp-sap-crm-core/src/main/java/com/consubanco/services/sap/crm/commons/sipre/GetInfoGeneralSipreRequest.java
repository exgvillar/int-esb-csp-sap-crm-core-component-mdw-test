package com.consubanco.services.sap.crm.commons.sipre;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GetInfoGeneralSipreRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3075046182380917329L;
	private String taskId;
	private String customerBP;
	private String curp;
	
	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the customerBP
	 */
	public String getCustomerBP() {
		return customerBP;
	}
	/**
	 * @param customerBP the customerBP to set
	 */
	public void setCustomerBP(String customerBP) {
		this.customerBP = customerBP;
	}
	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
