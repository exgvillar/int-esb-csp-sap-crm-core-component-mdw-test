package com.consubanco.services.sap.crm.debtBalanceInsurance;


import java.util.ArrayList;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;


public interface DebtBalanceInsuranceService {

	public ArrayList<IProxyOutputData> updateStatusDebtBalanceInsuranceServiceOrder( String serviceOrder, String statusId, String noteId, String observations ) throws Exception;
	
	public ArrayList<IProxyOutputData> getSSDAplications( String statusId ) throws Exception;
	
}
