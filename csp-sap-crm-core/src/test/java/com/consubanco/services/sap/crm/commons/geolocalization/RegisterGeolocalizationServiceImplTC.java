package com.consubanco.services.sap.crm.commons.geolocalization;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.commons.geolocalization.models.GeolocalizationRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class RegisterGeolocalizationServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( RegisterGeolocalizationServiceImplTC.class );
	
	/**
	 * 
	 */
	public RegisterGeolocalizationServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public RegisterGeolocalizationServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		IGeolocalizationService processImpl = new GeolocalizationServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();

		GeolocalizationRequest geolocalizationRequest = new GeolocalizationRequest();
		geolocalizationRequest.setBp( "143" );
		geolocalizationRequest.setOperationTypeId("1002");
		geolocalizationRequest.setSourceId("MICSB");
		geolocalizationRequest.setGeoDate( java.sql.Date.valueOf("2021-07-03") );
		geolocalizationRequest.setGeoHour( "16:56:12" );
		geolocalizationRequest.setLatitud("-1.567890");
		geolocalizationRequest.setLongitud("-8.45678");
		geolocalizationRequest.setAddressIP("10.0.0.12");
		geolocalizationRequest.setDeviceInfo("ANDROID");
		geolocalizationRequest.setCustomName1("session-id");
		geolocalizationRequest.setCustomValue1("005056B325DB1EEBB6BD9C7EFD1582ED");
		geolocalizationRequest.setCustomName2("folio-solicitud");
		geolocalizationRequest.setCustomValue2("0050102569");
		geolocalizationRequest.setCustomName3("bp-id");
		geolocalizationRequest.setCustomValue3("1745236");
        
		ArrayList<IProxyOutputData> returnList = processImpl.registerGeolocalization(geolocalizationRequest);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
