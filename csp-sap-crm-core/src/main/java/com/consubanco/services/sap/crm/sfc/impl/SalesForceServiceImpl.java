package com.consubanco.services.sap.crm.sfc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.consubanco.sap.interfaces.sfc.ZCRMSF_P001_ADD_CONTROL_ProxyImpl;
import com.consubanco.services.sap.crm.sfc.ISalesforceService;
import com.consubanco.services.sap.crm.sfc.model.RegisterApplicationECMReq;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class SalesForceServiceImpl implements ISalesforceService {

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.sfc.ISalesforceService#registerApplicationECM(com.consubanco.services.sap.crm.sfc.model.RegisterApplicationECMReq)
	 */
	public List<IProxyOutputData> registerApplicationECM(RegisterApplicationECMReq request) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMSF_P001_ADD_CONTROL_ProxyImpl proxy = new ZCRMSF_P001_ADD_CONTROL_ProxyImpl();
        
        List<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_APPLICATIONID");
        input.setValue( request.getApplicationId());
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_APPLICATIONCRM");
        input.setValue( Formatter.fillStringWithZerosOnLeft( StringUtils.trimToEmpty( request.getApplicationCRM()), 10));
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_OPPORTUNITYSFC");
        input.setValue( request.getApportunitySFC() );
        inputParams.add( input ); 
        input = new ProxyInputParameter();
        input.setKey("I_FILENET_KEY");
        input.setValue( request.getFilenetId() );
        inputParams.add( input ); 
        
        return proxy.executeRemoteFunction(destination, inputParams );
	}
}
