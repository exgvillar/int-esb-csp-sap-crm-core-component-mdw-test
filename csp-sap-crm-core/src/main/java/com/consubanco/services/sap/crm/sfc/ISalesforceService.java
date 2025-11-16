package com.consubanco.services.sap.crm.sfc;

import java.util.List;

import com.consubanco.services.sap.crm.sfc.model.RegisterApplicationECMReq;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ISalesforceService {

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> registerApplicationECM(RegisterApplicationECMReq request) throws Exception;
}
