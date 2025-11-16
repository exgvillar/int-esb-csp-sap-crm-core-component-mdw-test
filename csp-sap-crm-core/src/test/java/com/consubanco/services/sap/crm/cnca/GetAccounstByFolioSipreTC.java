package com.consubanco.services.sap.crm.cnca;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.GetAccounstByFolioSipreModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class GetAccounstByFolioSipreTC extends TestCase {
	
	private static Log log = LogFactory.getLog( GetAccounstByFolioSipreTC.class );

	public GetAccounstByFolioSipreTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		GetAccounstByFolioSipreModel getAccounstByFolioSipreModel = new GetAccounstByFolioSipreModel();
		getAccounstByFolioSipreModel.setFolioReleaseLetter("FOL123456789");
		getAccounstByFolioSipreModel.setFindFiles(false);
		
		List<IProxyOutputData> returnList = loansCRMImpl.getAccounstByFolioSipre(getAccounstByFolioSipreModel);
		assertNotNull("Respuesta de la operacion getAccounstByFolioSipreTC vacia ", returnList);
		log.info( returnList );
	}

}
