/**
 * 
 */
package com.consubanco.services.sap.crm.common.relations;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.esb.validator.utils.Formatter;
import com.consubanco.sap.interfaces.commons.relations.ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class RelationAppProcessImpl {

	private static Log log = LogFactory.getLog( RelationAppProcessImpl.class );
	
	/**
	 * 
	 */
	public RelationAppProcessImpl() {
		super();
	}

	
	public ArrayList<IProxyOutputData> relationApplicationAndProcess( String folioApplication, String processId, String mode ) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        
        ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImpl proxy = new ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImpl();
		
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_MODE");
        input.setValue( mode );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SOLICIT");
        input.setValue( StringUtils.isEmpty( folioApplication ) ? folioApplication : Formatter.fillStringWithZerosOnLeft( folioApplication , 10 ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_PROCESS");
        input.setValue( processId );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );

        log.info( returnData.toArray() );
	
        return returnData;
        
	}
	
	
}
