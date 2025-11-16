/**
 * 
 */
package com.consupago.services.sap.crm.ivr;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author juribe
 * 
 */
public class IVRServiceGetInfoCRMTicketsImplTC extends TestCase {

	private static Log log = LogFactory
			.getLog(IVRServiceGetInfoCRMTicketsImplTC.class);

	/**
	 * 
	 */
	public IVRServiceGetInfoCRMTicketsImplTC() {
		super();
	}

	/**
	 * @param name
	 */
	public IVRServiceGetInfoCRMTicketsImplTC(String name) {
		super(name);
	}

	public void testDeberiaObtenerInfoTicket() throws Exception {

		IVRServiceImpl processImpl = new IVRServiceImpl();

		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getInfoCRMTickets("125");
		
		log.info(returnList);

		assertNotNull(returnList);
	}

}
