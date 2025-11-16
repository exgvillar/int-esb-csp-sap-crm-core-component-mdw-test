package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class AvailableUsersServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( AvailableUsersServiceImplTC.class );
	
	/**
	 * 
	 */
	public AvailableUsersServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public AvailableUsersServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData inputData = new ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData();
		inputData.setAreaKey(""); //1
		inputData.setAreaDesc(""); //CAPTURA
		inputData.setStatusKey("");//1
		inputData.setStatusDesc(""); //ACTIVO
		inputData.setConvenioId("");//10000027
		inputData.setProductCategoryId(""); //LCOM
		inputData.setSourceChannelId(""); //Z01
		inputData.setNumberAssignedRequests(0);
		inputData.setMaxNumberRecords( 50 );
		inputData.setLastUserAssigned("BRASSO"); //BRASSO
		
		ArrayList<IProxyOutputData> returnList = processImpl.availableUsers( inputData );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
