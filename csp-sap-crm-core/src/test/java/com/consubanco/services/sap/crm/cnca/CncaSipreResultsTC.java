package com.consubanco.services.sap.crm.cnca;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.CncaSipreResultsModel;
import com.consubanco.services.sap.crm.cnca.model.FileModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class CncaSipreResultsTC extends TestCase {

	private static Log log = LogFactory.getLog( CncaSipreResultsTC.class );

	public CncaSipreResultsTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		CncaSipreResultsModel cncaSipreResultsModel = new CncaSipreResultsModel();
		cncaSipreResultsModel.setTaskId("2400000008");
		cncaSipreResultsModel.setAccountId("000324939393");
		
		/*GenericCatalogModel statusSipre = new GenericCatalogModel();
		statusSipre.setKey("");
		statusSipre.setDescription("");		
		cncaSipreResultsModel.setStatusSipre(statusSipre);*/
		
		List<FileModel> fileEvidences = new ArrayList<FileModel>();
		FileModel fileModel = new FileModel();
		fileModel.setFileName("PRUEBA.TXT");
		fileModel.setBase64("B0");
		fileEvidences.add(fileModel);
		cncaSipreResultsModel.setFileEvidences(fileEvidences);
		
		List<IProxyOutputData> returnList = loansCRMImpl.cncaSipreResults(cncaSipreResultsModel);
		assertNotNull("Respuesta de la operacion getInfoAppByCncaLoan vacia ", returnList);
		log.info( returnList );
	}
}
