/**
 * 
 */
package com.consubanco.services.sap.crm.commons.geolocalization.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class GeolocalizationRequest implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4781108809801500064L;

	private String bp = null;
	
	private String operationTypeId = null;
	
	private String sourceId = null;
	
	private Date geoDate = null;
	
	private String geoHour = null;
	
	private String latitud  = null;
	
	private String longitud = null;
	
	private String addressIP = null;
	
	private String deviceInfo = null;
	
	private String customName1 = null;
	
	private String customValue1 = null;
	
	private String customName2 = null;
	
	private String customValue2 = null;
	
	private String customName3 = null;
	
	private String customValue3 = null;
	
	/**
	 * 
	 */
	public GeolocalizationRequest() {
		super();
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getOperationTypeId() {
		return operationTypeId;
	}

	public void setOperationTypeId(String operaationTypeId) {
		this.operationTypeId = operaationTypeId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Date getGeoDate() {
		return geoDate;
	}

	public void setGeoDate(Date geoDate) {
		this.geoDate = geoDate;
	}

	public String getGeoHour() {
		return geoHour;
	}

	public void setGeoHour(String geoHour) {
		this.geoHour = geoHour;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getAddressIP() {
		return addressIP;
	}

	public void setAddressIP(String addressIP) {
		this.addressIP = addressIP;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getCustomName1() {
		return customName1;
	}

	public void setCustomName1(String customName1) {
		this.customName1 = customName1;
	}

	public String getCustomValue1() {
		return customValue1;
	}

	public void setCustomValue1(String customValue1) {
		this.customValue1 = customValue1;
	}

	public String getCustomName2() {
		return customName2;
	}

	public void setCustomName2(String customName2) {
		this.customName2 = customName2;
	}

	public String getCustomValue2() {
		return customValue2;
	}

	public void setCustomValue2(String customValue2) {
		this.customValue2 = customValue2;
	}

	public String getCustomName3() {
		return customName3;
	}

	public void setCustomName3(String customName3) {
		this.customName3 = customName3;
	}

	public String getCustomValue3() {
		return customValue3;
	}

	public void setCustomValue3(String customValue3) {
		this.customValue3 = customValue3;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
