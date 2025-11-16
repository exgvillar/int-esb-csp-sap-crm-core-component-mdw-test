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
public class GetAttentionTimesServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetAttentionTimesServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetAttentionTimesServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetAttentionTimesServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		//ArrayList<IProxyOutputData> returnList = processImpl.getUsersCox("10001950", "brasso");
		ArrayList<IProxyOutputData> returnList = processImpl.getAttentionTimes("", "");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
