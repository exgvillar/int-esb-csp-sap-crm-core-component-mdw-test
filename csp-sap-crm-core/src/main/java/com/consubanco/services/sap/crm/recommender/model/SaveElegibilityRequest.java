/**
 * 
 */
package com.consubanco.services.sap.crm.recommender.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.recommender.model.ElegibilityModel;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class SaveElegibilityRequest extends ElegibilityModel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5558443877716655337L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
