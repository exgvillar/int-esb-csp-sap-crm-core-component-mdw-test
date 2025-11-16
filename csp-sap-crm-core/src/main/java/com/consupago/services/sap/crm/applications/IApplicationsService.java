package com.consupago.services.sap.crm.applications;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.applications.model.ZTL_SOLICITUD_Model;
import com.consupago.sap.interfaces.proxy.applications.model.ZTT_ESTATUS_Model;



public interface IApplicationsService {

	public boolean saveEmployeeTypeByApplication( String request, String employeeType ) throws Exception;
	
	public ArrayList<IProxyOutputData> getProductConvenioByApp( ArrayList<ZTL_SOLICITUD_Model> applications ) throws Exception;
	
	/**
	 * 
	 * @param statusList Lista de Estatus de las aplicaciones
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> getApplicationByStatus( ArrayList<ZTT_ESTATUS_Model> statusList ) throws Exception;
}
