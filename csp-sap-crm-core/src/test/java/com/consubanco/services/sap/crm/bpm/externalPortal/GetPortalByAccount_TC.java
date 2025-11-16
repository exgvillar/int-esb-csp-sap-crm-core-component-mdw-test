/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.externalPortal;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.bpm.externalPortal.impl.ExternalPortalServiceImpl;
import com.consubanco.services.sap.crm.bpm.externalPortal.model.AccountModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author consubanco
 *
 */
public class GetPortalByAccount_TC extends TestCase {

	private static Log LOG = LogFactory.getLog(GetPortalByAccount_TC.class);

	private IExternalPortalService externalPortalSrv;

	/**
	 * 
	 */
	public GetPortalByAccount_TC() {
	}

	/**
	 * @param name
	 */
	public GetPortalByAccount_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();
		externalPortalSrv = new ExternalPortalServiceImpl();

		long currentTimeMillis = System.currentTimeMillis();

		Hashtable<String, AccountModel> accounts = new Hashtable<String, AccountModel>();
		AccountModel account = new AccountModel();
		account.setAccountId("34567890");
		account.setDiscountAmount(500.0);
		accounts.put( account.getAccountId(), account );
		
		account = new AccountModel();
		account.setAccountId("123918739812");
		account.setDiscountAmount(500.0);
		accounts.put( account.getAccountId(), account );
		
		ArrayList<IProxyOutputData> returnData = externalPortalSrv.getPortalByAccount( accounts );

		long finalCurrentTimeMillis = System.currentTimeMillis();

		LOG.info(returnData.toString());

		System.out.println((finalCurrentTimeMillis - currentTimeMillis) / 1000);

	}
}
