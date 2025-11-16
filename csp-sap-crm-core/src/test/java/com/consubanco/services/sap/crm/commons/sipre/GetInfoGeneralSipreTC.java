package com.consubanco.services.sap.crm.commons.sipre;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.commons.CommonCRMSipreService;
import com.consubanco.services.sap.crm.commons.CommonCRMSipreServiceImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class GetInfoGeneralSipreTC extends TestCase {
	
	private static Log log = LogFactory.getLog( GetInfoGeneralSipreTC.class );

	public GetInfoGeneralSipreTC() {
		super();
	}

	public GetInfoGeneralSipreTC(String name) {
		super(name);
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		CommonCRMSipreService processImpl = new CommonCRMSipreServiceImpl();
		
		GetInfoGeneralSipreRequest request = new GetInfoGeneralSipreRequest();
		request.setTaskId("1890000051");
		request.setCustomerBP("");
		request.setCurp("");
		
		List<IProxyOutputData> returnList = processImpl.getInfoGeneralSipre(request);
		assertNotNull("Respuesta de la operacion getInfoGeneralSipre vacia ", returnList);
		log.info( returnList );
	}

}
