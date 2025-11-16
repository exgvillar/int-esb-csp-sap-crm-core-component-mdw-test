package com.consubanco.services.sap.crm.commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

import junit.framework.TestCase;

public class GetF02DataCommonCRMServiceImplTC extends TestCase {
	private static Log log = LogFactory.getLog(GetF02DataCommonCRMServiceImplTC.class);

	public void testGetF02DataSuccess() throws Exception {

		CommonCRMService processImpl = new CommonCRMServiceImpl();

		CRMLocalConfigEnvironmentData.instance();

		//DEV customerBp: 2606635, folioApplication: 70000280
		//QA customerBp: 94772, folioApplication: 50244288
		//QA customerBp: 4010128, folioApplication: 50547446

		ZTL_PEPS_Model model = processImpl.getF02Data("2606635", "70000280");

		log.info("Test - Response :: " + model.toString());

	}

}
