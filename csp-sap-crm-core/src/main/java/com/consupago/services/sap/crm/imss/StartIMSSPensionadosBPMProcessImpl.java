/**
 * 
 */
package com.consupago.services.sap.crm.imss;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.imss.ZRFC_START_BPM_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class StartIMSSPensionadosBPMProcessImpl implements
		IStarterIMSSPensionadosService {

	/**
	 * 
	 */
	public StartIMSSPensionadosBPMProcessImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.imss.IStarterIMSSPensionadosService#startBPMProcess(java.lang.String, java.lang.String)
	 */
	public ArrayList<IProxyOutputData> startBPMProcess(String status,
			String saveFlag) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_START_BPM_ProxyImpl proxy = new ZRFC_START_BPM_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_STATUS");
        input.setValue( status );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SAVE");
        input.setValue( saveFlag );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return( returnData );
	}

}
