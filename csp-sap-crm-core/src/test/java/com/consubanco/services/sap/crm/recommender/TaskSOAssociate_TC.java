/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.recommender.impl.RecommenderServicesImpl;
import com.consubanco.services.sap.crm.recommender.model.TaskSOAssociateRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class TaskSOAssociate_TC extends TestCase {

	private static Log log = LogFactory.getLog(TaskSOAssociate_TC.class);

	public void test() throws Exception {

		RecommenderServices processImpl = new RecommenderServicesImpl();

		CRMLocalConfigEnvironmentData.instance();			

		TaskSOAssociateRequest taskSOAssociateRequest = new TaskSOAssociateRequest();
		taskSOAssociateRequest.setEnrollmentTaskId( "1750000005" );
		taskSOAssociateRequest.setServiceOrderId( "1525000191" );
		taskSOAssociateRequest.setRecommenderBp("1147");
		
		ArrayList<IProxyOutputData> returnList = processImpl.taskSOAssociate(taskSOAssociateRequest );

		log.info(returnList);

		assertNotNull(returnList);
	}	
}
