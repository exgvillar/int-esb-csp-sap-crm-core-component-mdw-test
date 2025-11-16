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
public class SearchConvenioServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SearchConvenioServiceImplTC.class );
	
	/**
	 * 
	 */
	public SearchConvenioServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SearchConvenioServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
//		ArrayList<IProxyOutputData> returnList = searchConvenioProd("10000027", "SEP", "1641" , "SEP_EFEC");
		ArrayList<IProxyOutputData> returnList = processImpl.searchConvenioProd("10000027", "", "", "" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
