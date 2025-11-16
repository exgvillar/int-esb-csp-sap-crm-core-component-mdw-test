package com.consubanco.services.sap.crm.sfc;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.sfc.impl.SalesForceServiceImpl;
import com.consubanco.services.sap.crm.sfc.model.RegisterApplicationECMReq;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class RegisterApplicationECMTC extends TestCase {
	
	private static Log log = LogFactory.getLog( RegisterApplicationECMTC.class );

	public RegisterApplicationECMTC() {
		super();
	}

	public RegisterApplicationECMTC(String name) {
		super(name);
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ISalesforceService processImpl = new SalesForceServiceImpl();
		
		RegisterApplicationECMReq registerApplicationECM = new RegisterApplicationECMReq();
		registerApplicationECM.setApplicationId("1478963251");
		registerApplicationECM.setApplicationCRM("50000500");
		registerApplicationECM.setApportunitySFC("1245797631");
		registerApplicationECM.setFilenetId("1155988989");
		
		List<IProxyOutputData> returnList = processImpl.registerApplicationECM(registerApplicationECM);
		assertNotNull("Respuesta de la operacion registerApplicationECM vacia ", returnList);
		log.info( returnList );
		
	}

}
