/**
 * 
 */
package com.consubanco.services.sap.crm.spei7x24.impl;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.spei7x24.ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl;
import com.consubanco.services.sap.crm.spei7x24.Spei7x24Service;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class Spei7x24ServiceImpl implements Spei7x24Service {

	private static Log LOG = LogFactory.getLog(Spei7x24ServiceImpl.class);

	/**
	 * 
	 */
	public Spei7x24ServiceImpl() {

	}

	public ArrayList<IProxyOutputData> getInfoByCell(String cellphone) throws Exception {

		LOG.info("Obtener Información por Celular : [ " + cellphone + " ]");

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl proxy = new ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_NUMTEL");

		input.setValue(cellphone);
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);

	}

}
