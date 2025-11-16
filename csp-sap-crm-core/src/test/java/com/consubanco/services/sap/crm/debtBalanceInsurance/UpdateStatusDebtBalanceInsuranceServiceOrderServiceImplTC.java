package com.consubanco.services.sap.crm.debtBalanceInsurance;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class UpdateStatusDebtBalanceInsuranceServiceOrderServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( UpdateStatusDebtBalanceInsuranceServiceOrderServiceImplTC.class );
	
	/**
	 * 
	 */
	public UpdateStatusDebtBalanceInsuranceServiceOrderServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public UpdateStatusDebtBalanceInsuranceServiceOrderServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		DebtBalanceInsuranceService processImpl = new DebtBalanceInsuranceServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<IProxyOutputData> returnList = processImpl.updateStatusDebtBalanceInsuranceServiceOrder("1710000002", "E0002", "ZC03", "Ejemplo 2");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
