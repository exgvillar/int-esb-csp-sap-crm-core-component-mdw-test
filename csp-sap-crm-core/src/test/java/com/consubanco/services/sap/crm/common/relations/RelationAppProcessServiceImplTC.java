package com.consubanco.services.sap.crm.common.relations;

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
public class RelationAppProcessServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( RelationAppProcessServiceImplTC.class );
	
	/**
	 * 
	 */
	public RelationAppProcessServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public RelationAppProcessServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		RelationAppProcessImpl processImpl = new RelationAppProcessImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		//60073268
		ArrayList<IProxyOutputData> returnList = processImpl.relationApplicationAndProcess("", "9165", "L");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	 
}
