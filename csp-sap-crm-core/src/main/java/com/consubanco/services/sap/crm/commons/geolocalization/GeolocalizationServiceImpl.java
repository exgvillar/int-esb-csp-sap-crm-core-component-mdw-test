/**
 * 
 */
package com.consubanco.services.sap.crm.commons.geolocalization;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.geolocalization.ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImpl;
import com.consubanco.services.sap.crm.commons.geolocalization.models.GeolocalizationRequest;
import com.consubanco.services.sap.crm.commons.utils.Formatter;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class GeolocalizationServiceImpl implements IGeolocalizationService{

	private static final Log log = LogFactory.getLog(GeolocalizationServiceImpl.class);
	
	/**
	 * UID por default
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GeolocalizationServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons.geolocalization public ArrayList<IProxyOutputData> registerGeolocalization( GeolocalizationRequest geolocalizationRequest ) throws Exception
	 */
	public ArrayList<IProxyOutputData> registerGeolocalization( GeolocalizationRequest geolocalizationRequest ) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImpl proxy = new  ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        
        input.setKey("I_BP");
        input.setValue( Formatter.fillStringWithZerosOnLeft(geolocalizationRequest.getBp(), 10) ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TIPOOPERACIONID");
        input.setValue( geolocalizationRequest.getOperationTypeId() );
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_CANALID");
        input.setValue( geolocalizationRequest.getSourceId() );
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_GEODATE");
        input.setType("java.util.Date");
        input.setDateValue( geolocalizationRequest.getGeoDate() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_GEOHOUR");
        input.setValue( geolocalizationRequest.getGeoHour() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_LATITUD");
        input.setValue( geolocalizationRequest.getLatitud() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_LONGITUD");
        input.setValue( geolocalizationRequest.getLongitud() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_IPADDRESS");
        input.setValue( geolocalizationRequest.getAddressIP() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DEVICEINFO");
        input.setValue( geolocalizationRequest.getDeviceInfo() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMNAME1");
        input.setValue( geolocalizationRequest.getCustomName1() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMVALUE1");
        input.setValue( geolocalizationRequest.getCustomValue1() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMNAME2");
        input.setValue( geolocalizationRequest.getCustomName2() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMVALUE2");
        input.setValue( geolocalizationRequest.getCustomValue2() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMNAME3");
        input.setValue( geolocalizationRequest.getCustomName3() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMVALUE3");
        input.setValue( geolocalizationRequest.getCustomValue3() );
        inputParams.add( input );
		
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
		log.info(returnData.toString());
		
		return returnData;
	}
}
