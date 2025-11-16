/**
 * 
 */
package com.consupago.services.sap.crm.lcom;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.lcom.ZRFC_SMSLCOM_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class LCOM_SMS_ServiceImpl implements ILCOM_SMS_Service {

	/**
	 * 
	 */
	public LCOM_SMS_ServiceImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.lcom.ILCOM_SMS_Service#getLCOMPurchasedOperations(java.lang.String, java.util.ArrayList)
	 */
	public ArrayList<IProxyOutputData> getLCOMPurchasedOperations(
			String status, ArrayList<String> categoryList) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_SMSLCOM_ProxyImpl proxy = new ZRFC_SMSLCOM_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ESTATUS");
        input.setValue( status );
        inputParams.add( input );
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, categoryList );
        
        return( returnData );
	}

}
