package com.consubanco.services.sap.crm.cnca;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.GenericCatalogModel;
import com.consubanco.services.sap.crm.cnca.model.UpdateCncaTaskModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class UpdateCncaTaskTC extends TestCase {
	
	private static Log log = LogFactory.getLog( UpdateCncaTaskTC.class );

	public UpdateCncaTaskTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		UpdateCncaTaskModel updateCncaTaskModel = new UpdateCncaTaskModel();
		updateCncaTaskModel.setTaskId("2400000022");
		
		GenericCatalogModel status = new GenericCatalogModel();
		status.setKey("E0002");
		status.setDescription("");		
		updateCncaTaskModel.setStatus(status);
		
		updateCncaTaskModel.setComments("NOTA DE TEXTO 1");
				
		List<IProxyOutputData> returnList = loansCRMImpl.updateCncaTask(updateCncaTaskModel);
		assertNotNull("Respuesta de la operacion updateCncaTask vacia ", returnList);
		log.info( returnList );
	}
	
}
