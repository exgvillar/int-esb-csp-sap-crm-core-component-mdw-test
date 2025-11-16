/**
 * 
 */
package com.consupago.services.sap.crm.imss.sipre;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.imss.pensionados.ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImpl;
import com.consupago.services.sap.crm.imss.sipre.vo.ImssSipreInfoVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class GetImssServiceImpl implements GetImssInfoService {

	public ImssSipreInfoVo getImssSipreInfo(String idAccount, String idSolicitud)
			throws Exception {
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImpl proxy = new ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        if (StringUtils.trimToNull(idAccount) != null ){
        	String numFomado = new DecimalFormat("0000000000").format(new Integer(idAccount));
            input.setKey("I_NUMACC");
            input.setValue( numFomado );
            inputParams.add( input );
        } else if (StringUtils.trimToNull( idSolicitud ) != null){
        	String numFomado = new DecimalFormat("0000000000").format(new Integer(idSolicitud));
            input.setKey("I_NUMDOC");
            input.setValue( numFomado );
            inputParams.add( input );
        }

        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );

        ImssSipreInfoVo infoVo = new ImssSipreInfoVo();
        
        if (!returnData.isEmpty() ){
        	BeanUtils.copyProperties(infoVo, returnData.get(0));
        }
        
        return infoVo;
	}
	
	
	
}
