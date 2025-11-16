/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.spei;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public interface CRMBPMSpeiService {

	/**
	 * 
	 * @param folioAppId
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> speiDevuelto(String folioAppId, String username, String bpId) throws Exception;
}
