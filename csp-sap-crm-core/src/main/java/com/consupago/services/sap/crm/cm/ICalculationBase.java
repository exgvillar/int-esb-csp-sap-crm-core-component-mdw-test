package com.consupago.services.sap.crm.cm;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ICalculationBase {

	public ArrayList<IProxyOutputData> getCalculationBase( String distributorSigla, String sucursalSigla, String idEmpleado ) throws Exception;
}
