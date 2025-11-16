package com.consubanco.services.sap.crm.bpm.queues;

import java.sql.Date;
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
public class MonitorMasterQueueServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( MonitorMasterQueueServiceImplTC.class );
	
	/**
	 * 
	 */
	public MonitorMasterQueueServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public MonitorMasterQueueServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		Date startDate = Date.valueOf("2016-12-01");
		Date endDate = Date.valueOf("2016-12-22");
//		ArrayList<IProxyOutputData> returnList = processImpl.monitorMasterQueue(startDate, endDate, "10000252", "BRANGEL", "1");
		ArrayList<IProxyOutputData> returnList = processImpl.monitorMasterQueue(startDate, endDate, "", "", "");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
