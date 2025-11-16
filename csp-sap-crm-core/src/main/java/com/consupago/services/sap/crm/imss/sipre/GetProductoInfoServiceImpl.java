/**
 * 
 */
package com.consupago.services.sap.crm.imss.sipre;

import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.imss.pensionados.ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl;
import com.consupago.services.sap.crm.imss.sipre.vo.ProductoInfoVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class GetProductoInfoServiceImpl implements GetProductoInfoService {

	/**
	 * 
	 */
	public GetProductoInfoServiceImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.imss.IStarterIMSSPensionadosService#startBPMProcess(java.lang.String, java.lang.String)
	 */
	public ProductoInfoVo getProductoInfo(String idProducto ) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl proxy = new ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl();
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );

        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("PRODUCT_ID");
        inputRecord.setValue( idProducto ); // justificar ceros a la izq
        recordParams1.add( inputRecord );
        inputParams.getRecordParam().add( recordParams1 );

        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        ProductoInfoVo infoVo = new ProductoInfoVo();
        
        if (!returnData.isEmpty() ){
        	BeanUtils.copyProperties(infoVo, returnData.get(0));
        }
        
        return infoVo;
	}

}
