/**
 * 
 */
package com.consubanco.services.sap.crm.commons.geolocalization;

import java.io.Serializable;
import java.util.ArrayList;

import com.consubanco.services.sap.crm.commons.geolocalization.models.GeolocalizationRequest;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public interface IGeolocalizationService extends Serializable  {
	
	
	public ArrayList<IProxyOutputData> registerGeolocalization( GeolocalizationRequest geolocalizationRequest ) throws Exception;
		
}
