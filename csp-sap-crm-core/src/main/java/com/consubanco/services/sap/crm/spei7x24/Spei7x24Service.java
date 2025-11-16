/**
 * 
 */
package com.consubanco.services.sap.crm.spei7x24;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public interface Spei7x24Service {

	/**
	 * Se obtiene la información desde CRM a partir del # de teléfono
	 * 
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> getInfoByCell(String cellphone) throws Exception;
}
