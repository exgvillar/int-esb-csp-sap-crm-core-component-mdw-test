/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.externalPortal;

import java.util.ArrayList;
import java.util.Hashtable;

import com.consubanco.services.sap.crm.bpm.externalPortal.model.AccountModel;
import com.consubanco.services.sap.crm.bpm.externalPortal.model.SaveResultPortalRequest;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public interface IExternalPortalService {

	/**
	 * 
	 * @param siglaEmpresa
	 * @param convenioId
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> getPortalConfig(String siglaEmpresa,
			String convenioId, String folioId, String customerBP,
			String employeeNumber) throws Exception;

	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> saveResultPortal(SaveResultPortalRequest request) throws Exception;
	
	/**
	 * 
	 * @param accountID
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> getPortalByAccount(Hashtable<String, AccountModel> accounts) throws Exception;

}
