package com.consubanco.services.sap.crm.ine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.consubanco.sap.interfaces.ine.ZCRMBIO_E006_VALIDATEINE_OutputData;
import com.consubanco.sap.interfaces.ine.ZCRMBIO_P016_SAVEINFOINE_OutputData;
import com.consubanco.sap.interfaces.ine.model.ZMFile;
import com.consubanco.sap.interfaces.ine.model.ZMInfoINE;
import com.consubanco.sap.interfaces.ine.model.ZMSaveInfoINERequest;
import com.consubanco.sap.interfaces.ine.model.ZMValidINERequest;
import com.consubanco.services.sap.crm.ine.impl.IIneServicesImpl;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoException;

import junit.framework.TestCase;

public class SaveInfoIneImplTC extends TestCase{

	public void testSaveINE() {
		try {
			IIneServices service = new IIneServicesImpl();
			
			ZMSaveInfoINERequest request = new ZMSaveInfoINERequest();
			request.setCustomerBp("1149");
			
			ZMInfoINE infoINE = new ZMInfoINE();
			infoINE.setVoterId("3453JD534535KAKA3242");
			infoINE.setStateId("DF");
			infoINE.setRegistrationYear("2009");
			infoINE.setIssueNumber("02");
			infoINE.setIssueYear("2009");
			infoINE.setValidityYear("2029");
			infoINE.setCic("25345345343");
			infoINE.setOcr("345345432");
			infoINE.setMechanicalReading("PRUEBA");
			infoINE.setPortalCode("PDI");
			infoINE.setCity("CDMX");
			infoINE.setCurp("ADAS0890E809EDD11");
			
			ZMFile file = new ZMFile();
			file.setName("INE_AMBERSO");//Enviar INE_AMBERSO o INE_REVERSO
			file.setBase64("SG9sYSwgc2F2ZWluZm9JbmU=");
			
			List<ZMFile> files = new LinkedList<ZMFile>();
			files.add(file);
			infoINE.setFiles(files);
			request.setInfoINE(infoINE);
			
			
			ArrayList<IProxyOutputData> response = service.saveInfoINE(request);
			 ZCRMBIO_P016_SAVEINFOINE_OutputData output = (ZCRMBIO_P016_SAVEINFOINE_OutputData)response.get(0);
			 
			 assertTrue("testSaveINE", output.isSuccess());
		} catch (JCoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
