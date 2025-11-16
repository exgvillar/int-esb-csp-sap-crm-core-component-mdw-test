/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.spei;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class CRMBPMSpeiServiceImpl_TC extends TestCase {

	private static Log LOG = LogFactory.getLog(CRMBPMSpeiServiceImpl_TC.class);

	public void test() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		CRMBPMSpeiService crmBPMSpeiService = new CRMBPMSpeiServiceImpl();

		ArrayList<IProxyOutputData> speiDevuelto = crmBPMSpeiService
				.speiDevuelto("0005613662", "juribe", "0");

		assertNotNull(speiDevuelto);
		
		LOG.info(speiDevuelto);

	}
}
