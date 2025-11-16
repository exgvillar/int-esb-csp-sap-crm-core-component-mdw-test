package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.terminados.ZCRMCRT_P001_SAVE_CONYUGE_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class SaveMaritalStatusByBpServiceImplTC extends TestCase {
	private static Log log = LogFactory.getLog(SaveMaritalStatusByBpServiceImplTC.class);

	public void testSave() throws Exception {

		CommonCRMService processImpl = new CommonCRMServiceImpl();

		CRMLocalConfigEnvironmentData.instance();
		ZCRMCRT_P001_SAVE_CONYUGE_Model req = new ZCRMCRT_P001_SAVE_CONYUGE_Model();
		
		req.setCustomerId("0000045434");
		req.setFirstName("JULIA");
		req.setMiddleName("ANA");
		req.setPaternalLastName("TORRES");
		req.setMaternalLastName("MESA");
		
		ArrayList returnList = processImpl.saveMaritalStatusByBp(req);

		log.info(returnList);

		assertNotNull(returnList);
	}

}
