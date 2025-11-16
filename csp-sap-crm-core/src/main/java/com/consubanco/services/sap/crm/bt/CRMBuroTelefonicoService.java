package com.consubanco.services.sap.crm.bt;


import java.util.ArrayList;
import java.util.List;

import com.consubanco.sap.interfaces.bt.model.ZESCRMBT_E002_INCIDENCIAS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;


public interface CRMBuroTelefonicoService {

	public ArrayList<IProxyOutputData> searchPhoneByOwner( String bp, String rfc, String curp, String name1, String name2, String lastName1, String lastName2 ) throws Exception;
	
	/**
	 * Permite salva el dictamen
	 * 
	 * @param idSolicitud
	 * @param bpId
	 * @param dictamenBrms
	 * @return
	 */
	ArrayList<IProxyOutputData> saveDictamenBrmsAndIncidences(String idSolicitud, String bpId, String phone, boolean dictamenBrms, String protocolCalledQuality, String ownerPhoneBp, List<ZESCRMBT_E002_INCIDENCIAS_Model> incidences) throws Exception;
	
}
