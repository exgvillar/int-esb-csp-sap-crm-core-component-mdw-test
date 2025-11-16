/**
 * 
 */
package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

/**
 * @author Ing. Adrian Alejo - Tw @adrixmnt
 *
 */
public class SaveCustFlagCommonCRMServiceImplTC extends TestCase {

	private static Log logger = LogFactory.getLog(SaveCustFlagCommonCRMServiceImplTC.class);

	public void testSaveCustomerFlag() throws Exception {
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();

		CRMLocalConfigEnvironmentData.instance();

		String bpId = "1149";
		String source = "CSB-CTE-APP" ;
		String folioApp = "0050384743";
		String operationTyp = "ZCSP";
				
		ArrayList<IProxyOutputData> saveCustomerFlag = processImpl.saveCustomerFlag(bpId, operationTyp, source, folioApp);
		for (IProxyOutputData iProxyOutputData : saveCustomerFlag) {
			logger.info(iProxyOutputData);
		}
	}
}
