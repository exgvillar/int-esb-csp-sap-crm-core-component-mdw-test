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
public class GetDistributorsHRPImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetDistributorsHRPImplTC.class );
	
	/**
	 * 
	 */
	public GetDistributorsHRPImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetDistributorsHRPImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		HRPServiceImpl processImpl = new HRPServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<IProxyOutputData> returnList = processImpl.getDistributors( );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

	
}
