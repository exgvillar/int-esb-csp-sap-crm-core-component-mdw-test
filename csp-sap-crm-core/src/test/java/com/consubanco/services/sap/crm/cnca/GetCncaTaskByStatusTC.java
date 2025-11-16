package com.consubanco.services.sap.crm.cnca;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.GenericCatalogModel;
import com.consubanco.services.sap.crm.cnca.model.GetCNCATaskByStatusModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class GetCncaTaskByStatusTC extends TestCase {
	
	private static Log log = LogFactory.getLog( GetCncaTaskByStatusTC.class );

	public GetCncaTaskByStatusTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		GetCNCATaskByStatusModel getCncaTaskByStatusModel = new GetCNCATaskByStatusModel();
		List<GenericCatalogModel> status = new ArrayList<GenericCatalogModel>();
		
		GenericCatalogModel statusModel = new GenericCatalogModel();
		/*statusModel.setKey("c0003");
		statusModel.setDescription("PRUEBA1");
		status.add(statusModel);*/
		statusModel = new GenericCatalogModel();
		statusModel.setKey("E0001");
		statusModel.setDescription("PRUEBA2");
		status.add(statusModel);

		getCncaTaskByStatusModel.setStatus(status);
		getCncaTaskByStatusModel.setPromotorBp("0010002446");
		
		List<IProxyOutputData> returnList = loansCRMImpl.getCncaTaskByStatus(getCncaTaskByStatusModel);
		assertNotNull("Respuesta de la operacion GetCncaTaskByStatusTC vacia ", returnList);
		log.info( returnList );
	}

}
