package com.consupago.services.sap.crm.imss.sipre;

import com.consupago.services.sap.crm.imss.sipre.vo.ProductoInfoVo;

public interface GetProductoInfoService {
	public ProductoInfoVo getProductoInfo(String idProducto ) throws Exception;
}
