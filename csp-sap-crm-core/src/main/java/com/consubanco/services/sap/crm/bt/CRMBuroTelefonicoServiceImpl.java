/**
 * 
 */
package com.consubanco.services.sap.crm.bt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.consubanco.sap.interfaces.bt.ZCRMBT_E001_BUSCA_TEL_BP_ProxyImpl;
import com.consubanco.sap.interfaces.bt.ZCRMBT_P003_SAVE_DICTAMEN_BRMS_OutputData;
import com.consubanco.sap.interfaces.bt.ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImpl;
import com.consubanco.sap.interfaces.bt.ZCRMBT_P004_SAVE_INCIDENCIAS_OutputData;
import com.consubanco.sap.interfaces.bt.ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImpl;
import com.consubanco.sap.interfaces.bt.model.ZESCRMBT_E002_INCIDENCIAS_Model;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class CRMBuroTelefonicoServiceImpl implements CRMBuroTelefonicoService {

//	private static Log log = LogFactory.getLog( CRMBuroTelefonicoServiceImpl.class );
	/**
	 * 
	 */
	public CRMBuroTelefonicoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public ArrayList<IProxyOutputData> searchPhoneByOwner( String bp, String rfc, String curp, String name1, String name2, String lastName1, String lastName2 ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMBT_E001_BUSCA_TEL_BP_ProxyImpl proxy = new ZCRMBT_E001_BUSCA_TEL_BP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        if( StringUtils.isEmpty( bp ) )
        	input.setValue( "" );
        else
        	input.setValue( Formatter.fillStringWithZerosOnLeft(bp, 10) ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_RFC");
        input.setValue( rfc ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_CURP");
        input.setValue( curp ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_PRIMER_NOMBRE");
        input.setValue( name1 );  
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_SEGUNDO_NOMBRE");
        input.setValue( name2 );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_APELLIDO_PATERNO");
        input.setValue( lastName1 );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_APELLIDO_MATERNO");
        input.setValue( lastName2 ); 
        inputParams.add( input );
		
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return ( returnData );
	}


	public ArrayList<IProxyOutputData> saveDictamenBrmsAndIncidences(
			String idSolicitud, String bpId, String phone,
			boolean dictamenBrms, String protocolCalledQuality,
			String ownerPhoneBp,
			List<ZESCRMBT_E002_INCIDENCIAS_Model> incidences) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImpl proxy = new ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue( Formatter.fillStringWithZerosOnLeft(idSolicitud,10) ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue(  Formatter.fillStringWithZerosOnLeft(bpId,10)  ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_DICTAMEN_BRMS");
        input.setValue( dictamenBrms ? "X" : "" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_TELEFONO");
        input.setValue( phone ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_PROTOCOLO");
        input.setValue( protocolCalledQuality ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_BP_PHONE_OWNER");
        input.setValue( Formatter.fillStringWithZerosOnLeft(ownerPhoneBp != null ? ownerPhoneBp : "",10) ); 
        inputParams.add( input );
        
           
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        Iterator<IProxyOutputData> iterator = returnData.iterator();
        while (iterator.hasNext()) {
        	ZCRMBT_P003_SAVE_DICTAMEN_BRMS_OutputData outputData = (ZCRMBT_P003_SAVE_DICTAMEN_BRMS_OutputData)iterator.next();
        	if(outputData.isSuccess()){
        		if(incidences != null && !incidences.isEmpty())
        			returnData = new ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImpl().executeRemoteFunction(destination, incidences);
        		else{
        			returnData = new ArrayList<IProxyOutputData>();
            		returnData.add(new ZCRMBT_P004_SAVE_INCIDENCIAS_OutputData(true, ""));
        		}
        	}else{
        		returnData = new ArrayList<IProxyOutputData>();
        		returnData.add(new ZCRMBT_P004_SAVE_INCIDENCIAS_OutputData(false, outputData.getMessage()));
        	}
			
		}
        
        return returnData;
	}

	
}
