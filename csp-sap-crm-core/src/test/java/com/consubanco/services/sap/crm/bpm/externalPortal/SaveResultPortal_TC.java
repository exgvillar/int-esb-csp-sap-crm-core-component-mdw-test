/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.externalPortal;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.bpm.externalPortal.impl.ExternalPortalServiceImpl;
import com.consubanco.services.sap.crm.bpm.externalPortal.model.SaveResultPortalRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author consubanco
 *
 */
public class SaveResultPortal_TC extends TestCase {

	private static Log LOG = LogFactory.getLog(SaveResultPortal_TC.class);

	private IExternalPortalService externalPortalSrv;

	/**
	 * 
	 */
	public SaveResultPortal_TC() {
	}

	/**
	 * @param name
	 */
	public SaveResultPortal_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();
		externalPortalSrv = new ExternalPortalServiceImpl();

		long currentTimeMillis = System.currentTimeMillis();

		SaveResultPortalRequest request = new SaveResultPortalRequest();
		request.setSolicitud("50386852");
		request.setIdPortal("1");
		request.setReserva("1823729");
		request.setContrato("94187191");
		
		ArrayList<IProxyOutputData> returnData = externalPortalSrv.saveResultPortal(request );

		long finalCurrentTimeMillis = System.currentTimeMillis();

		LOG.info(returnData.toString());

		System.out.println((finalCurrentTimeMillis - currentTimeMillis) / 1000);

	}
}
