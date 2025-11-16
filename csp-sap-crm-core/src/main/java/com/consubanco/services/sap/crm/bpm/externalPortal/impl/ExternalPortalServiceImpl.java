package com.consubanco.services.sap.crm.bpm.externalPortal.impl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.externalPortal.ZCRMORI_E050_GETCONFPORTAL_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.externalPortal.ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.externalPortal.ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl;
import com.consubanco.services.sap.crm.bpm.externalPortal.IExternalPortalService;
import com.consubanco.services.sap.crm.bpm.externalPortal.model.AccountModel;
import com.consubanco.services.sap.crm.bpm.externalPortal.model.SaveResultPortalRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ExternalPortalServiceImpl implements IExternalPortalService {

	private static Log LOG = LogFactory.getLog(ExternalPortalServiceImpl.class);

	
	public ExternalPortalServiceImpl() {
		super();
	}


	public ArrayList<IProxyOutputData> getPortalConfig(String siglaEmpresa, String convenioId, String folioId, String customerBP,
			String employeeNumber) throws Exception {
		LOG.info("Obtener Configuracion de portal  : [ '" + siglaEmpresa + "','" + convenioId +"' ]");

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		ZCRMORI_E050_GETCONFPORTAL_ProxyImpl proxy = new ZCRMORI_E050_GETCONFPORTAL_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = null;
		
		input = new ProxyInputParameter();
		input.setKey("I_SIGLAEMPRESA");
		input.setValue(StringUtils.trimToEmpty(siglaEmpresa));
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_CONVENIOID");
		input.setValue(StringUtils.trimToEmpty(convenioId));
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_SOLICITUD");
		input.setValue(StringUtils.trimToEmpty(folioId));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_NO_EMPLEADO");
		input.setValue(StringUtils.trimToEmpty(employeeNumber));
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue(StringUtils.trimToEmpty(customerBP));
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		return (returnData);
	}


	public ArrayList<IProxyOutputData> saveResultPortal(SaveResultPortalRequest request) throws Exception {
		LOG.info("Guardar Resultado de portal  : [ " + request +" ]");

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl proxy = new ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = null;
		
		input = new ProxyInputParameter();
		input.setKey("I_SOLICITUD");
		input.setValue(StringUtils.trimToEmpty(request.getSolicitud()));
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_PORTALID");
		input.setValue(StringUtils.trimToEmpty(request.getIdPortal()));
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_RESERVA");
		input.setValue(StringUtils.trimToEmpty(request.getReserva()));
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_CONTRATO");
		input.setValue(StringUtils.trimToEmpty(request.getContrato()));
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);
		
		return (returnData);
	}

	public ArrayList<IProxyOutputData> getPortalByAccount(Hashtable<String, AccountModel> accounts)
			throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl proxy = new ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = null;
		
		if( accounts != null ){
			Enumeration<String> e = accounts.keys();
			 while( e.hasMoreElements() ) {
				String accountId = e.nextElement();
				input = new ProxyInputParameter();
				input.setKey("I_ACCOUNTID");
				input.setValue(StringUtils.trimToEmpty(accountId));
				inputParams.add(input);
			}
		}
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);
		
		return (returnData);
	}

}
