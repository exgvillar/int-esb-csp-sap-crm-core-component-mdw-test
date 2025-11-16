package com.consubanco.services.sap.crm.commons;

import java.util.List;

import com.consubanco.services.sap.crm.commons.sipre.ChangeStatusSipreRequest;
import com.consubanco.services.sap.crm.commons.sipre.GetInfoGeneralSipreRequest;
import com.consubanco.services.sap.crm.commons.sipre.SipreDataTaskRequest;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface CommonCRMSipreService {

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<IProxyOutputData> changeStatusSipre(ChangeStatusSipreRequest request) throws Exception;
	
	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<IProxyOutputData> createSipreDataTask(SipreDataTaskRequest request) throws Exception;

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<IProxyOutputData> getInfoGeneralSipre(GetInfoGeneralSipreRequest request) throws Exception;
	
}
