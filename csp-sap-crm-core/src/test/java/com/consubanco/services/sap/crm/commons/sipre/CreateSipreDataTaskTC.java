package com.consubanco.services.sap.crm.commons.sipre;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.commons.CommonCRMSipreService;
import com.consubanco.services.sap.crm.commons.CommonCRMSipreServiceImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class CreateSipreDataTaskTC extends TestCase {
	
	private static Log log = LogFactory.getLog(CreateSipreDataTaskTC.class);

	/**
	 * 
	 */
	public CreateSipreDataTaskTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		CommonCRMSipreService processImpl = new CommonCRMSipreServiceImpl();
		
		List<DocumentRequest> documents = new ArrayList<DocumentRequest>();
		
		SipreDataTaskRequest request = new SipreDataTaskRequest();
		request.setTaskId("");
		request.setPromotorBp("10001934");
		request.setCustomerBp("1198");
		request.setDescription("TAREA SIPRE");
		request.setFolioBiometric("6715524331587");
		request.setBranchId("50000416");
		request.setNss("4589632584");
		request.setMail("MATUJIUI@GMAIL.COM");
		request.setTelephone("7896521485");
		request.setChannel("ESCB");
		
		DocumentRequest document = new DocumentRequest();
		document.setFilename("TEST.XLS");
		document.setBase64("70702E786D6C504B01022D001400060008000000210");
		documents.add(document);
		request.setDocuments(documents);
		
		List<IProxyOutputData> returnList = processImpl.createSipreDataTask(request);
		assertNotNull("Respuesta de la operacion createSipreDataTask vacia ", returnList);
		log.info( returnList );
	}

}
