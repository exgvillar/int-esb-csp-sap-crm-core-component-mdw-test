package com.consupago.services.sap.crm.ivr;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author ramon.becerra
 *
 */
public class IVRServiceGetBusinessPartnerImplTC extends TestCase {

	private static Log log = LogFactory.getLog( IVRServiceGetBusinessPartnerImplTC.class );
	
	/**
	 * 
	 */
	public IVRServiceGetBusinessPartnerImplTC() {
		
	}

	/**
	 * @param name
	 */
	public IVRServiceGetBusinessPartnerImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		IVRServiceImpl processImpl = new IVRServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getBusinessPartner(10001530, 2);
		//ArrayList returnList = processImpl.getBussinesPartner(1, 1);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	 
}
