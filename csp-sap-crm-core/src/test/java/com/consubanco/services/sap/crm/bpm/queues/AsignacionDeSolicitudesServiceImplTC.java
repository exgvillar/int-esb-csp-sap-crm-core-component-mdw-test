/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZWRKQUEUE_UNASIGN_SOLS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author jrauluribes
 * 
 */
public class AsignacionDeSolicitudesServiceImplTC extends TestCase {
	private static Log log = LogFactory
			.getLog(AsignacionDeSolicitudesServiceImplTC.class);

	public void test() throws Exception {

		CRMBPMQueuesService processImpl = new CRMBPMQueuesServiceImpl();

		CRMLocalConfigEnvironmentData.instance();

		ArrayList<ZWRKQUEUE_UNASIGN_SOLS_Model> dataList = new ArrayList<ZWRKQUEUE_UNASIGN_SOLS_Model>();
		
		ZWRKQUEUE_UNASIGN_SOLS_Model model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		
		model.setBpId("10001942");
		model.setNumSol(1);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("10001950");
		model.setNumSol(2);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("10002295");
		model.setNumSol(3);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("10004651");
		model.setNumSol(4);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("0010006632");
		model.setNumSol(5);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("10006633");
		model.setNumSol(6);
		dataList.add(model);
		
		
		ArrayList<IProxyOutputData> returnList = processImpl.asignacionDeSolicitudes(dataList);

		log.info(returnList);

		assertNotNull(returnList);
	}
}
