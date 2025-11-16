package com.consubanco.services.sap.crm.cnca;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.RequestLetterSipreResultsModel;
import com.consubanco.services.sap.crm.cnca.model.FileModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class RequestLetterSipreResultsTC extends TestCase {

	private static Log log = LogFactory.getLog( RequestLetterSipreResultsTC.class );

	public RequestLetterSipreResultsTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();	
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		RequestLetterSipreResultsModel requestLetterSipreResultsModel = new RequestLetterSipreResultsModel();
		requestLetterSipreResultsModel.setTaskId("2400000008");
		requestLetterSipreResultsModel.setAccountId("000324939393");
		
		/*GenericCatalogModel statusSipre = new GenericCatalogModel();
		statusSipre.setKey("");
		statusSipre.setDescription("");		
		requestLetterSipreResultsModel.setStatusSipre(statusSipre);*/
		
		List<FileModel> fileEvidences = new ArrayList<FileModel>();
		FileModel fileModel = new FileModel();
		fileModel.setFileName("PRUEBA.TXT");
		fileModel.setBase64("B0");
		fileEvidences.add(fileModel);
		requestLetterSipreResultsModel.setFileEvidences(fileEvidences);
		
		List<IProxyOutputData> returnList = loansCRMImpl.requestLetterSipreResults(requestLetterSipreResultsModel);
		assertNotNull("Respuesta de la operacion getInfoAppByCncaLoan vacia ", returnList);
		log.info( returnList );
	}
}
