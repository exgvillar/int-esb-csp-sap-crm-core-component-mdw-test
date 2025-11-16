package com.consupago.services.sap.crm.imss;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface IStarterIMSSPensionadosService {

	public ArrayList<IProxyOutputData> startBPMProcess( String status, String saveFlag ) throws Exception;
}
