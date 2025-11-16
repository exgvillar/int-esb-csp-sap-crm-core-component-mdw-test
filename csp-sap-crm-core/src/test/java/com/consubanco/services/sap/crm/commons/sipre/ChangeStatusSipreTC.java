package com.consubanco.services.sap.crm.commons.sipre;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.commons.CommonCRMSipreService;
import com.consubanco.services.sap.crm.commons.CommonCRMSipreServiceImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class ChangeStatusSipreTC extends TestCase {
	
	private static Log log = LogFactory.getLog( ChangeStatusSipreTC.class );

	public ChangeStatusSipreTC() {
		super();
	}

	public ChangeStatusSipreTC(String name) {
		super(name);
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		CommonCRMSipreService processImpl = new CommonCRMSipreServiceImpl();
		
		ChangeStatusSipreRequest changeStatusSipreRequest = new ChangeStatusSipreRequest();
		changeStatusSipreRequest.setTaskId("1890000071");
		changeStatusSipreRequest.setStatusId("E0002");
		changeStatusSipreRequest.setMessage("PRUEBA NOTA");
		
		List<IProxyOutputData> returnList = processImpl.changeStatusSipre(changeStatusSipreRequest);
		assertNotNull("Respuesta de la operacion registerApplicationECM vacia ", returnList);
		log.info( returnList );
	}

}
