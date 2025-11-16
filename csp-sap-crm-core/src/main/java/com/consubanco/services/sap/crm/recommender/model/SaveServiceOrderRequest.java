/**
 * 
 */
package com.consubanco.services.sap.crm.recommender.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.recommender.model.ServiceOrderModel;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class SaveServiceOrderRequest extends ServiceOrderModel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5209636035635491933L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
