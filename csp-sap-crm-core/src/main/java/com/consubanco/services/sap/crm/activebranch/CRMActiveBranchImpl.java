package com.consubanco.services.sap.crm.activebranch;

import java.util.ArrayList;

import com.consubanco.sap.interfaces.activeBranch.ZCRMPORTAL_UTIL_P022_VALIDATE_ProxyImpl;
import com.consubanco.sap.interfaces.activeBranch.exceptions.RFCExecutionException;
import com.consubanco.sap.interfaces.activeBranch.model.GetBranchesStatusReqModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

public class CRMActiveBranchImpl implements ICRMActiveBranch{
	
	private JCoDestination destination;
	
	public CRMActiveBranchImpl() throws RFCExecutionException{
		CRMLocalConfigEnvironmentData.instance();
		try {
			destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		} catch (JCoException e) {
			throw new RFCExecutionException("Error during CRM Connection " + e.getMessage());
		}
	}

	public ArrayList<IProxyOutputData> getBranchesStatus(GetBranchesStatusReqModel request)
			throws RFCExecutionException {
		return new ZCRMPORTAL_UTIL_P022_VALIDATE_ProxyImpl().executeRemoteFunction(destination, request);
	}

}
