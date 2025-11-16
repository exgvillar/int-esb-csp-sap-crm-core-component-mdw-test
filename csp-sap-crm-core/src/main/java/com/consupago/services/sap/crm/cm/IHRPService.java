package com.consupago.services.sap.crm.cm;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface IHRPService {

	public ArrayList<IProxyOutputData> getDistributors( ) throws Exception;
	
	public ArrayList<IProxyOutputData> getBranchesByDistributor( String distributorSigla ) throws Exception;
	
	public ArrayList<IProxyOutputData> getPersonalByBranch( String distributorSigla, String branchSigla ) throws Exception;
}
