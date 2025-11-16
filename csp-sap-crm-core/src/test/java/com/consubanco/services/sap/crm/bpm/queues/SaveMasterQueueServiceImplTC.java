package com.consubanco.services.sap.crm.bpm.queues;

import java.sql.Date;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class SaveMasterQueueServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveMasterQueueServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveMasterQueueServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveMasterQueueServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData data = new ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData();
		data.setFolioApplication("0050385533");
        data.setProcessId("3e38dcf1b6c011e69844000000526c32");
        data.setTaskId("TASK3e38dcf1b6c011e69844000000526c32");
        data.setCorrelationId("CORR3e38dcf1b6c011e69844");
        data.setApplicationStatusKey("E0048");
        data.setApplicationStatusDesc("En espera Revisión M.control");
        data.setLastAssignationDate( Date.valueOf("2016-12-04") );
        data.setLastAssignationHour("19:00");
        data.setAssignedUser("BRASSO");
        data.setExecutorRole("CAPTURA");
        data.setNotificationRole("SUPERVISOR_COX");
        data.setReprocessingNumber( 0 );
        data.setRecapture( true );
        data.setExecuted( false );
        data.setElapsedTimeMins( 10 );
        data.setTaskPriorityKey( "2" );
        data.setTaskPriorityDesc( "ALTA" );
        data.setManualAssignationUser( true );
        data.setRate( 9 );
        data.setDeleteRecord( true );
        
		ArrayList<IProxyOutputData> returnList = processImpl.saveMasterQueue( data );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
