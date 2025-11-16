package com.consubanco.services.sap.crm.ine.impl;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.ine.ZCRMBIO_E006_VALIDATEINE_ProxyImpl;
import com.consubanco.sap.interfaces.ine.ZCRMBIO_E007_GETINFOINE_ProxyImpl;
import com.consubanco.sap.interfaces.ine.ZCRMBIO_P016_SAVEINFOINE_ProxyImpl;
import com.consubanco.sap.interfaces.ine.model.ZMGetInfoINERequest;
import com.consubanco.sap.interfaces.ine.model.ZMSaveInfoINERequest;
import com.consubanco.sap.interfaces.ine.model.ZMValidINERequest;
import com.consubanco.services.sap.crm.ine.IIneServices;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

public class IIneServicesImpl implements IIneServices {
	private static Log log = LogFactory.getLog(IIneServicesImpl.class);

	private JCoDestination destination;

	public IIneServicesImpl() throws JCoException {
		CRMLocalConfigEnvironmentData.instance();
		destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	}

	public ArrayList<IProxyOutputData> saveInfoINE(ZMSaveInfoINERequest request) throws Exception {
		return new ZCRMBIO_P016_SAVEINFOINE_ProxyImpl().executeRemoteFunction(destination, request);
	}

	public ArrayList<IProxyOutputData> getInfoINE(ZMGetInfoINERequest request) throws Exception {
		log.info("getInfoINE input: [" + request.toString() + "]");

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMBIO_E007_GETINFOINE_ProxyImpl proxy = new ZCRMBIO_E007_GETINFOINE_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_CUSTOMERBP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(request.getCustomerBp()), 10));
		inputParams.add(input);

		return proxy.executeRemoteFunction(destination, inputParams);
	}

	public ArrayList<IProxyOutputData> validInfoINE(ZMValidINERequest request) throws Exception {
		log.info("validInfoINE input: [" + request.toString() + "]");

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMBIO_E006_VALIDATEINE_ProxyImpl proxy = new ZCRMBIO_E006_VALIDATEINE_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_CUSTOMERBP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(request.getCustomerBp()), 10));
		inputParams.add(input);

		return proxy.executeRemoteFunction(destination, inputParams);
	}

}
