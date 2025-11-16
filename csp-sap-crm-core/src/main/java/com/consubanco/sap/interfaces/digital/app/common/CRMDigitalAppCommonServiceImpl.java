/**
 * 
 */
package com.consubanco.sap.interfaces.digital.app.common;

import java.util.ArrayList;

import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class CRMDigitalAppCommonServiceImpl implements ICRMDigitalAppCommonService {

//	private static Log log = LogFactory.getLog( CRMDigitalAppCommonServiceImpl.class );
	/**
	 * 
	 */
	public CRMDigitalAppCommonServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consubanco.sap.services.core.bankaya.core.ICRMBKYCoreService#checkTermConditionsByCustomer( String customerBp, String sourceChannelApp ) throws Exception
	 */
	public ArrayList<IProxyOutputData> checkTermConditionsByCustomer( String customerBp, String sourceChannelApp ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImpl proxy = new ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ZBP");
        input.setValue( Formatter.fillStringWithZerosOnLeft(customerBp, 10) ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_ZSOURCE_CH_APP");
        input.setValue( sourceChannelApp );
        inputParams.add( input );
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );

        return ( returnData );
	}

	/* (non-Javadoc)
	 * @see com.consubanco.sap.services.core.bankaya.core.ICRMBKYCoreService#updateTermsConditionByCustomer( String customerBp, String sourceChannelApp, boolean termsConditionsAccepted ) throws Exception
	 */
	public ArrayList<IProxyOutputData> updateTermsConditionByCustomer( String customerBp, String sourceChannelApp, boolean termsConditionsAccepted ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMCMM_P001_SAVE_TRMCND_BY_BP_ProxyImpl proxy = new ZCRMCMM_P001_SAVE_TRMCND_BY_BP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ZBP");
        input.setValue( Formatter.fillStringWithZerosOnLeft(customerBp, 10) ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_ZSOURCE_CH_APP");
        input.setValue( sourceChannelApp );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_ZACEPTA_TERM_COND");
        input.setValue( termsConditionsAccepted ? "X" : "" );
        inputParams.add( input );
	            
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	
	    return ( returnData );
	}
	
	
}
