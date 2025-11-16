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
public class GetProductCategoriesServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetProductCategoriesServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetProductCategoriesServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetProductCategoriesServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<IProxyOutputData> returnList = processImpl.getProductCategories();
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
