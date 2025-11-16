/**
 * 
 */
package com.consubanco.services.sap.crm.cobranza;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cobranza.requests.ZCRMCOB_INFO_COMP_ProxyImpl;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class CobranzaCRMServiceImpl implements CobranzaCRMService {

	private static Log log = LogFactory.getLog( CobranzaCRMServiceImpl.class );
	/**
	 * 
	 */
	public CobranzaCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cobranza#getInfoRequests( ArrayList<String> accounts ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getInfoRequests( ArrayList<String> accounts ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMCOB_INFO_COMP_ProxyImpl proxy = new ZCRMCOB_INFO_COMP_ProxyImpl();
        
		ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        for( String account : accounts ){
        	// tableParams - record1
            ArrayList<ProxyInputParameter> recordParams = new ArrayList<ProxyInputParameter>();
            ProxyInputParameter inputRecord = new ProxyInputParameter();
            inputRecord.setKey("ZCUENTA");
            inputRecord.setValue( Formatter.fillStringWithZerosOnLeft( account , 10) );
            recordParams.add( inputRecord );
            
            inputParams.getRecordParam().add( recordParams );
        }
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        
 		return ( returnData );
	}
	
}
