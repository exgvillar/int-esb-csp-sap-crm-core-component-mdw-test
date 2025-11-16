package com.consubanco.services.sap.crm.commons;

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
public class GetSubordinatesCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetSubordinatesCommonCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetSubordinatesCommonCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetSubordinatesCommonCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	
	
	public void testAuth( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList<IProxyOutputData> returnList = processImpl.getSubordinates("10003104", "ZSUCOB");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	
	
			 
}
