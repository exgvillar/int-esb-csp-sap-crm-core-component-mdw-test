/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.externalPortal;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.bpm.externalPortal.impl.ExternalPortalServiceImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author consubanco
 *
 */
public class GetPortalConfig_TC extends TestCase {

	private static Log LOG = LogFactory.getLog(GetPortalConfig_TC.class);

	private IExternalPortalService externalPortalSrv;

	/**
	 * 
	 */
	public GetPortalConfig_TC() {
	}

	/**
	 * @param name
	 */
	public GetPortalConfig_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();
		externalPortalSrv = new ExternalPortalServiceImpl();

		long currentTimeMillis = System.currentTimeMillis();

		String siglaEmpresa = "271";
		String convenioId = "10000041";
		String folioId = "12345";
		String customerBP = "";
		String employeeNumber = "";

		ArrayList<IProxyOutputData> returnData = externalPortalSrv.getPortalConfig(siglaEmpresa, convenioId, folioId, customerBP, employeeNumber);

		long finalCurrentTimeMillis = System.currentTimeMillis();

		LOG.info(returnData.toString());

		System.out.println((finalCurrentTimeMillis - currentTimeMillis) / 1000);

	}
}
