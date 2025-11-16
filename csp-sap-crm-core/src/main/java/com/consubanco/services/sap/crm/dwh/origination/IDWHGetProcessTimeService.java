package com.consubanco.services.sap.crm.dwh.origination;

import java.util.ArrayList;

import com.consubanco.sap.interfaces.dwh.origination.ZRFC_GEN_GET_DATSOL_InputData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface IDWHGetProcessTimeService {

	public ArrayList<IProxyOutputData> getOriginationProcessTimeList( ArrayList<ZRFC_GEN_GET_DATSOL_InputData> inputParams ) throws Exception;
}
