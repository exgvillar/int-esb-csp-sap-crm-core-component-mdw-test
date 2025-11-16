/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.recommender.impl.RecommenderServicesImpl;
import com.consubanco.services.sap.crm.recommender.model.SaveEnrollmentTaskRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class SaveEnrollmentTask_TC extends TestCase {

	private static Log log = LogFactory.getLog(SaveEnrollmentTask_TC.class);

	public void test() throws Exception {

		RecommenderServices processImpl = new RecommenderServicesImpl();

		CRMLocalConfigEnvironmentData.instance();

		SaveEnrollmentTaskRequest saveEnrollmentTaskRequest = new SaveEnrollmentTaskRequest();
		
		saveEnrollmentTaskRequest.setTaskId( "1750000052" );
		saveEnrollmentTaskRequest.setRecommenderBp( "0000847635" );
		saveEnrollmentTaskRequest.setEmployeeBP( "0010001934" );
		saveEnrollmentTaskRequest.setContactMedium( "" );
		saveEnrollmentTaskRequest.setContactSource( "" );
		saveEnrollmentTaskRequest.setObservations( "Comentario" );			

		ArrayList<IProxyOutputData> returnList = processImpl.saveEnrollmentTask(saveEnrollmentTaskRequest);

		log.info(returnList);

		assertNotNull(returnList);
	}
	
	
}
