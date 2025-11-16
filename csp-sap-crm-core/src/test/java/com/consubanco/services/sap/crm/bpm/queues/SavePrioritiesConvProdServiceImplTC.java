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
public class SavePrioritiesConvProdServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SavePrioritiesConvProdServiceImplTC.class );
	
	/**
	 * 
	 */
	public SavePrioritiesConvProdServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SavePrioritiesConvProdServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
//		ArrayList<IProxyOutputData> returnList = processImpl.savePrioritiesConvProd("10000027", "RETN", 4);
		ArrayList<IProxyOutputData> returnList = processImpl.savePrioritiesConvProd("10000027", "", 4);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
