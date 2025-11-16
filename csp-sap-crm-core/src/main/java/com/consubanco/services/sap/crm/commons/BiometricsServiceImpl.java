/**
 * 
 */
package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMCSB_P002_LOCK_BP_ProxyImpl;
import com.consubanco.services.sap.crm.commons.utils.Formatter;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class BiometricsServiceImpl implements BiometricsService{

	private static final Log log = LogFactory.getLog(BiometricsServiceImpl.class);
	
	/**
	 * UID por default
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BiometricsServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons.attachments.FingerPrintService#attachFingerPrint(java.lang.String, java.io.File)
	 */
	public ArrayList<IProxyOutputData> attachBiometricsByBP(String bpId, String fingerPrintBase64, String photoBase64) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl fp_ProxyImpl = new ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl();
		
		ArrayList<ProxyInputParameter> inputParamtersList = new ArrayList<ProxyInputParameter>();
		
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_PARTNER");
		input.setValue( Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty( bpId ), 10 ) );
		inputParamtersList.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_MODE");
		input.setValue("U");
		inputParamtersList.add(input);
		
		ArrayList<IProxyOutputData> returnData = null;
		/*
		 * La foto puede enviarse en arreglo de bytes
		 */
		byte[] decodePhoto = base64Decode(photoBase64);
		
		returnData = fp_ProxyImpl.executeRemoteFunction(destination, inputParamtersList, fingerPrintBase64, decodePhoto);
		
		log.info(returnData.toString());
		
		return returnData;
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons.attachments.FingerPrintService#getFingerPrint(java.lang.String, java.io.File)
	 */
	public ArrayList<IProxyOutputData> getGetBiometricsByBpId(String bpId, int typeBiometric)throws Exception {

		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl proxyImpl = new ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParamtersList = null;
		ProxyInputParameter inputParameter = null;

		inputParamtersList = new ArrayList<ProxyInputParameter>();

		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_MODE");
		inputParameter.setValue("R");
		inputParamtersList.add(inputParameter);
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_PARTNER");
		inputParameter.setValue( Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty( bpId ), 10 ) );
		inputParamtersList.add(inputParameter);


		ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList, typeBiometric);
		
		log.info(returnData.toString());

		return returnData;
	}
	
	private byte[] base64Decode( String str ){
		if(str == null) return null;
		
		return Base64.decodeBase64( str.getBytes() );
	}

	public ArrayList<IProxyOutputData> lockBP(String bpId, boolean isLock, int counter) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P002_LOCK_BP_ProxyImpl proxyImpl = new ZCRMCSB_P002_LOCK_BP_ProxyImpl();
		
		ArrayList<ProxyInputParameter> inputParamtersList = null;
		ProxyInputParameter inputParameter = null;

		inputParamtersList = new ArrayList<ProxyInputParameter>();
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_PARTNER");
		inputParameter.setValue( Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty( bpId ), 10 ) );
		inputParamtersList.add(inputParameter);

		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_BLOCK");
		inputParameter.setValue(isLock ? "X" : "");
		inputParamtersList.add(inputParameter);
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_ATTEMPTS");
		inputParameter.setValue(String.valueOf(counter));
		inputParamtersList.add(inputParameter);
		
		ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList);
		
		return ( returnData );
	}
}
