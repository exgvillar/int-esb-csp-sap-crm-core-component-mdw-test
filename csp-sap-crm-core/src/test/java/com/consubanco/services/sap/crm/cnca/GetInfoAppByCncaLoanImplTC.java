package com.consubanco.services.sap.crm.cnca;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.GetInfoAppByCncaLoanModel;
import com.consubanco.services.sap.crm.cnca.model.LoanModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class GetInfoAppByCncaLoanImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetInfoAppByCncaLoanImplTC.class );

	public GetInfoAppByCncaLoanImplTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		GetInfoAppByCncaLoanModel infoAppByCncaLoanModel = new GetInfoAppByCncaLoanModel();
		infoAppByCncaLoanModel.setCustomerBp("0002614431");
		
		List<LoanModel> loans = new ArrayList<LoanModel>();
		LoanModel loanModel = new LoanModel();
		loanModel.setAccountId("0007689358");
		loans.add(loanModel);
		
		/*loanModel = new LoanModel();
		loanModel.setAccountId("002199387273");
		loans.add(loanModel);*/
		
		infoAppByCncaLoanModel.setLoans(loans);
		
		List<IProxyOutputData> returnList = loansCRMImpl.getInfoAppByCncaLoan(infoAppByCncaLoanModel);
		assertNotNull("Respuesta de la operacion getInfoAppByCncaLoan vacia ", returnList);
		log.info( returnList );
	}
}
