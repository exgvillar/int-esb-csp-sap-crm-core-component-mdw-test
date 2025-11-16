package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 * 
 */
public class SaveConfigurablesFieldsServiceImplTC extends TestCase {

	private static Log log = LogFactory
			.getLog(SaveConfigurablesFieldsServiceImplTC.class);

	/**
	 * 
	 */
	public SaveConfigurablesFieldsServiceImplTC() {

	}

	/**
	 * @param name
	 */
	public SaveConfigurablesFieldsServiceImplTC(String name) {
		super(name);

	}

	public void test() throws Exception {

		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();

		CRMLocalConfigEnvironmentData.instance();

		ArrayList<ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData> paramList = new ArrayList<ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData>();

		ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData data = new ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData();
		data.setId("3");
		data.setFieldName("monto-solicitado");
		data.setType("2");
		data.setValue("70000");
		data.setRatePriority(5);
		data.setRequestedBy("hsanchezag");
		data.setAuthorized(true);
		data.setAuthorizedBy("rbecerra");
		data.setActive(false);
		paramList.add(data);

		data = new ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData();
		data.setId("");
		data.setFieldName("fecha");
		data.setType("4");
		data.setValue("01/01/2016");
		data.setRatePriority(1);
		data.setRequestedBy("hsanchez");
		data.setAuthorized(true);
		data.setAuthorizedBy("aramme");
		data.setActive(true);
//		paramList.add( data );

		ArrayList<IProxyOutputData> returnList = processImpl
				.saveConfigurablesFields(paramList);

		log.info(returnList);

		assertNotNull(returnList);
	}

}
