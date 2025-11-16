package com.consupago.services.sap.crm.cm;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class GetPersonalByBranchHRPImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetPersonalByBranchHRPImplTC.class );
	
	/**
	 * 
	 */
	public GetPersonalByBranchHRPImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetPersonalByBranchHRPImplTC(String name) {
		super(name);
		
	}
	
	public void testCase1( ) throws Exception {
		
		HRPServiceImpl processImpl = new HRPServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<IProxyOutputData> returnList = processImpl.getPersonalByBranch( "CSCSP","112" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

	
}
