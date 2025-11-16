package com.consubanco.sap.interfaces.digital.app.common;

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
public class CheckTermConditionsByCustomerImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CheckTermConditionsByCustomerImplTC.class );
	
	/**
	 * 
	 */
	public CheckTermConditionsByCustomerImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CheckTermConditionsByCustomerImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		ICRMDigitalAppCommonService processImpl = new CRMDigitalAppCommonServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		String customerBp = "0000000142";
		String sourceChannelApp = "BKY";
		
		ArrayList<IProxyOutputData> returnList = processImpl.checkTermConditionsByCustomer(customerBp, sourceChannelApp);
		
		assertNotNull( returnList );
		log.info( returnList.toString() );
	}


}
