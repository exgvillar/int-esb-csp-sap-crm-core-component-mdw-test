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
public class GetEmployeesCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetEmployeesCommonCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetEmployeesCommonCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetEmployeesCommonCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	
	
	public void testAuth( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList<IProxyOutputData> returnList = processImpl.getEmployeesByBp("142");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	
	
			 
}
