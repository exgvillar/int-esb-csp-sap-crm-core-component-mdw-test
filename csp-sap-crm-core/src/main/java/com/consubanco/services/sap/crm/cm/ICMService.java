package com.consubanco.services.sap.crm.cm;


import java.util.ArrayList;

import com.consubanco.services.sap.crm.cm.models.ApplicationModel;
import com.consubanco.services.sap.crm.cm.models.BranchModel;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;


public interface ICMService {

	public ArrayList<IProxyOutputData> saveAmountByApplication( ApplicationModel applicationInput ) throws Exception;
	
	public ArrayList<IProxyOutputData> getInfoByAppAndBranch( String folioApplication, BranchModel branchInput ) throws Exception;
	
	}
