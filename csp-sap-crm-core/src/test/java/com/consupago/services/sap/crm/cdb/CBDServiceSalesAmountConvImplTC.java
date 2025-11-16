package com.consupago.services.sap.crm.cdb;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author ramon.becerra
 *
 */
public class CBDServiceSalesAmountConvImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CBDServiceSalesAmountConvImplTC.class );
	
	/**
	 * 
	 */
	public CBDServiceSalesAmountConvImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CBDServiceSalesAmountConvImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		CDBServiceImpl processImpl = new CDBServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getSalesAmountConvenio( "10000027" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	 
}
