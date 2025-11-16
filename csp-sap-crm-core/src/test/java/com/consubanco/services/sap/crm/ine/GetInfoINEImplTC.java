package com.consubanco.services.sap.crm.ine;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.ine.ZCRMBIO_E007_GETINFOINE_OutputData;
import com.consubanco.sap.interfaces.ine.model.ZMGetInfoINERequest;
import com.consubanco.services.sap.crm.ine.impl.IIneServicesImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class GetInfoINEImplTC extends TestCase {
	private static Log log = LogFactory.getLog(GetInfoINEImplTC.class);

	public void test() throws Exception {

		IIneServices processImpl = new IIneServicesImpl();
		CRMLocalConfigEnvironmentData.instance();

		ZMGetInfoINERequest request = new ZMGetInfoINERequest();
		request.setCustomerBp("0000001192");

		ArrayList<IProxyOutputData> response = processImpl.getInfoINE(request);
		ZCRMBIO_E007_GETINFOINE_OutputData outputData = (ZCRMBIO_E007_GETINFOINE_OutputData) response.get(0);
		log.info(outputData.toString());

	}
}
