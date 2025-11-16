package com.consubanco.services.sap.crm.cnca;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.GetCncaTaskModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class GetCncaTaskTC extends TestCase {
	
	private static Log log = LogFactory.getLog( GetCncaTaskTC.class );

	public GetCncaTaskTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		GetCncaTaskModel getCncaTaskModel = new GetCncaTaskModel();
		getCncaTaskModel.setTaskId("2400000025");
		getCncaTaskModel.setFindFiles(false);
		
		List<IProxyOutputData> returnList = loansCRMImpl.getCncaTask(getCncaTaskModel);
		assertNotNull("Respuesta de la operacion getCncaTask vacia ", returnList);
		log.info( returnList );
	}

}
