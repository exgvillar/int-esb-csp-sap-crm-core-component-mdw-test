/**
 * 
 */
package com.consubanco.services.sap.crm.cm;

import java.util.ArrayList;
import com.consubanco.sap.interfaces.proxy.cm.ZCRMCOM_ADD_INFOGLOB_ProxyImpl;
import com.consubanco.sap.interfaces.proxy.cm.ZCRMCOM_GET_INFOGLOB_ProxyImpl;
import com.consubanco.sap.interfaces.proxy.cm.ZCRMCOM_GET_ORGANIGRAMA_ProxyImpl;
import com.consubanco.services.sap.crm.cm.models.ApplicationModel;
import com.consubanco.services.sap.crm.cm.models.BranchModel;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class CMServiceImpl implements ICMService {

//	private static Log log = LogFactory.getLog( CRMBPMQueuesServiceImpl.class );
	/**
	 * 
	 */
	public CMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<IProxyOutputData> saveAmountByApplication( ApplicationModel applicationInput ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMCOM_ADD_INFOGLOB_ProxyImpl proxy = new ZCRMCOM_ADD_INFOGLOB_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SUCURSAL");
        input.setValue( applicationInput.getBranchId() ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_NUMSOL");
        input.setValue( Formatter.fillStringWithZerosOnLeft( applicationInput.getFolioApplication() , 10) ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_MONTO_SOLI");
        input.setValue( "" + applicationInput.getRequestAmount() ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_MONTO_CNCA");
        input.setValue( "" + applicationInput.getCncaAmount() );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_MONTO_INTE");
        input.setValue( "" + applicationInput.getIntercompanyAmount() );
        inputParams.add( input );
               
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
               
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> getInfoByAppAndBranch( String folioApplication, BranchModel branchInput ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMCOM_GET_INFOGLOB_ProxyImpl proxy = new ZCRMCOM_GET_INFOGLOB_ProxyImpl();
	    
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
	    input.setKey("I_SUCURSAL");
	    input.setValue( branchInput.getBranchId() ); 
	    inputParams.add( input );
	    
	    input = new ProxyInputParameter();
	    input.setKey("I_FECINI");
	    input.setType("java.util.Date");
	    input.setDateValue( branchInput.getStartDate() );
	    inputParams.add( input );
	    
	    input = new ProxyInputParameter();
	    input.setKey("I_FECFIN");
	    input.setType("java.util.Date");
	    input.setDateValue( branchInput.getEndDate() ); 
	    inputParams.add( input );
	    	           
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	    
	    //organigrama
	    ZCRMCOM_GET_ORGANIGRAMA_ProxyImpl proxy2 = new ZCRMCOM_GET_ORGANIGRAMA_ProxyImpl();
        
        inputParams = new ArrayList<ProxyInputParameter>();
        input = new ProxyInputParameter();
        input.setKey("I_NUMDOC");
        input.setValue( Formatter.fillStringWithZerosOnLeft( folioApplication , 10) ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FECINI");
        input.setType("java.util.Date");
	    input.setDateValue( branchInput.getStartDate() );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FECFIN");
        input.setType("java.util.Date");
	    input.setDateValue( branchInput.getEndDate() ); 
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData2 = proxy2.executeRemoteFunction(destination, inputParams );
        
        returnData.addAll( returnData2 );
	           
		return ( returnData );
	}
	
}
