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
public class UpdateTermsConditionByCustomerImplTC extends TestCase {

	private static Log log = LogFactory.getLog( UpdateTermsConditionByCustomerImplTC.class );
	
	/**
	 * 
	 */
	public UpdateTermsConditionByCustomerImplTC() {
		
	}

	/**
	 * @param name
	 */
	public UpdateTermsConditionByCustomerImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		ICRMDigitalAppCommonService processImpl = new CRMDigitalAppCommonServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		String customerBp = "0000000142";
		String sourceChannelApp = "BKY";
		boolean termsConditionsAccepted = true;
		
		ArrayList<IProxyOutputData> returnList = processImpl.updateTermsConditionByCustomer(customerBp, sourceChannelApp, termsConditionsAccepted);
		
		assertNotNull( returnList );
		log.info( returnList.toString() );
	}


}
