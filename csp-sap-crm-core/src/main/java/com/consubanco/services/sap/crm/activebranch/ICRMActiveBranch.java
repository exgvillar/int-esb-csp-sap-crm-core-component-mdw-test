package com.consubanco.services.sap.crm.activebranch;

import java.util.ArrayList;

import com.consubanco.sap.interfaces.activeBranch.exceptions.RFCExecutionException;
import com.consubanco.sap.interfaces.activeBranch.model.GetBranchesStatusReqModel;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ICRMActiveBranch {

	public ArrayList<IProxyOutputData> getBranchesStatus(GetBranchesStatusReqModel request)
			throws RFCExecutionException;
}
