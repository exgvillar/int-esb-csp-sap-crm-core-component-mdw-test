package com.consubanco.services.sap.crm.cnca;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.GetRequestsCncaModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class GetRequestsCncaTC extends TestCase {
	
	private static Log log = LogFactory.getLog( GetRequestsCncaTC.class );

	public GetRequestsCncaTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		GetRequestsCncaModel getRequestsCncaModel = new GetRequestsCncaModel();
		getRequestsCncaModel.setInitialDate(formato.parse("2024-02-01"));
		getRequestsCncaModel.setFinalDate(formato.parse("2024-08-27"));
		
		List<IProxyOutputData> returnList = loansCRMImpl.getRequestsCnca(getRequestsCncaModel);
		assertNotNull("Respuesta de la operacion getCncaTask vacia ", returnList);
		log.info( returnList );
	}

}
