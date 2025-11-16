/**
 * 
 */
package com.consupago.services.sap.crm.dynamics;

import java.util.ArrayList;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.dynamics.ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImpl;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class DynamicsCRMServiceImpl implements IDynamicsCRMService {

//	private static Log log = LogFactory.getLog( DynamicsCRMServiceImpl.class );
	/**
	 * 
	 */
	public DynamicsCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.dynamics.IDynamicsCRMService#getValueFieldByConvenio( String crmConvenio, String brmsConvenio, String documentId, String fieldId, String value ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getValueFieldByConvenio( String crmConvenio, String brmsConvenio, String documentId, String fieldId, String value ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImpl proxy = new ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CONVENIO_CRM");
        input.setValue( crmConvenio ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CONVENIO_BRMS");
        input.setValue( brmsConvenio );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DOCUMENTO");
        input.setValue( documentId );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CAMPO");
        input.setValue( fieldId );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_VALOR");
        input.setValue( value );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
		
}
