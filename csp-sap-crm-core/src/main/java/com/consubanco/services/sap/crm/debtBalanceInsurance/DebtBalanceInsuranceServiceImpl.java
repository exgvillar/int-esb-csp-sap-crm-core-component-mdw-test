/**
 * 
 */
package com.consubanco.services.sap.crm.debtBalanceInsurance;

import java.util.ArrayList;

import com.consubanco.sap.interfaces.debtBalanceInsurance.ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImpl;
import com.consubanco.sap.interfaces.debtBalanceInsurance.ZCRMSGDEU_UPDOSSEGDEUD_ProxyImpl;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class DebtBalanceInsuranceServiceImpl implements DebtBalanceInsuranceService {

//	private static Log log = LogFactory.getLog( CRMBPMQueuesServiceImpl.class );
	/**
	 * 
	 */
	public DebtBalanceInsuranceServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public ArrayList<IProxyOutputData> updateStatusDebtBalanceInsuranceServiceOrder( String serviceOrder, String statusId, String noteId, String observations ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMSGDEU_UPDOSSEGDEUD_ProxyImpl proxy = new ZCRMSGDEU_UPDOSSEGDEUD_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_ORDEN_SERVICIO");
        input.setValue( serviceOrder );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ESTATUS");
        input.setValue( statusId );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TEXTID");
        input.setValue( noteId );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_OBSERVACIONES");
        input.setValue( observations );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return ( returnData );
	}

	/**
	 * 
	 */
	public ArrayList<IProxyOutputData> getSSDAplications( String statusId ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImpl proxy = new ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImpl();
	    
	    ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
	    
	    ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_ESTATUS");
        input.setValue( statusId );
        inputParams.add( input );
	    
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	    
	    return ( returnData );
	}
	
	
}
