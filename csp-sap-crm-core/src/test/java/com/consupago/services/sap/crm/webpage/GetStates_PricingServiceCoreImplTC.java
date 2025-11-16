/**
 * 
 */
package com.consupago.services.sap.crm.webpage;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.services.sap.crm.convenios.ConveniosLegalDatesImplTC;

/**
 * @author ramon.becerra
 *
 */
public class GetStates_PricingServiceCoreImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ConveniosLegalDatesImplTC.class );
	
	/**
	 * 
	 */
	public GetStates_PricingServiceCoreImplTC() {

	}

	/**
	 * @param name
	 */
	public GetStates_PricingServiceCoreImplTC(String name) {
		super(name);
	}

	public void testServiceImpl( ) throws Exception {
		PricingServiceCoreImpl serviceImpl = new PricingServiceCoreImpl();
		
		log.info( serviceImpl.getStates().toString() );
	}
}
