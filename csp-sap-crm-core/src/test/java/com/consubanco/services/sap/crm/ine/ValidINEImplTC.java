package com.consubanco.services.sap.crm.ine;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.ine.ZCRMBIO_E006_VALIDATEINE_OutputData;
import com.consubanco.sap.interfaces.ine.model.ZMValidINERequest;
import com.consubanco.services.sap.crm.ine.impl.IIneServicesImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class ValidINEImplTC extends TestCase {
	private static Log log = LogFactory.getLog(ValidINEImplTC.class);

	public void test() throws Exception {

		IIneServices processImpl = new IIneServicesImpl();
		CRMLocalConfigEnvironmentData.instance();

		ZMValidINERequest request = new ZMValidINERequest();
		request.setCustomerBp("0000001144");
		// El INE no es valido porque no tiene una tarea biometricos relacionada
		ArrayList<IProxyOutputData> response = processImpl.validInfoINE(request);
		ZCRMBIO_E006_VALIDATEINE_OutputData outputData = (ZCRMBIO_E006_VALIDATEINE_OutputData) response.get(0);
		log.info(outputData.toString());

	}
}
