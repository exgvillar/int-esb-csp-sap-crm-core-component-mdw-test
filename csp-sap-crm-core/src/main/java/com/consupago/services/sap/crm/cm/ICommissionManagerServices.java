package com.consupago.services.sap.crm.cm;

import java.sql.Date;
import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ICommissionManagerServices {

	public ArrayList<IProxyOutputData> getTotalPerBranch( String branch, Date fechaInicio, Date fechaFin ) throws Exception;
	
	public ArrayList<IProxyOutputData> getBusinessPartnerSalesTotals( String bpId, String puesto, Date fechaInicio, Date fechaFin ) throws Exception;
	
	public ArrayList<IProxyOutputData> getEmpleadoMultinivel( String idEmpleado, String puesto, Date fechaInicio, Date fechaFin ) throws Exception;
	
	public ArrayList<IProxyOutputData> getNumberPersonsInSamePosition( String idEmpleado, String puesto, ArrayList<String> sucursalesList ) throws Exception;
}
