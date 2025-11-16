/**
 * 
 */
package com.consupago.services.sap.crm.webpage;

import java.util.ArrayList;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.regions.CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class PricingServiceCoreImpl implements IPricingService {

	/**
	 * 
	 */
	public PricingServiceCoreImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.webpage.IPricingService#getStates()
	 */
	public ArrayList<IProxyOutputData> getStates() throws Exception {

		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImpl proxy = new CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IV_COUNTRY");
        input.setValue( "MX" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IV_LANGUAGE");
        input.setValue( "ES" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return( returnData );
        
	}

}
