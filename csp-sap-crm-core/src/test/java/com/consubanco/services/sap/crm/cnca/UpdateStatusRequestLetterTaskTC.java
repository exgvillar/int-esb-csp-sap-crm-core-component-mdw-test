package com.consubanco.services.sap.crm.cnca;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.GenericCatalogModel;
import com.consubanco.services.sap.crm.cnca.model.UpdateStatusRequestLetterTaskModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class UpdateStatusRequestLetterTaskTC extends TestCase {
	
	private static Log log = LogFactory.getLog( UpdateStatusRequestLetterTaskTC.class );

	public UpdateStatusRequestLetterTaskTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		UpdateStatusRequestLetterTaskModel updateStatusRequestLetterTaskModel = new UpdateStatusRequestLetterTaskModel();
		updateStatusRequestLetterTaskModel.setTaskId("2400000022");
		
		GenericCatalogModel status = new GenericCatalogModel();
		status.setKey("E0002");
		status.setDescription("");		
		updateStatusRequestLetterTaskModel.setStatus(status);
				
		List<IProxyOutputData> returnList = loansCRMImpl.updateStatusRequestLetterTask(updateStatusRequestLetterTaskModel);
		assertNotNull("Respuesta de la operacion updateCncaTask vacia ", returnList);
		log.info( returnList );
	}
	
}
