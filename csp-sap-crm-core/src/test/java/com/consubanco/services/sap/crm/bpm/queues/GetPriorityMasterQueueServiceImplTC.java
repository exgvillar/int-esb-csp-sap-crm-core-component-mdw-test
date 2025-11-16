package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class GetPriorityMasterQueueServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetPriorityMasterQueueServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetPriorityMasterQueueServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetPriorityMasterQueueServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();

		String executorRole = "CAPTURA";
		String taskPriorityKey = "" ; //1
		String taskPriorityDesc = "MUY_ALTA";
        
		ArrayList<IProxyOutputData> returnList = processImpl.getPriorityMasterQueue( executorRole, taskPriorityKey, taskPriorityDesc );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
