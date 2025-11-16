package com.consupago.services.sap.crm.imss.sipre;

import com.consupago.services.sap.crm.imss.sipre.vo.ImssSipreInfoVo;

public interface GetImssInfoService {
	public ImssSipreInfoVo getImssSipreInfo(String idAccount, String idSolicitud ) throws Exception;
}
