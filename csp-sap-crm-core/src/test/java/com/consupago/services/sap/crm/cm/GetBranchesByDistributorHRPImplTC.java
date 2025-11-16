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
public class GetBranchesByDistributorHRPImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetBranchesByDistributorHRPImplTC.class );
	
	/**
	 * 
	 */
	public GetBranchesByDistributorHRPImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetBranchesByDistributorHRPImplTC(String name) {
		super(name);
		
	}
	
	public void testCase1( ) throws Exception {
		
		HRPServiceImpl processImpl = new HRPServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<IProxyOutputData> returnList = processImpl.getBranchesByDistributor( "CSCSP" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

	
}
