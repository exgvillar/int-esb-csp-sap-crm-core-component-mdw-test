package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class GetConfigurablesFieldsServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetConfigurablesFieldsServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetConfigurablesFieldsServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetConfigurablesFieldsServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData data = new ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData();
		data.setId( "" ); //1
		data.setFieldName( "" );//monto-solicitado
        data.setType( "" );//2
        data.setValue( "" );//90000
        data.setRatePriority( 0 );//5
        data.setRequestedBy( "" );//hsanchezag
        data.setAuthorized( false ); 
        data.setAuthorizedBy( "" );//rbecerra
        data.setActive( false );
		
		ArrayList<IProxyOutputData> returnList = processImpl.getConfigurablesFields( data );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
