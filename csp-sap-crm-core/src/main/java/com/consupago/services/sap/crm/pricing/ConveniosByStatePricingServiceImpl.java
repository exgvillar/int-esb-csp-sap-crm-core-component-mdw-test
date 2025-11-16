/**
 * 
 */
package com.consupago.services.sap.crm.pricing;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.convenios.ZCRM_GET_CAT_CONV_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ConveniosByStatePricingServiceImpl implements
		IConveniosByStatePricingService {

	private static Log log = LogFactory.getLog( ConveniosByStatePricingServiceImpl.class );
	
	/**
	 * 
	 */
	public ConveniosByStatePricingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.pricing.IConveniosByStatePricingService#getConveniosByState(java.lang.String, java.lang.String)
	 */
	public ArrayList<IProxyOutputData> getConveniosByState(String siglaEmpresa,
			String estado) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_GET_CAT_CONV_ProxyImpl proxy = new ZCRM_GET_CAT_CONV_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_EMP");
        input.setValue( siglaEmpresa );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("P_EDO");
        input.setValue( estado );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return( returnData );
	}

}
