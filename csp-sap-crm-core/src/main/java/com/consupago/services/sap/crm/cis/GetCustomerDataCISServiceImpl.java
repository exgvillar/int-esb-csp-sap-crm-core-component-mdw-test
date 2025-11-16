/**
 * 
 */
package com.consupago.services.sap.crm.cis;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.cis.ZRFC_CIS_DATOSBP_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class GetCustomerDataCISServiceImpl implements ICISService {

	private static Log log = LogFactory.getLog( GetCustomerDataCISServiceImpl.class );
	
	/**
	 * 
	 */
	public GetCustomerDataCISServiceImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cis.ICISService#getCustomerData(java.lang.String)
	 */
	public ArrayList<IProxyOutputData> getCustomerData(String businessPartnerId)
			throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_CIS_DATOSBP_ProxyImpl proxy = new ZRFC_CIS_DATOSBP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( businessPartnerId );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return( returnData );
	}

}
