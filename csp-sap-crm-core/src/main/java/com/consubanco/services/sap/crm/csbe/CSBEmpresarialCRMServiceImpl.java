/**
 * 
 */
package com.consubanco.services.sap.crm.csbe;

import java.util.ArrayList;


import com.consubanco.sap.interfaces.cxn.csbe.ZCRMCTEM_E002_SOLBYCLIENT_ProxyImpl;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class CSBEmpresarialCRMServiceImpl implements CSBEmpresarialCRMService {

//	private static Log log = LogFactory.getLog( CSBEmpresarialCRMServiceImpl.class );
	/**
	 * 
	 */
	public CSBEmpresarialCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons#getGenericCatalog( int catalogId, String parentKeyId ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getApplicationsTransitByBp( String bpId, String rfc ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMCTEM_E002_SOLBYCLIENT_ProxyImpl proxy = new ZCRMCTEM_E002_SOLBYCLIENT_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLIENTE");
        input.setValue( Formatter.fillStringWithZerosOnLeft( bpId, 10 ) );
        inputParams.add( input );

        input = new ProxyInputParameter();
        input.setKey("I_RFC");
        input.setValue( rfc );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
		return ( returnData );
	}
	
}
