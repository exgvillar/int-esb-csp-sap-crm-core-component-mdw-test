/**
 * 
 */
package com.consubanco.services.sap.crm.spei7x24;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.spei7x24.impl.Spei7x24ServiceImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class Spei7x24Service_TC extends TestCase {

	private static Log LOG = LogFactory.getLog(Spei7x24Service_TC.class);

	private Spei7x24Service spei7x24Service;

	/**
	 * 
	 */
	public Spei7x24Service_TC() {
	}

	/**
	 * @param name
	 */
	public Spei7x24Service_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();
		spei7x24Service = new Spei7x24ServiceImpl();

		String celular = "1111111111";

		long currentTimeMillis = System.currentTimeMillis();

		ArrayList<IProxyOutputData> returnData = spei7x24Service.getInfoByCell(celular);

		long finalCurrentTimeMillis = System.currentTimeMillis();

		LOG.info(returnData.toString());

		System.out.println((finalCurrentTimeMillis - currentTimeMillis) / 1000);

	}

}
