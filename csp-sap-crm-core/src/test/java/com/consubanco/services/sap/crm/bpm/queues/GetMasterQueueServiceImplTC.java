package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class GetMasterQueueServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetMasterQueueServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetMasterQueueServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetMasterQueueServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();

		ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData data = new ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData();
        
		data.setProcessId( "" );//70bc269cb72911e6942d000000526c32
        data.setTaskId( "" );//TASK70bc269cb72911e6942d000000526c32
        data.setCorrelationId( "" );//CORR70bc269cb72911e6942d000
        data.setFolioApplication( "" );//0050385535
        data.setApplicationStatusKey( "" );//E0043
        data.setAssignedUser( "*" );//brasso o *
        data.setExecutorRole( "" );//CAPTURISTA
        data.setNotificationRole( "" );//SUPERVISOR_COX
        data.setReprocessingNumber( 0 );
        data.setRecapture( false );
        data.setTaskPriorityKey( "" );//1
        data.setTaskPriorityDesc( "" );//MUY ALTA
        data.setManualAssignationUser( false );
        
		ArrayList<IProxyOutputData> returnList = processImpl.getMasterQueue( data );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
