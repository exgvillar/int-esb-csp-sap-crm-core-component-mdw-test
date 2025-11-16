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
public class GetCatalogConfFieldsServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetCatalogConfFieldsServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetCatalogConfFieldsServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetCatalogConfFieldsServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<IProxyOutputData> returnList = processImpl.getCatalogConfField();
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
