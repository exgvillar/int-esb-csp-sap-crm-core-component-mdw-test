package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P008_UNLOCK_BP_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class UnlockUsersCoxServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( UnlockUsersCoxServiceImplTC.class );
	
	/**
	 * 
	 */
	public UnlockUsersCoxServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public UnlockUsersCoxServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZCRMWKQUE_P008_UNLOCK_BP_OutputData inputData = new ZCRMWKQUE_P008_UNLOCK_BP_OutputData();
		inputData.setUsersCox( new ArrayList<String>() );
		
		inputData.getUsersCox().add("0010001950");
		inputData.getUsersCox().add("14435");
		
		
		ArrayList<IProxyOutputData> returnList = processImpl.unlockUsersCox( inputData );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
