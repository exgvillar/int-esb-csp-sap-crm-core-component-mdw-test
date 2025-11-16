package com.consubanco.services.sap.crm.ine;

import java.util.ArrayList;

import com.consubanco.sap.interfaces.ine.model.ZMSaveInfoINERequest;
import com.consubanco.sap.interfaces.ine.model.ZMValidINERequest;
import com.consubanco.sap.interfaces.ine.model.ZMGetInfoINERequest;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface IIneServices {

	public ArrayList<IProxyOutputData> saveInfoINE(ZMSaveInfoINERequest request) throws Exception;

	public ArrayList<IProxyOutputData> getInfoINE(ZMGetInfoINERequest request) throws Exception;

	public ArrayList<IProxyOutputData> validInfoINE(ZMValidINERequest request) throws Exception;

}
