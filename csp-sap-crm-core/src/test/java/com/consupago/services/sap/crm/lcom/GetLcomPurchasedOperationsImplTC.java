package com.consupago.services.sap.crm.lcom;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author ramon.becerra
 *
 */
public class GetLcomPurchasedOperationsImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetLcomPurchasedOperationsImplTC.class );
	
	/**
	 * 
	 */
	public GetLcomPurchasedOperationsImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetLcomPurchasedOperationsImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		LCOM_SMS_ServiceImpl processImpl = new LCOM_SMS_ServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<String> categoryList = new ArrayList<String>();
        categoryList.add("LCOM");
        categoryList.add("CONT");
        
		ArrayList returnList = processImpl.getLCOMPurchasedOperations("E0036", categoryList);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

	
}
